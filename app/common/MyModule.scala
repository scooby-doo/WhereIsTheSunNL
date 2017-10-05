package common

import com.google.inject.AbstractModule
import play.api.libs.concurrent.AkkaGuiceSupport
import scheduler.UpdateWeatherScheduler
import services.{QueryService, QueryServiceProcessor}
import services.impl.{QueryServiceImpl, QueryServiceProcessorImpl}

class MyModule extends AbstractModule with AkkaGuiceSupport {
  override def configure = {
    bind(classOf[QueryService]).to(classOf[QueryServiceImpl])
    bind(classOf[QueryServiceProcessor]).to(classOf[QueryServiceProcessorImpl])
    bindActor[WeatherActor](WeatherActor.Name)
    bind(classOf[UpdateWeatherScheduler]).asEagerSingleton()
  }
}