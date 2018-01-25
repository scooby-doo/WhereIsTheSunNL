package services

import testresources.TestData.groupByDayAndWeatherExpectedResponse
import services.impl.QueryServiceProcessorImpl
import testresources.UnitSpec

class QueryServiceProcessorSpec extends UnitSpec {

  val queryServiceProcessor: QueryServiceProcessorImpl = app.injector.instanceOf(classOf[QueryServiceProcessorImpl])

  "QueryServiceProcessorSpec" should {
    "group entries by day and weather text" in {
      queryServiceProcessor.groupByDayAndWeather().futureValue mustEqual groupByDayAndWeatherExpectedResponse
    }
  }
}
