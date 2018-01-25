package services

import models.City
import testresources.IntegrationSpec

class QueryServiceIntegrationSpec extends IntegrationSpec {

  val queryService: QueryService = app.injector.instanceOf(classOf[QueryService])

  "QueryService" should {
    "get a list of all cities with their weather" in {
      queryService.getWeatherForAllCities.futureValue.size mustEqual City.citiesInNetherlands.size
    }
  }
}
