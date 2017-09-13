package common

import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.filter.Filter
import ch.qos.logback.core.spi.FilterReply

class ApplicationFilter  extends Filter[ILoggingEvent] {

  override def decide(event: ILoggingEvent): FilterReply = {
    if (isApplicationLogger(event.getLoggerName)) {
      FilterReply.ACCEPT
    } else {
      FilterReply.DENY
    }
  }

  private def isApplicationLogger(incomingLoggerName: String) = {
    !List("models.WeatherType", "controllers.QueryController").exists(
      loggerName => incomingLoggerName.contains(loggerName))
  }
}