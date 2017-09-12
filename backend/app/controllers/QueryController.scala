package controllers

import javax.inject.Inject

import com.typesafe.scalalogging.LazyLogging
import play.api.cache._
import models.ImplicitFormats._
import models.{WeatherResponse, WeatherType}
import org.joda.time.{DateTime, LocalDate}
import play.api.libs.json.Json
import play.api.mvc._
import services.QueryServiceProcessor

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration._

class QueryController @Inject()(cache: AsyncCacheApi, queryServiceProcessor: QueryServiceProcessor, cc: ControllerComponents)
  extends AbstractController(cc) with LazyLogging {

  def findTheSun(): Action[AnyContent] =  Action.async {
    for {
      result <- getCachedValues
    } yield Ok(Json.toJson(result))
  }


  private def getCachedValues: Future[Map[(LocalDate, WeatherType), Seq[(String, WeatherResponse)]]] =
    cache.getOrElseUpdate[Map[(LocalDate, WeatherType), Seq[(String, WeatherResponse)]]]("weatherInformationResponse", 3.hours) {
      logger.info("{} sending request to real api - cache expired", DateTime.now())
      cache.remove("weatherInformationResponse")
      for {
        result <- queryServiceProcessor.groupByDayAndWeather()
        _ <- cache.set("weatherInformationResponse", result, 3.hours)
      } yield result
  }
}
