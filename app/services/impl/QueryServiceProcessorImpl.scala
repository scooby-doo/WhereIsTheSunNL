package services.impl

import javax.inject.Inject

import models.{SearchResponse, WeatherResponse, WeatherType}
import org.joda.time.LocalDate
import services.{QueryService, QueryServiceProcessor}

import scala.collection.immutable.SortedMap
import scala.concurrent.{ExecutionContext, Future}

class QueryServiceProcessorImpl @Inject()(queryService: QueryService)(implicit ec: ExecutionContext) extends QueryServiceProcessor {

  implicit val keyOrdering: Ordering[(LocalDate, WeatherType)] = Ordering[(LocalDate, WeatherType)] { (x, y) =>
      x._1 compareTo y._1 match {
        case 0 => WeatherType.compare(x._2, y._2)
        case c => c
      }
  }

  override def groupByDayAndWeather(): Future[Map[(LocalDate, WeatherType), Seq[(String, WeatherResponse)]]] = {
    for {
      searchResponseList: Seq[SearchResponse] <- queryService.getWeatherForAllCities
      groupedResults = SortedMap(searchResponseList.flatMap { x => x.weatherResponseList.map(y => (x.city, y)) }.groupBy{case (_, wr) => (wr.date, wr.text)}.toSeq:_*)
    } yield groupedResults
  }

}
