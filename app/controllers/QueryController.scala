package controllers

import javax.inject.Inject

import models.ImplicitFormats._
import play.api.libs.json.Json
import play.api.mvc._
import services.QueryServiceProcessor

import scala.concurrent.ExecutionContext.Implicits.global

class QueryController @Inject()(queryServiceProcessor: QueryServiceProcessor, cc: ControllerComponents) extends AbstractController(cc) {

  def findThesun(): Action[AnyContent] =  Action.async {
    for {
      result <- queryServiceProcessor.groupByDayAndWeather()
    } yield Ok(Json.toJson(result))
  }
}
