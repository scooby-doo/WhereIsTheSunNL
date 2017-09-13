package common

import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.filter.Filter
import ch.qos.logback.core.spi.FilterReply

class WeatherTypeFilter  extends Filter[ILoggingEvent] {

  override def decide(event: ILoggingEvent): FilterReply = {
    if (event.getLoggerName.contains("models.WeatherType")) {
      FilterReply.ACCEPT
    } else {
      FilterReply.DENY
    }
  }
}