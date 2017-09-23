package models

import com.typesafe.scalalogging.LazyLogging
import play.api.libs.json._

sealed trait WeatherType

object WeatherType extends LazyLogging {
  def apply(weatherType: String): WeatherType = weatherType match {
    case "Sunny" => SUNNY
    case "Mostly Sunny" => MOSTLY_SUNNY
    case x if x contains "Clear" => CLEAR
    case "Partly Cloudy" => PARTLY_CLOUDY
    case "Mostly Cloudy" => MOSTLY_CLOUDY
    case "Cloudy" => CLOUDY
    case "Breezy" => BREEZY
    case "Windy" => WINDY
    case "Rain" => RAIN
    case "Showers" => SHOWERS
    case "Thunderstorms" => SHOWERS
    case "Scattered Showers" => SCATTERED_SHOWERS
    case "Scattered Thunderstorms" => SCATTERED_THUNDERSTORMS
    case x=> YET_UNKNOWN_TYPE(x)
  }

  implicit val weatherTypeFormat: Format[WeatherType] = new Format[WeatherType] {
    def reads(json: JsValue): JsResult[WeatherType] = json match {
      case JsString(s) =>
        try {
          JsSuccess(WeatherType(json.as[String]))
        } catch {
          case _: scala.MatchError => JsError("Value is not in the list")
        }
      case _ => JsError("String values are expected")
    }

    def writes(weatherType: WeatherType): JsString = weatherType match {
      case SUNNY => JsString("Sunny")
      case MOSTLY_SUNNY => JsString("Mostly Sunny")
      case CLEAR => JsString("Clear")
      case PARTLY_CLOUDY => JsString("Partly Cloudy")
      case MOSTLY_CLOUDY => JsString("Mostly Cloudy")
      case CLOUDY => JsString("Cloudy")
      case BREEZY => JsString("Breezy")
      case WINDY => JsString("Windy")
      case RAIN => JsString("Rain")
      case SHOWERS => JsString("Showers")
      case SCATTERED_SHOWERS => JsString("Scattered Showers")
      case SCATTERED_THUNDERSTORMS => JsString("Scattered Thunderstorms")
      case THUNDERSTORMS => JsString("Thunderstorms")
      case YET_UNKNOWN_TYPE(x) => JsString(x.toString)
    }
  }

  case object SUNNY extends WeatherType
  case object MOSTLY_SUNNY extends WeatherType
  case object CLEAR extends WeatherType
  case object PARTLY_CLOUDY extends WeatherType
  case object MOSTLY_CLOUDY extends WeatherType
  case object CLOUDY extends WeatherType
  case object BREEZY extends WeatherType
  case object WINDY extends WeatherType
  case object RAIN extends WeatherType
  case object SHOWERS extends WeatherType
  case object SCATTERED_SHOWERS extends WeatherType
  case object SCATTERED_THUNDERSTORMS extends WeatherType
  case object THUNDERSTORMS extends WeatherType
  case class YET_UNKNOWN_TYPE(weatherType: String) extends WeatherType {
    logger.info("Added Unknown Type {}", weatherType)
  }

  val orderingList = List(SUNNY, MOSTLY_SUNNY, CLEAR, PARTLY_CLOUDY, MOSTLY_CLOUDY, CLOUDY, BREEZY, WINDY, RAIN, SHOWERS, SCATTERED_SHOWERS, SCATTERED_THUNDERSTORMS, THUNDERSTORMS, YET_UNKNOWN_TYPE)

  val sunnyWeatherList = List(SUNNY, MOSTLY_SUNNY, CLEAR, PARTLY_CLOUDY, MOSTLY_CLOUDY, CLOUDY, BREEZY, WINDY)

  def compare(first: WeatherType, second: WeatherType): Int = {
    if (orderingList.indexOf(first) > orderingList.indexOf(second))
      1
    else if (orderingList.indexOf(first) == orderingList.indexOf(second))
      0
    else orderingList.indexOf(first) < orderingList.indexOf(second)
      -1
  }

  def isNotRainyWeather(weatherType: WeatherType): Boolean = weatherType match {
    case x if sunnyWeatherList contains x => true
    case _ => false
  }
}