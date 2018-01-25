package controllers

import javax.inject.{Inject, Named}

import akka.actor._
import akka.pattern.ask
import akka.util.Timeout
import com.typesafe.scalalogging.LazyLogging
import common.WeatherActor
import models.ImplicitFormats._
import models.{SuggestCityRequest, WeatherResponse, WeatherType}
import org.joda.time.LocalDate
import play.api.libs.json.{JsError, JsResult, JsValue, Json}
import play.api.mvc._
import common.ApiErrors._
import io.kanaka.monadic.dsl._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration._

class QueryController @Inject()(@Named(WeatherActor.Name) weatherActor: ActorRef, cc: ControllerComponents)
  extends AbstractController(cc) with LazyLogging {

  implicit lazy val timeout: Timeout = Timeout(5.seconds)

  def findTheSun(): Action[AnyContent] =  Action.async {
    for {
      result <- getCachedValues
    } yield Ok(Json.toJson(result))
  }

  def suggestCity(): Action[JsValue] =  Action.async(cc.parsers.json) { request =>
    for {
      city <- request.body.validate[SuggestCityRequest] ?| (err => badRequest(JsError.toJson(err)))
      _ =  logger.info("Suggested city: {}", city.city)
    } yield NoContent
  }


  private def getCachedValues: Future[Option[Map[(LocalDate, WeatherType), Seq[(String, WeatherResponse)]]]] =
    (weatherActor ? WeatherActor.GetCache).mapTo[Future[Option[Map[(LocalDate, WeatherType), Seq[(String, WeatherResponse)]]]]].flatten
}
