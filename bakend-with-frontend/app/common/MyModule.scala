package common

import play.api.Configuration
import play.api.Environment
import play.api.inject._
import services.QueryService
import services.impl.QueryServiceImpl

class MyModule extends Module {
  def bindings(environment: Environment, configuration: Configuration): Seq[Binding[_]] = {
    Seq(
      bind[QueryService].to[QueryServiceImpl].eagerly()
    )
  }
}