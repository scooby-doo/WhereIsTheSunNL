package common

import akka.Done
import akka.actor.{ActorRef, ActorSystem, Scheduler}
import akka.testkit.{ImplicitSender, TestActorRef, TestKit}
import testresources.TestData._
import models.{WeatherResponse, WeatherType}
import org.joda.time.LocalDate
import org.mockito.Mockito.{verify, when}
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{BeforeAndAfterAll, MustMatchers, WordSpecLike}
import play.api.cache.AsyncCacheApi
import services.QueryServiceProcessor

import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Future}

class WeatherActorSpec extends TestKit(ActorSystem("WeatherActorSpec")) with ImplicitSender
  with WordSpecLike with MustMatchers with BeforeAndAfterAll with MockitoSugar {

  val executor: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global

  var mockScheduler: Scheduler = _
  var queryProcessor: QueryServiceProcessor = _
  var cache: AsyncCacheApi = _
  var weatherActor: ActorRef = _
  val dur: FiniteDuration = (2.hours + 50.minutes).toMillis.millis
  val cacheGetResult: Future[Option[Map[(LocalDate, WeatherType), Seq[(String, WeatherResponse)]]]] = Future.successful(Option(groupByDayAndWeatherExpectedResponse))

  override def beforeAll: Unit = {
    queryProcessor = mock[QueryServiceProcessor]
    cache = mock[AsyncCacheApi]
    mockScheduler = mock[Scheduler]

    when(queryProcessor.groupByDayAndWeather()).thenReturn(Future.successful(groupByDayAndWeatherExpectedResponse))
    when(cache.set("weatherInformationResponse", groupByDayAndWeatherExpectedResponse, 3.hours)).thenReturn(Future.successful(Done))
    when(cache.get[Map[(LocalDate, WeatherType), Seq[(String, WeatherResponse)]]]("weatherInformationResponse")).thenReturn(cacheGetResult)

    weatherActor = TestActorRef(new WeatherActor(cache, queryProcessor){
      override def scheduler: Scheduler = mockScheduler
    })
  }

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "An Weather actor" must {

    "save the cache `weatherInformation` for three hours and make a schedule in 2 hours and 50 minutes" in {
      weatherActor ! WeatherActor.UpdateWeatherMessage

      expectNoMessage(200.millis)
      verify(queryProcessor).groupByDayAndWeather()
      verify(cache).set("weatherInformationResponse", groupByDayAndWeatherExpectedResponse, 3.hours)
      verify(mockScheduler).scheduleOnce(dur, weatherActor, WeatherActor.UpdateWeatherMessage)(executor, weatherActor)
    }

    "get the cached values" in {
      weatherActor ! WeatherActor.GetCache
      expectMsg( cacheGetResult )
      verify(cache).get[Map[(LocalDate, WeatherType), Seq[(String, WeatherResponse)]]]("weatherInformationResponse")
    }
  }
}
