package controllers

import play.api.test.FakeRequest
import play.api.test.Helpers._
import testresources.AcceptanceSpec

class MainControllerSpec extends AcceptanceSpec {

  info("The GET /")
  feature("get the index page") {
    scenario("returns successfully the index page") {
      val request = FakeRequest("GET", "/")
      val response = route(app, request).get

      status(response) mustEqual 200
      contentType(response) mustBe Some("text/html")
    }
  }

}
