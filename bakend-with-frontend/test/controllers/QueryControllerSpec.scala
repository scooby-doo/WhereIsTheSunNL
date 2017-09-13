package controllers

import common.AcceptanceSpec
import play.api.test._
import play.api.test.Helpers._

class QueryControllerSpec extends AcceptanceSpec {

  info("The GET /")
  feature("get a list of cities grouped by date and wheater type") {
    scenario("everything is fine") {
      val request = FakeRequest("GET", "/")
      val response = route(app, request).get

      status(response) mustEqual 200
    }
  }
}
