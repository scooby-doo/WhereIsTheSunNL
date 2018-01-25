package scheduler

import javax.inject.{Inject, Named}

import akka.actor.{ActorRef, ActorSystem}
import common.WeatherActor
import play.api.inject.ApplicationLifecycle

import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Future}

class UpdateWeatherScheduler @Inject()(@Named(WeatherActor.Name) weatherActor: ActorRef, actorSystem: ActorSystem, lifecycle: ApplicationLifecycle)(implicit executionContext: ExecutionContext) {

  actorSystem.scheduler.scheduleOnce(0.millis, weatherActor, WeatherActor.UpdateWeatherMessage)

  // This is necessary to avoid thread leaks, specially if you are
  // using a custom ExecutionContext
  lifecycle.addStopHook{ () =>
    Future.successful(actorSystem.terminate())
  }
}