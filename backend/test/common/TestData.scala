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
    (dateSep16,RAIN) -> List(("Venlo",WeatherResponse("12", dateSep16,"Sat","16","10",RAIN)), ("Volendam",WeatherResponse("12",dateSep16,"Sat","16","11",RAIN)), ("Zandvoort",WeatherResponse("12",dateSep16,"Sat","17","13",RAIN))),
    (dateSep09,RAIN) -> List(("Venlo",WeatherResponse("12", dateSep09,"Sat", "17" , "11" ,RAIN)), ("Volendam",WeatherResponse("12", dateSep09,"Sat", "17" , "12" ,RAIN)), ("Zaandam",WeatherResponse("12", dateSep09,"Sat", "17" , "12" ,RAIN))),
    (dateSep11,SHOWERS) -> List(("Vlissingen",WeatherResponse("11", dateSep11,"Mon", "16" , "13" ,SHOWERS)), ("Zandvoort",WeatherResponse("11", dateSep11,"Mon", "16" , "14" ,SHOWERS))),
    (dateSep13,RAIN) -> List(("Valkenburg aan de Geul",WeatherResponse("12", dateSep13,"Wed", "17" , "13" ,RAIN)), ("Venlo",WeatherResponse("12", dateSep13,"Wed", "17" , "13" ,RAIN))),
    (dateSep11,RAIN) -> List(("Valkenburg aan de Geul",WeatherResponse("12", dateSep11,"Mon", "16" , "12" ,RAIN))),
    (dateSep13,SCATTERED_SHOWERS) -> List(("Vlissingen",WeatherResponse("39",dateSep13,"Wed", "16" , "13" ,SCATTERED_SHOWERS)), ("Volendam",WeatherResponse("39",dateSep13,"Wed", "16" , "12" ,SCATTERED_SHOWERS)), ("Zaandam",WeatherResponse("39",dateSep13,"Wed", "16" , "12" ,SCATTERED_SHOWERS))),
    (dateSep11,BREEZY) -> List(("Venlo",WeatherResponse("23", dateSep11,"Mon", "17" , "13" ,BREEZY))),
    (dateSep10,MOSTLY_CLOUDY) -> List(("Volendam",WeatherResponse("28", dateSep10,"Sun", "18" , "10" ,MOSTLY_CLOUDY)), ("Zaandam",WeatherResponse("28", dateSep10,"Sun", "17" , "10" ,MOSTLY_CLOUDY))),
    (dateSep13,SHOWERS) -> List(("Zandvoort",WeatherResponse("11", dateSep13,"Wed", "16" , "13" ,SHOWERS))),
    (dateSep12,RAIN) -> List(("Vlissingen",WeatherResponse("12", dateSep12,"Tue", "16" , "12" ,RAIN))),
    (dateSep09,SCATTERED_THUNDERSTORMS) -> List(("Valkenburg aan de Geul",WeatherResponse("39",dateSep09,"Sat", "16" , "12" ,SCATTERED_THUNDERSTORMS)), ("Vlissingen",WeatherResponse("39",dateSep09,"Sat", "16" , "12" ,SCATTERED_THUNDERSTORMS))),
    (dateSep09,MOSTLY_CLOUDY) -> List(("Zandvoort",WeatherResponse("28", dateSep09,"Sat", "16" , "12" ,MOSTLY_CLOUDY))),
    (dateSep15,RAIN) -> List(("Vlissingen",WeatherResponse("12", dateSep15,"Fri", "15" , "11" ,RAIN)), ("Volendam",WeatherResponse("12", dateSep15,"Fri", "15" , "11" ,RAIN))),
    (dateSep16,SCATTERED_SHOWERS) -> List(("Valkenburg aan de Geul",WeatherResponse("39",dateSep16,"Sat", "15" , "10" ,SCATTERED_SHOWERS)), ("Vlissingen",WeatherResponse("39",dateSep16,"Sat", "17" , "12" ,SCATTERED_SHOWERS))),
    (dateSep17,MOSTLY_CLOUDY) -> List(("Valkenburg aan de Geul",WeatherResponse("28", dateSep17,"Sun", "16" , "10" ,MOSTLY_CLOUDY)), ("Venlo",WeatherResponse("28", dateSep17,"Sun", "17" , "10" ,MOSTLY_CLOUDY)), ("Vlissingen",WeatherResponse("28", dateSep17,"Sun", "16" , "12" ,MOSTLY_CLOUDY)), ("Volendam",WeatherResponse("28", dateSep17,"Sun", "17" , "11" ,MOSTLY_CLOUDY)), ("Zaandam",WeatherResponse("28", dateSep17,"Sun", "17" , "11" ,MOSTLY_CLOUDY)), ("Zandvoort",WeatherResponse("28", dateSep17,"Sun", "17" , "14" ,MOSTLY_CLOUDY))),
    (dateSep12,SCATTERED_SHOWERS) -> List(("Volendam",WeatherResponse("39",dateSep12,"Tue", "17" , "12" ,SCATTERED_SHOWERS)), ("Zaandam",WeatherResponse("39",dateSep12,"Tue", "17" , "12" ,SCATTERED_SHOWERS)), ("Zandvoort",WeatherResponse("39",dateSep12,"Tue", "17" , "14" ,SCATTERED_SHOWERS))),
    (dateSep16,MOSTLY_CLOUDY) -> List(("Zaandam",WeatherResponse("28", dateSep16,"Sat", "16" , "11" ,MOSTLY_CLOUDY))),
    (dateSep12,PARTLY_CLOUDY) -> List(("Valkenburg aan de Geul",WeatherResponse("30", dateSep12,"Tue", "16" , "11" ,PARTLY_CLOUDY)), ("Venlo",WeatherResponse("30", dateSep12,"Tue", "17" , "12" ,PARTLY_CLOUDY))),
    (dateSep18,MOSTLY_CLOUDY) -> List(("Valkenburg aan de Geul",WeatherResponse("28", dateSep18,"Mon", "16" , "11" ,MOSTLY_CLOUDY)), ("Venlo",WeatherResponse("28", dateSep18,"Mon", "18" , "11" ,MOSTLY_CLOUDY)), ("Vlissingen",WeatherResponse("28", dateSep18,"Mon", "17" , "12" ,MOSTLY_CLOUDY)), ("Volendam",WeatherResponse("28", dateSep18,"Mon", "18" , "11" ,MOSTLY_CLOUDY)), ("Zaandam",WeatherResponse("28", dateSep18,"Mon", "17" , "11" ,MOSTLY_CLOUDY)), ("Zandvoort",WeatherResponse("28", dateSep18,"Mon", "17" , "13" ,MOSTLY_CLOUDY))),
    (dateSep14,SHOWERS) -> List(("Valkenburg aan de Geul",WeatherResponse("11", dateSep14,"Thu", "14" , "11" ,SHOWERS)), ("Venlo",WeatherResponse("11", dateSep14,"Thu", "15" , "11" ,SHOWERS)), ("Vlissingen",WeatherResponse("11", dateSep14,"Thu", "15" , "11" ,SHOWERS)), ("Volendam",WeatherResponse("11", dateSep14,"Thu", "15" , "10" ,SHOWERS)), ("Zaandam",WeatherResponse("11", dateSep14,"Thu", "15" , "11" ,SHOWERS)), ("Zandvoort",WeatherResponse("11", dateSep14,"Thu", "16" , "12" ,SHOWERS))),
    (dateSep15,SCATTERED_SHOWERS) -> List(("Valkenburg aan de Geul",WeatherResponse("39",dateSep15,"Fri", "14" , "10" ,SCATTERED_SHOWERS)), ("Venlo",WeatherResponse("39",dateSep15,"Fri", "16" , "10" ,SCATTERED_SHOWERS)), ("Zaandam",WeatherResponse("39",dateSep15,"Fri", "15" , "11" ,SCATTERED_SHOWERS))),
    (dateSep10,PARTLY_CLOUDY) -> List(("Valkenburg aan de Geul",WeatherResponse("30", dateSep10,"Sun", "17" , "10" ,PARTLY_CLOUDY)), ("Venlo",WeatherResponse("30", dateSep10,"Sun", "18" , "8" ,PARTLY_CLOUDY)), ("Vlissingen",WeatherResponse("30", dateSep10,"Sun", "18" , "10" ,PARTLY_CLOUDY))),
    (dateSep10,SCATTERED_SHOWERS) -> List(("Zandvoort",WeatherResponse("39",dateSep10,"Sun", "17" , "10" ,SCATTERED_SHOWERS))),
    (dateSep11,SCATTERED_SHOWERS) -> List(("Volendam",WeatherResponse("39",dateSep11,"Mon", "17" , "12" ,SCATTERED_SHOWERS)), ("Zaandam",WeatherResponse("39",dateSep11,"Mon", "16" , "12" ,SCATTERED_SHOWERS))),
    (dateSep15,SHOWERS) -> List(("Zandvoort",WeatherResponse("11", dateSep15,"Fri", "16" , "13" ,SHOWERS))))

}
