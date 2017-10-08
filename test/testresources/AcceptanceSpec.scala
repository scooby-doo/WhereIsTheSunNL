package testresources

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Millis, Seconds, Span}
import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, FeatureSpec, MustMatchers}
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.Application
import play.api.inject.bind
import play.api.inject.guice.GuiceApplicationBuilder
import services.QueryService

class AcceptanceSpec extends FeatureSpec
  with MustMatchers
  with ScalaFutures
  with BeforeAndAfter
  with BeforeAndAfterAll
  with GuiceOneAppPerSuite {

  implicit val defaultPatience: PatienceConfig = PatienceConfig(timeout = Span(5, Seconds), interval = Span(500, Millis))

  override lazy val app: Application = new GuiceApplicationBuilder()
    .overrides(bind[QueryService].to[FakeQueryService])
    .build()

}
