package services.impl

import javax.inject.Inject

import models.ImplicitFormats._
import models.SearchResponse
import models.City._
import play.api.http.Status.OK
import play.api.libs.ws.WSClient
import services.QueryService

import scala.concurrent.{ExecutionContext, Future}
import scala.util.control.NonFatal

class QueryServiceImpl @Inject()(ws: WSClient) (implicit val ec: ExecutionContext) extends QueryService {

  import QueryServiceImpl._

  def getWeatherForAllCities: Future[Seq[SearchResponse]] = {
    val wsRequest = ws.url("https://query.yahooapis.com/v1/public/yql").addQueryStringParameters("q" -> query, "format" -> "json")

    for {
      response <- wsRequest.get()
      _ = if (response.status != OK) sys.error(s"Yahoo Search returned the status ${response.status} and response ${response.body}")

      result = wrapOnException(ex => s"The response from Yahoo Search could not be parsed, error is ${ex.getMessage}") {
        (response.json \ "query" \ "results" \ "channel" ).as[Seq[SearchResponse]]
      }

    } yield result
  }


  private val query = {
    val allCities = citiesInNetherlands.map(x => "\"" + x + ", nl" + "\"").mkString(",")
    s"""select * from weather.forecast where woeid in (select woeid from geo.places(1) where text in ($allCities)) and u = 'c'"""
  }
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

