package models

import org.joda.time.LocalDate
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}
import play.api.libs.json._
import WeatherType._

case class WeatherResponse(code: String, date: LocalDate, day: String, high: String, low: String, text: WeatherType)
case class SearchResponse(city: String, weatherResponseList: Seq[WeatherResponse])
case class SuggestCityRequest(city: String)

object SearchResponse {
  def selectOnlySunnyWeather(searchResponse: SearchResponse): SearchResponse = {
    val newList = searchResponse.weatherResponseList.filter { wr =>  isNotRainyWeather(wr.text) }
    searchResponse.copy(weatherResponseList = newList)
  }
}

object ImplicitFormats {
  val dateFormatter: DateTimeFormatter = DateTimeFormat.forPattern("dd MMM yyyy")

  implicit val jodaDateWrites: Writes[LocalDate] = Writes[LocalDate](date => JsString(date.toString(dateFormatter)))

  implicit val jodaDateReads: Reads[LocalDate] = Reads[LocalDate](js =>
    js.validate[String].map[LocalDate] { dtString =>
      LocalDate.parse(dtString, dateFormatter)
    })

  implicit val weatherResponseFormat: Format[WeatherResponse] = Json.format[WeatherResponse]
  implicit val searchResponseFormat: Format[SearchResponse] = Json.format[SearchResponse]
  implicit val suggestCityRequestFormat: Format[SuggestCityRequest] = Json.format[SuggestCityRequest]

  implicit val mapWrites: Writes[Map[(LocalDate, WeatherType), Seq[(String, WeatherResponse)]]] = Writes[Map[(LocalDate, WeatherType), Seq[(String, WeatherResponse)]]] ( map =>
      Json.toJson(
        map.map {
          case (key, value) =>
            Json.obj(
              "date" -> key._1,
              "weatherType" -> key._2,
              "cities" -> JsArray(value.map{ case (city, weather) => Json.obj("city" -> city, "weather" -> weather)})
            )
        }
      )
  )
}

object City {
  val citiesInNetherlands: Seq[String] = List(
    "Aalsmeer", "Almere", "Alphen aan den Rijn", "Amersfoort", "Amsterdam",
    "Apeldoorn", "Arnhem", "Assen", "Bergen aan Zee", "Bloemendaal", "Breda",
    "Bolsward", "Cadzand", "Coevorden", "Delft", "Den Bosch", "Deventer",
    "Doesburg", "Doetinchem", "Dokkum", "Domburg", "Dordrecht", "Drachten",
    "Edam", "Eindhoven", "Elburg", "Emmeloord", "Emmen", "Enkhuizen",
    "Giethoorn", "Gouda", "Groningen", "Haarlem", "Harderwijk", "Harlingen",
    "Hasselt", "Hattem", "Heerenveen", "Heusden", "Hindeloopen", "Hoogeveen",
    "Hoorn", "IJlst", "Kampen", "Katwijk", "Kijkduin", "Leeuwarden", "Leiden",
    "Lelystad", "Maastricht", "Marken", "Meppel", "Middelburg", "Monnickendam",
    "Naarden", "Nijmegen", "Noordwijk", "Oostkapelle", "Ouddorp", "Renesse",
    "Rotterdam", "Scheveningen", "Sloten", "Sneek", "Stavoren", "The Hague", "Tilburg",
    "Utrecht", "Valkenburg aan de Geul", "Venlo", "Vlissingen", "Volendam",
    "Zaandam", "Zandvoort", "Zierikzee", "Zutphen", "Zwolle", "Workum"
  )
}



