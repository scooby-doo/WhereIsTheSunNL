package services

import javax.inject.Inject

import models.{SearchResponse, WeatherResponse}
import models.SearchResponse._
import models.WeatherType._
import models.WeatherType
import org.joda.time.LocalDate

import scala.collection.immutable.SortedMap
import scala.concurrent.{ExecutionContext, Future}

class QueryServiceProcessor @Inject()(queryService: QueryService) (implicit ec: ExecutionContext) {

  implicit val keyOrdering: Ordering[(LocalDate, WeatherType)] = Ordering[(LocalDate, WeatherType)] { (x, y) =>
      x._1 compareTo y._1 match {
        case 0 => WeatherType.compare(x._2, y._2)
        case c => c
      }
  }

  def groupByDayAndWeather(): Future[Map[(LocalDate, WeatherType), Seq[(String, WeatherResponse)]]] = {

    for {
      searchResponseListNonFiltered <- queryService.getWeatherForAllCities
      searchResponseList = searchResponseListNonFiltered.map{ selectOnlySunnyWeather }
      groupedResults = SortedMap(searchResponseList.flatMap { x => x.weatherResponseList.map(y => (x.city, y)) }.groupBy{case (_, wr) => (wr.date, wr.text)}.toSeq:_*)
    } yield groupedResults
  }

}
