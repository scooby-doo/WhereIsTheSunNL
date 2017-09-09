package services

import javax.inject.Inject

import models.ImplicitFormats.dateFormatter
import models.{SearchResponse, WeatherResponse}
import org.joda.time.LocalDate
import play.api.libs.ws.WSClient

import scala.concurrent.Future

class FakeQueryService @Inject()(ws: WSClient) extends QueryService{

  override def getWeatherForAllCities: Future[Seq[SearchResponse]]=  Future.successful(Seq(
    SearchResponse("Valkenburg aan de Geul",List(
      WeatherResponse("39", LocalDate.parse("2017-09-09", dateFormatter),"Sat","16","12","Scattered Thunderstorms"),
      WeatherResponse("30", LocalDate.parse("2017-09-10", dateFormatter),"Sun","17","10","Partly Cloudy"),
      WeatherResponse("12", LocalDate.parse("2017-09-11", dateFormatter),"Mon","16","12","Rain"),
      WeatherResponse("30", LocalDate.parse("2017-09-12", dateFormatter),"Tue","16","11","Partly Cloudy"),
      WeatherResponse("12", LocalDate.parse("2017-09-13", dateFormatter),"Wed","17","13","Rain"),
      WeatherResponse("11", LocalDate.parse("2017-09-14", dateFormatter),"Thu","14","11","Showers"),
      WeatherResponse("39", LocalDate.parse("2017-09-15", dateFormatter),"Fri","14","10","Scattered Showers"),
      WeatherResponse("39", LocalDate.parse("2017-09-16", dateFormatter),"Sat","15","10","Scattered Showers"),
      WeatherResponse("28", LocalDate.parse("2017-09-17", dateFormatter),"Sun","16","10","Mostly Cloudy"),
      WeatherResponse("28", LocalDate.parse("2017-09-18", dateFormatter),"Mon","16","11","Mostly Cloudy"))),

    SearchResponse("Venlo",List(
      WeatherResponse("12", LocalDate.parse("2017-09-09", dateFormatter),"Sat","17","11","Rain"),
      WeatherResponse("30", LocalDate.parse("2017-09-10", dateFormatter),"Sun","18","8","Partly Cloudy"),
      WeatherResponse("23", LocalDate.parse("2017-09-11", dateFormatter),"Mon","17","13","Breezy"),
      WeatherResponse("30", LocalDate.parse("2017-09-12", dateFormatter),"Tue","17","12","Partly Cloudy"),
      WeatherResponse("12", LocalDate.parse("2017-09-13", dateFormatter),"Wed","17","13","Rain"),
      WeatherResponse("11", LocalDate.parse("2017-09-14", dateFormatter),"Thu","15","11","Showers"),
      WeatherResponse("39", LocalDate.parse("2017-09-15", dateFormatter),"Fri","16","10","Scattered Showers"),
      WeatherResponse("12", LocalDate.parse("2017-09-16", dateFormatter),"Sat","16","10","Rain"),
      WeatherResponse("28", LocalDate.parse("2017-09-17", dateFormatter),"Sun","17","10","Mostly Cloudy"),
      WeatherResponse("28", LocalDate.parse("2017-09-18", dateFormatter),"Mon","18","11","Mostly Cloudy"))),

    SearchResponse("Vlissingen",List(
      WeatherResponse("39", LocalDate.parse("2017-09-09", dateFormatter),"Sat","16","12","Scattered Thunderstorms"),
      WeatherResponse("30", LocalDate.parse("2017-09-10", dateFormatter),"Sun","18","10","Partly Cloudy"),
      WeatherResponse("11", LocalDate.parse("2017-09-11", dateFormatter),"Mon","16","13","Showers"),
      WeatherResponse("12", LocalDate.parse("2017-09-12", dateFormatter),"Tue","16","12","Rain"),
      WeatherResponse("39", LocalDate.parse("2017-09-13", dateFormatter),"Wed","16","13","Scattered Showers"),
      WeatherResponse("11", LocalDate.parse("2017-09-14", dateFormatter),"Thu","15","11","Showers"),
      WeatherResponse("12", LocalDate.parse("2017-09-15", dateFormatter),"Fri","15","11","Rain"),
      WeatherResponse("39", LocalDate.parse("2017-09-16", dateFormatter),"Sat","17","12","Scattered Showers"),
      WeatherResponse("28", LocalDate.parse("2017-09-17", dateFormatter),"Sun","16","12","Mostly Cloudy"),
      WeatherResponse("28", LocalDate.parse("2017-09-18", dateFormatter),"Mon","17","12","Mostly Cloudy"))),

    SearchResponse("Volendam",List(
      WeatherResponse("12", LocalDate.parse("2017-09-09", dateFormatter),"Sat","17","12","Rain"),
      WeatherResponse("28", LocalDate.parse("2017-09-10", dateFormatter),"Sun","18","10","Mostly Cloudy"),
      WeatherResponse("39", LocalDate.parse("2017-09-11", dateFormatter),"Mon","17","12","Scattered Showers"),
      WeatherResponse("39", LocalDate.parse("2017-09-12", dateFormatter),"Tue","17","12","Scattered Showers"),
      WeatherResponse("39", LocalDate.parse("2017-09-13", dateFormatter),"Wed","16","12","Scattered Showers"),
      WeatherResponse("11", LocalDate.parse("2017-09-14", dateFormatter),"Thu","15","10","Showers"),
      WeatherResponse("12", LocalDate.parse("2017-09-15", dateFormatter),"Fri","15","11","Rain"),
      WeatherResponse("12", LocalDate.parse("2017-09-16", dateFormatter),"Sat","16","11","Rain"),
      WeatherResponse("28", LocalDate.parse("2017-09-17", dateFormatter),"Sun","17","11","Mostly Cloudy"),
      WeatherResponse("28", LocalDate.parse("2017-09-18", dateFormatter),"Mon","18","11","Mostly Cloudy"))),

    SearchResponse("Zaandam",List(
      WeatherResponse("12", LocalDate.parse("2017-09-09", dateFormatter),"Sat","17","12","Rain"),
      WeatherResponse("28", LocalDate.parse("2017-09-10", dateFormatter),"Sun","17","10","Mostly Cloudy"),
      WeatherResponse("39", LocalDate.parse("2017-09-11", dateFormatter),"Mon","16","12","Scattered Showers"),
      WeatherResponse("39", LocalDate.parse("2017-09-12", dateFormatter),"Tue","17","12","Scattered Showers"),
      WeatherResponse("39", LocalDate.parse("2017-09-13", dateFormatter),"Wed","16","12","Scattered Showers"),
      WeatherResponse("11", LocalDate.parse("2017-09-14", dateFormatter),"Thu","15","11","Showers"),
      WeatherResponse("39", LocalDate.parse("2017-09-15", dateFormatter),"Fri","15","11","Scattered Showers"),
      WeatherResponse("28", LocalDate.parse("2017-09-16", dateFormatter),"Sat","16","11","Mostly Cloudy"),
      WeatherResponse("28", LocalDate.parse("2017-09-17", dateFormatter),"Sun","17","11","Mostly Cloudy"),
      WeatherResponse("28", LocalDate.parse("2017-09-18", dateFormatter),"Mon","17","11","Mostly Cloudy"))),

    SearchResponse("Zandvoort",List(
      WeatherResponse("28", LocalDate.parse("2017-09-09", dateFormatter),"Sat","16","12","Mostly Cloudy"),
      WeatherResponse("39", LocalDate.parse("2017-09-10", dateFormatter),"Sun","17","10","Scattered Showers"),
      WeatherResponse("11", LocalDate.parse("2017-09-11", dateFormatter),"Mon","16","14","Showers"),
      WeatherResponse("39", LocalDate.parse("2017-09-12", dateFormatter),"Tue","17","14","Scattered Showers"),
      WeatherResponse("11", LocalDate.parse("2017-09-13", dateFormatter),"Wed","16","13","Showers"),
      WeatherResponse("11", LocalDate.parse("2017-09-14", dateFormatter),"Thu","16","12","Showers"),
      WeatherResponse("11", LocalDate.parse("2017-09-15", dateFormatter),"Fri","16","13","Showers"),
      WeatherResponse("12", LocalDate.parse("2017-09-16", dateFormatter),"Sat","17","13","Rain"),
      WeatherResponse("28", LocalDate.parse("2017-09-17", dateFormatter),"Sun","17","14","Mostly Cloudy"),
      WeatherResponse("28", LocalDate.parse("2017-09-18", dateFormatter),"Mon","17","13","Mostly Cloudy")))
  ))
}
