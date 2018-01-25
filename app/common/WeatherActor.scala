package common

import javax.inject.Inject

import akka.actor.{Actor, ActorLogging, Scheduler}
import models.{WeatherResponse, WeatherType}
import org.joda.time.LocalDate
import play.api.cache.AsyncCacheApi
import services.QueryServiceProcessor

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

class WeatherActor @Inject()(cache: AsyncCacheApi, queryServiceProcessor: QueryServiceProcessor) extends Actor with ActorLogging  {
  override def receive: Receive = {
    case WeatherActor.UpdateWeatherMessage =>
      log.info("Sending request to real api - cache is about to expire")

      queryServiceProcessor.groupByDayAndWeather().map { result =>
        cache.set("weatherInformationResponse", result, 3.hours)
      }

      val delay: Long = (2.hours + 50.minutes).toMillis
      scheduler.scheduleOnce(delay.millis, self, WeatherActor.UpdateWeatherMessage)

    case WeatherActor.GetCache =>
      sender ! cache.get[Map[(LocalDate, WeatherType), Seq[(String, WeatherResponse)]]]("weatherInformationResponse")

    case unknown => log.info("received unknown actor message {}", unknown)
  }

  def scheduler: Scheduler = context.system.scheduler
}

object WeatherActor {
  final val Name = "weather-actor"

  sealed trait WeatherActorMessage
  case object UpdateWeatherMessage extends WeatherActorMessage
  case object GetCache extends WeatherActorMessage
}
