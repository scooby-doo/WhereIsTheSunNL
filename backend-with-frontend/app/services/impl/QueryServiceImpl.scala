package services.impl

import javax.inject.Inject

import models.{City, SearchResponse, WeatherResponse}
import models.ImplicitFormats._
import play.api.libs.ws.WSClient
import play.api.http.Status.OK
import services.QueryService

import scala.concurrent.{ExecutionContext, Future}
import scala.util.control.NonFatal

class QueryServiceImpl @Inject()(ws: WSClient) (implicit val ec: ExecutionContext) extends QueryService {

  import QueryServiceImpl._

  def getWeatherForAllCities: Future[Seq[SearchResponse]] = Future.sequence(City.citiesInNetherlands.map { sendRequest })

  private def sendRequest(city: String): Future[SearchResponse] = {
    val wsRequest = ws.url("https://query.yahooapis.com/v1/public/yql").addQueryStringParameters("q" -> query(city), "format" -> "json")
    for {
      response <- wsRequest.get()
      _ = if (response.status != OK) sys.error(s"Yahoo Search returned the status ${response.status} and response ${response.body}")
      weatherResponse: Seq[WeatherResponse] = wrapOnException(ex => s"The response from Yahoo Search could not be parsed, error is ${ex.getMessage}") {
        (response.json \ "query" \ "results" \ "channel" \ "item" \ "forecast" ).as[Seq[WeatherResponse]]
      }
      searchResponse = SearchResponse(city, weatherResponse)
    } yield searchResponse
  }

  private def query(city: String) = s"""select * from weather.forecast where woeid in (select woeid from geo.places(1) where text="${city.toLowerCase}, nl") and u = 'c'"""
}

object QueryServiceImpl {
  def wrapOnException[A](msg: Throwable => String)(fn: => A): A = {
    try {
      fn
    } catch {
      case NonFatal(cause) => throw new RuntimeException(msg(cause), cause)
    }
  }
}

