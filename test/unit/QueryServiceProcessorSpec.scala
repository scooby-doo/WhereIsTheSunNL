package unit

import common.UnitSpec
import common.TestData.groupByDayAndWeatherExpectedResponse
import services.QueryServiceProcessor

class QueryServiceProcessorSpec extends UnitSpec {

  val queryServiceProcessor: QueryServiceProcessor = app.injector.instanceOf(classOf[QueryServiceProcessor])

  "QueryServiceProcessorSpec" should {
    "group entries by day and weather text" in {
      queryServiceProcessor.groupByDayAndWeather().futureValue mustEqual groupByDayAndWeatherExpectedResponse
    }
  }
}
