package services

import models.SearchResponse

import scala.concurrent.Future

trait QueryService {
  def getWeatherForAllCities: Future[Seq[SearchResponse]]
}

