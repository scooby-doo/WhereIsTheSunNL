package controllers

import play.api.libs.json._
import play.api.test.Helpers._
import play.api.test._
import testresources.AcceptanceSpec
import testresources.TestData._

class QueryControllerSpec extends AcceptanceSpec {

  info("The GET /get-info")
  feature("get a list of cities grouped by date and wheater type") {
    scenario("everything is fine") {
      val request = FakeRequest("GET", "/get-info")
      val response = route(app, request).get

      status(response) mustEqual 200
      contentType(response) mustBe Some("application/json")
    }
  }

  info("The POST /suggest-city")
  feature("Log suggested city") {
    scenario("Passing a valid request body should log the city and return 204 No Content") {
      val request = FakeRequest("POST", "/suggest-city").withBody(city)
      val response = route(app, request).get

      status(response) mustEqual 204
      contentType(response) mustBe None
    }
  }

  feature("Returns an error") {
    scenario("Empty json is passed as the request body") {
      val request = FakeRequest("POST", "/suggest-city").withBody(Json.parse("{}"))
      val response = route(app, request).get

      status(response) mustEqual 400
    }

    scenario("Empty string for the city field is passed in the request body") {
      val request = FakeRequest("POST", "/suggest-city").withBody(city.transform(__.json.update((__ \ "city").json.put(JsString("")))).get)
      val response = route(app, request).get

      status(response) mustEqual 400
    }
  }
}
