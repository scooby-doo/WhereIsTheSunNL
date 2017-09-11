package common

import models.ImplicitFormats.dateFormatter
import models.WeatherResponse
import models.WeatherType
import models.WeatherType._
import org.joda.time.LocalDate

object TestData {

  val dateSep09: LocalDate = LocalDate.parse("2017-09-09")
  val dateSep10: LocalDate = LocalDate.parse("2017-09-10")
  val dateSep11: LocalDate = LocalDate.parse("2017-09-11")
  val dateSep12: LocalDate = LocalDate.parse("2017-09-12")
  val dateSep13: LocalDate = LocalDate.parse("2017-09-13")
  val dateSep14: LocalDate = LocalDate.parse("2017-09-14")
  val dateSep15: LocalDate = LocalDate.parse("2017-09-15")
  val dateSep16: LocalDate = LocalDate.parse("2017-09-16")
  val dateSep17: LocalDate = LocalDate.parse("2017-09-17")
  val dateSep18: LocalDate = LocalDate.parse("2017-09-18")


  val groupByDayAndWeatherExpectedResponse: Map[(LocalDate, WeatherType), Seq[(String, WeatherResponse)]] = Map(
    (dateSep09,MOSTLY_CLOUDY) -> List(("Zandvoort",WeatherResponse("28", dateSep09,"Sat", "16" , "12" ,MOSTLY_CLOUDY))),
    (dateSep10,MOSTLY_CLOUDY) -> List(("Volendam",WeatherResponse("28", dateSep10,"Sun", "18" , "10" ,MOSTLY_CLOUDY)), ("Zaandam",WeatherResponse("28", dateSep10,"Sun", "17" , "10" ,MOSTLY_CLOUDY))),
    (dateSep10,PARTLY_CLOUDY) -> List(("Valkenburg aan de Geul",WeatherResponse("30", dateSep10,"Sun", "17" , "10" ,PARTLY_CLOUDY)), ("Venlo",WeatherResponse("30", dateSep10,"Sun", "18" , "8" ,PARTLY_CLOUDY)), ("Vlissingen",WeatherResponse("30", dateSep10,"Sun", "18" , "10" ,PARTLY_CLOUDY))),
    (dateSep11,BREEZY) -> List(("Venlo",WeatherResponse("23", dateSep11,"Mon", "17" , "13" ,BREEZY))),
    (dateSep12,PARTLY_CLOUDY) -> List(("Valkenburg aan de Geul",WeatherResponse("30", dateSep12,"Tue", "16" , "11" ,PARTLY_CLOUDY)), ("Venlo",WeatherResponse("30", dateSep12,"Tue", "17" , "12" ,PARTLY_CLOUDY))),
    (dateSep16,MOSTLY_CLOUDY) -> List(("Zaandam",WeatherResponse("28", dateSep16,"Sat", "16" , "11" ,MOSTLY_CLOUDY))),
    (dateSep17,MOSTLY_CLOUDY) -> List(("Valkenburg aan de Geul",WeatherResponse("28", dateSep17,"Sun", "16" , "10" ,MOSTLY_CLOUDY)), ("Venlo",WeatherResponse("28", dateSep17,"Sun", "17" , "10" ,MOSTLY_CLOUDY)), ("Vlissingen",WeatherResponse("28", dateSep17,"Sun", "16" , "12" ,MOSTLY_CLOUDY)), ("Volendam",WeatherResponse("28", dateSep17,"Sun", "17" , "11" ,MOSTLY_CLOUDY)), ("Zaandam",WeatherResponse("28", dateSep17,"Sun", "17" , "11" ,MOSTLY_CLOUDY)), ("Zandvoort",WeatherResponse("28", dateSep17,"Sun", "17" , "14" ,MOSTLY_CLOUDY))),
    (dateSep18,MOSTLY_CLOUDY) -> List(("Valkenburg aan de Geul",WeatherResponse("28", dateSep18,"Mon", "16" , "11" ,MOSTLY_CLOUDY)), ("Venlo",WeatherResponse("28", dateSep18,"Mon", "18" , "11" ,MOSTLY_CLOUDY)), ("Vlissingen",WeatherResponse("28", dateSep18,"Mon", "17" , "12" ,MOSTLY_CLOUDY)), ("Volendam",WeatherResponse("28", dateSep18,"Mon", "18" , "11" ,MOSTLY_CLOUDY)), ("Zaandam",WeatherResponse("28", dateSep18,"Mon", "17" , "11" ,MOSTLY_CLOUDY)), ("Zandvoort",WeatherResponse("28", dateSep18,"Mon", "17" , "13" ,MOSTLY_CLOUDY)))
  )
}
