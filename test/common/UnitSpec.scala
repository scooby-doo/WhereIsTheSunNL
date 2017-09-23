package common

import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, MustMatchers, WordSpec}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Millis, Seconds, Span}
import org.scalatestplus.play.guice.GuiceOneServerPerSuite
import play.api.Application
import play.api.inject.bind
import play.api.inject.guice.GuiceApplicationBuilder
import services.{FakeQueryService, QueryService}

class UnitSpec extends WordSpec
  with MustMatchers
  with BeforeAndAfter
  with BeforeAndAfterAll
  with ScalaFutures
  with GuiceOneServerPerSuite {

  implicit val defaultPatience: PatienceConfig = PatienceConfig(timeout = Span(5, Seconds), interval = Span(500, Millis))

  override lazy val app: Application = new GuiceApplicationBuilder()
    .overrides(bind[QueryService].to[FakeQueryService])
    .build()
}
