package services

import javax.inject.Inject

import models.{SearchResponse, WeatherResponse}
import org.joda.time.LocalDate

import scala.collection.immutable.SortedMap
import scala.concurrent.{ExecutionContext, Future}

class QueryServiceProcessor @Inject()(queryService: QueryService) (implicit ec: ExecutionContext) {

  implicit val keyOrdering1: Ordering[(LocalDate, String)] = Ordering[(org.joda.time.LocalDate, String)] { (x, y) =>
      x._1 compareTo y._1 match {
        case 0 =>
          x._2 compareTo y._2
        case c => c
      }
  }

  def groupByDayAndWeather(): Future[Map[(LocalDate, String), Seq[(String, WeatherResponse)]]] = {

    for {
      searchResponseList: Seq[SearchResponse] <- queryService.getWeatherForAllCities
      groupedResults = SortedMap(searchResponseList.flatMap { x => x.weatherResponseList.map(y => (x.city, y)) }.groupBy{case (_, wr) => (wr.date, wr.text)}.toSeq:_*)
    } yield groupedResults
  }

}
