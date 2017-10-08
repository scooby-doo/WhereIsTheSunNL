package common

import play.api.libs.json.{JsValue, Json}
import play.api.mvc.Results._

object ApiErrors {

  def badRequest(message: JsValue) = BadRequest(Json.toJson("INVALID_JSON", message.toString))

}
