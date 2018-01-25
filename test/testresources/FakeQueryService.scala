package testresources

import javax.inject.Inject

import models.WeatherType._
import models.{SearchResponse, WeatherResponse}
import org.joda.time.LocalDate
import play.api.libs.ws.WSClient
import services.QueryService

import scala.concurrent.Future

class FakeQueryService @Inject()(ws: WSClient) extends QueryService{

  override def getWeatherForAllCities: Future[Seq[SearchResponse]]=  Future.successful(Seq(
    SearchResponse("Valkenburg aan de Geul",List(
      WeatherResponse("39", LocalDate.parse("2017-09-09"),"Sat","16","12",SCATTERED_THUNDERSTORMS),
      WeatherResponse("30", LocalDate.parse("2017-09-10"),"Sun","17","10",PARTLY_CLOUDY),
      WeatherResponse("12", LocalDate.parse("2017-09-11"),"Mon","16","12",RAIN),
      WeatherResponse("30", LocalDate.parse("2017-09-12"),"Tue","16","11",PARTLY_CLOUDY),
      WeatherResponse("12", LocalDate.parse("2017-09-13"),"Wed","17","13",RAIN),
      WeatherResponse("11", LocalDate.parse("2017-09-14"),"Thu","14","11",SHOWERS),
      WeatherResponse("39", LocalDate.parse("2017-09-15"),"Fri","14","10",SCATTERED_SHOWERS),
      WeatherResponse("39", LocalDate.parse("2017-09-16"),"Sat","15","10",SCATTERED_SHOWERS),
      WeatherResponse("28", LocalDate.parse("2017-09-17"),"Sun","16","10",MOSTLY_CLOUDY),
      WeatherResponse("28", LocalDate.parse("2017-09-18"),"Mon","16","11",MOSTLY_CLOUDY))),

    SearchResponse("Venlo",List(
      WeatherResponse("12", LocalDate.parse("2017-09-09"),"Sat","17","11",RAIN),
      WeatherResponse("30", LocalDate.parse("2017-09-10"),"Sun","18","8",PARTLY_CLOUDY),
      WeatherResponse("23", LocalDate.parse("2017-09-11"),"Mon","17","13",BREEZY),
      WeatherResponse("30", LocalDate.parse("2017-09-12"),"Tue","17","12",PARTLY_CLOUDY),
      WeatherResponse("12", LocalDate.parse("2017-09-13"),"Wed","17","13",RAIN),
      WeatherResponse("11", LocalDate.parse("2017-09-14"),"Thu","15","11",SHOWERS),
      WeatherResponse("39", LocalDate.parse("2017-09-15"),"Fri","16","10",SCATTERED_SHOWERS),
      WeatherResponse("12", LocalDate.parse("2017-09-16"),"Sat","16","10",RAIN),
      WeatherResponse("28", LocalDate.parse("2017-09-17"),"Sun","17","10",MOSTLY_CLOUDY),
      WeatherResponse("28", LocalDate.parse("2017-09-18"),"Mon","18","11",MOSTLY_CLOUDY))),

    SearchResponse("Vlissingen",List(
      WeatherResponse("39", LocalDate.parse("2017-09-09"),"Sat","16","12",SCATTERED_THUNDERSTORMS),
      WeatherResponse("30", LocalDate.parse("2017-09-10"),"Sun","18","10",PARTLY_CLOUDY),
      WeatherResponse("11", LocalDate.parse("2017-09-11"),"Mon","16","13",SHOWERS),
      WeatherResponse("12", LocalDate.parse("2017-09-12"),"Tue","16","12",RAIN),
      WeatherResponse("39", LocalDate.parse("2017-09-13"),"Wed","16","13",SCATTERED_SHOWERS),
      WeatherResponse("11", LocalDate.parse("2017-09-14"),"Thu","15","11",SHOWERS),
      WeatherResponse("12", LocalDate.parse("2017-09-15"),"Fri","15","11",RAIN),
      WeatherResponse("39", LocalDate.parse("2017-09-16"),"Sat","17","12",SCATTERED_SHOWERS),
      WeatherResponse("28", LocalDate.parse("2017-09-17"),"Sun","16","12",MOSTLY_CLOUDY),
      WeatherResponse("28", LocalDate.parse("2017-09-18"),"Mon","17","12",MOSTLY_CLOUDY))),

    SearchResponse("Volendam",List(
      WeatherResponse("12", LocalDate.parse("2017-09-09"),"Sat","17","12",RAIN),
      WeatherResponse("28", LocalDate.parse("2017-09-10"),"Sun","18","10",MOSTLY_CLOUDY),
      WeatherResponse("39", LocalDate.parse("2017-09-11"),"Mon","17","12",SCATTERED_SHOWERS),
      WeatherResponse("39", LocalDate.parse("2017-09-12"),"Tue","17","12",SCATTERED_SHOWERS),
      WeatherResponse("39", LocalDate.parse("2017-09-13"),"Wed","16","12",SCATTERED_SHOWERS),
      WeatherResponse("11", LocalDate.parse("2017-09-14"),"Thu","15","10",SHOWERS),
      WeatherResponse("12", LocalDate.parse("2017-09-15"),"Fri","15","11",RAIN),
      WeatherResponse("12", LocalDate.parse("2017-09-16"),"Sat","16","11",RAIN),
      WeatherResponse("28", LocalDate.parse("2017-09-17"),"Sun","17","11",MOSTLY_CLOUDY),
      WeatherResponse("28", LocalDate.parse("2017-09-18"),"Mon","18","11",MOSTLY_CLOUDY))),

    SearchResponse("Zaandam",List(
      WeatherResponse("12", LocalDate.parse("2017-09-09"),"Sat","17","12",RAIN),
      WeatherResponse("28", LocalDate.parse("2017-09-10"),"Sun","17","10",MOSTLY_CLOUDY),
      WeatherResponse("39", LocalDate.parse("2017-09-11"),"Mon","16","12",SCATTERED_SHOWERS),
      WeatherResponse("39", LocalDate.parse("2017-09-12"),"Tue","17","12",SCATTERED_SHOWERS),
      WeatherResponse("39", LocalDate.parse("2017-09-13"),"Wed","16","12",SCATTERED_SHOWERS),
      WeatherResponse("11", LocalDate.parse("2017-09-14"),"Thu","15","11",SHOWERS),
      WeatherResponse("39", LocalDate.parse("2017-09-15"),"Fri","15","11",SCATTERED_SHOWERS),
      WeatherResponse("28", LocalDate.parse("2017-09-16"),"Sat","16","11",MOSTLY_CLOUDY),
      WeatherResponse("28", LocalDate.parse("2017-09-17"),"Sun","17","11",MOSTLY_CLOUDY),
      WeatherResponse("28", LocalDate.parse("2017-09-18"),"Mon","17","11",MOSTLY_CLOUDY))),

    SearchResponse("Zandvoort",List(
      WeatherResponse("28", LocalDate.parse("2017-09-09"),"Sat","16","12",MOSTLY_CLOUDY),
      WeatherResponse("39", LocalDate.parse("2017-09-10"),"Sun","17","10",SCATTERED_SHOWERS),
      WeatherResponse("11", LocalDate.parse("2017-09-11"),"Mon","16","14",SHOWERS),
      WeatherResponse("39", LocalDate.parse("2017-09-12"),"Tue","17","14",SCATTERED_SHOWERS),
      WeatherResponse("11", LocalDate.parse("2017-09-13"),"Wed","16","13",SHOWERS),
      WeatherResponse("11", LocalDate.parse("2017-09-14"),"Thu","16","12",SHOWERS),
      WeatherResponse("11", LocalDate.parse("2017-09-15"),"Fri","16","13",SHOWERS),
      WeatherResponse("12", LocalDate.parse("2017-09-16"),"Sat","17","13",RAIN),
      WeatherResponse("28", LocalDate.parse("2017-09-17"),"Sun","17","14",MOSTLY_CLOUDY),
      WeatherResponse("28", LocalDate.parse("2017-09-18"),"Mon","17","13",MOSTLY_CLOUDY)))
  ))
}
