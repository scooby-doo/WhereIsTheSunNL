package services

import models.{WeatherResponse, WeatherType}
import org.joda.time.LocalDate

import scala.concurrent.Future

trait QueryServiceProcessor {

  def groupByDayAndWeather():  Future[Map[(LocalDate, WeatherType), Seq[(String, WeatherResponse)]]]

}
