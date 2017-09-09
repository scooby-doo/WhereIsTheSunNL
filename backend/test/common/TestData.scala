package common

import models.ImplicitFormats.dateFormatter
import models.WeatherResponse
import org.joda.time.LocalDate

object TestData {

  val dateSep09: LocalDate = LocalDate.parse("2017-09-09", dateFormatter)
  val dateSep10: LocalDate = LocalDate.parse("2017-09-10", dateFormatter)
  val dateSep11: LocalDate = LocalDate.parse("2017-09-11", dateFormatter)
  val dateSep12: LocalDate = LocalDate.parse("2017-09-12", dateFormatter)
  val dateSep13: LocalDate = LocalDate.parse("2017-09-13", dateFormatter)
  val dateSep14: LocalDate = LocalDate.parse("2017-09-14", dateFormatter)
  val dateSep15: LocalDate = LocalDate.parse("2017-09-15", dateFormatter)
  val dateSep16: LocalDate = LocalDate.parse("2017-09-16", dateFormatter)
  val dateSep17: LocalDate = LocalDate.parse("2017-09-17", dateFormatter)
  val dateSep18: LocalDate = LocalDate.parse("2017-09-18", dateFormatter)


  val groupByDayAndWeatherExpectedResponse: Map[(LocalDate, String), Seq[(String, WeatherResponse)]] = Map(
    (dateSep16,"Rain") -> List(("Venlo",WeatherResponse("12", dateSep16,"Sat","16","10","Rain")), ("Volendam",WeatherResponse("12",dateSep16,"Sat","16","11","Rain")), ("Zandvoort",WeatherResponse("12",dateSep16,"Sat","17","13","Rain"))),
    (dateSep09,"Rain") -> List(("Venlo",WeatherResponse("12", dateSep09,"Sat", "17" , "11" ,"Rain")), ("Volendam",WeatherResponse("12", dateSep09,"Sat", "17" , "12" ,"Rain")), ("Zaandam",WeatherResponse("12", dateSep09,"Sat", "17" , "12" ,"Rain"))),
    (dateSep11,"Showers") -> List(("Vlissingen",WeatherResponse("11", dateSep11,"Mon", "16" , "13" ,"Showers")), ("Zandvoort",WeatherResponse("11", dateSep11,"Mon", "16" , "14" ,"Showers"))),
    (dateSep13,"Rain") -> List(("Valkenburg aan de Geul",WeatherResponse("12", dateSep13,"Wed", "17" , "13" ,"Rain")), ("Venlo",WeatherResponse("12", dateSep13,"Wed", "17" , "13" ,"Rain"))),
    (dateSep11,"Rain") -> List(("Valkenburg aan de Geul",WeatherResponse("12", dateSep11,"Mon", "16" , "12" ,"Rain"))),
    (dateSep13,"Scattered Showers") -> List(("Vlissingen",WeatherResponse("39",dateSep13,"Wed", "16" , "13" ,"Scattered Showers")), ("Volendam",WeatherResponse("39",dateSep13,"Wed", "16" , "12" ,"Scattered Showers")), ("Zaandam",WeatherResponse("39",dateSep13,"Wed", "16" , "12" ,"Scattered Showers"))),
    (dateSep11,"Breezy") -> List(("Venlo",WeatherResponse("23", dateSep11,"Mon", "17" , "13" ,"Breezy"))),
    (dateSep10,"Mostly Cloudy") -> List(("Volendam",WeatherResponse("28", dateSep10,"Sun", "18" , "10" ,"Mostly Cloudy")), ("Zaandam",WeatherResponse("28", dateSep10,"Sun", "17" , "10" ,"Mostly Cloudy"))),
    (dateSep13,"Showers") -> List(("Zandvoort",WeatherResponse("11", dateSep13,"Wed", "16" , "13" ,"Showers"))),
    (dateSep12,"Rain") -> List(("Vlissingen",WeatherResponse("12", dateSep12,"Tue", "16" , "12" ,"Rain"))),
    (dateSep09,"Scattered Thunderstorms") -> List(("Valkenburg aan de Geul",WeatherResponse("39",dateSep09,"Sat", "16" , "12" ,"Scattered Thunderstorms")), ("Vlissingen",WeatherResponse("39",dateSep09,"Sat", "16" , "12" ,"Scattered Thunderstorms"))),
    (dateSep09,"Mostly Cloudy") -> List(("Zandvoort",WeatherResponse("28", dateSep09,"Sat", "16" , "12" ,"Mostly Cloudy"))),
    (dateSep15,"Rain") -> List(("Vlissingen",WeatherResponse("12", dateSep15,"Fri", "15" , "11" ,"Rain")), ("Volendam",WeatherResponse("12", dateSep15,"Fri", "15" , "11" ,"Rain"))),
    (dateSep16,"Scattered Showers") -> List(("Valkenburg aan de Geul",WeatherResponse("39",dateSep16,"Sat", "15" , "10" ,"Scattered Showers")), ("Vlissingen",WeatherResponse("39",dateSep16,"Sat", "17" , "12" ,"Scattered Showers"))),
    (dateSep17,"Mostly Cloudy") -> List(("Valkenburg aan de Geul",WeatherResponse("28", dateSep17,"Sun", "16" , "10" ,"Mostly Cloudy")), ("Venlo",WeatherResponse("28", dateSep17,"Sun", "17" , "10" ,"Mostly Cloudy")), ("Vlissingen",WeatherResponse("28", dateSep17,"Sun", "16" , "12" ,"Mostly Cloudy")), ("Volendam",WeatherResponse("28", dateSep17,"Sun", "17" , "11" ,"Mostly Cloudy")), ("Zaandam",WeatherResponse("28", dateSep17,"Sun", "17" , "11" ,"Mostly Cloudy")), ("Zandvoort",WeatherResponse("28", dateSep17,"Sun", "17" , "14" ,"Mostly Cloudy"))),
    (dateSep12,"Scattered Showers") -> List(("Volendam",WeatherResponse("39",dateSep12,"Tue", "17" , "12" ,"Scattered Showers")), ("Zaandam",WeatherResponse("39",dateSep12,"Tue", "17" , "12" ,"Scattered Showers")), ("Zandvoort",WeatherResponse("39",dateSep12,"Tue", "17" , "14" ,"Scattered Showers"))),
    (dateSep16,"Mostly Cloudy") -> List(("Zaandam",WeatherResponse("28", dateSep16,"Sat", "16" , "11" ,"Mostly Cloudy"))),
    (dateSep12,"Partly Cloudy") -> List(("Valkenburg aan de Geul",WeatherResponse("30", dateSep12,"Tue", "16" , "11" ,"Partly Cloudy")), ("Venlo",WeatherResponse("30", dateSep12,"Tue", "17" , "12" ,"Partly Cloudy"))),
    (dateSep18,"Mostly Cloudy") -> List(("Valkenburg aan de Geul",WeatherResponse("28", dateSep18,"Mon", "16" , "11" ,"Mostly Cloudy")), ("Venlo",WeatherResponse("28", dateSep18,"Mon", "18" , "11" ,"Mostly Cloudy")), ("Vlissingen",WeatherResponse("28", dateSep18,"Mon", "17" , "12" ,"Mostly Cloudy")), ("Volendam",WeatherResponse("28", dateSep18,"Mon", "18" , "11" ,"Mostly Cloudy")), ("Zaandam",WeatherResponse("28", dateSep18,"Mon", "17" , "11" ,"Mostly Cloudy")), ("Zandvoort",WeatherResponse("28", dateSep18,"Mon", "17" , "13" ,"Mostly Cloudy"))),
    (dateSep14,"Showers") -> List(("Valkenburg aan de Geul",WeatherResponse("11", dateSep14,"Thu", "14" , "11" ,"Showers")), ("Venlo",WeatherResponse("11", dateSep14,"Thu", "15" , "11" ,"Showers")), ("Vlissingen",WeatherResponse("11", dateSep14,"Thu", "15" , "11" ,"Showers")), ("Volendam",WeatherResponse("11", dateSep14,"Thu", "15" , "10" ,"Showers")), ("Zaandam",WeatherResponse("11", dateSep14,"Thu", "15" , "11" ,"Showers")), ("Zandvoort",WeatherResponse("11", dateSep14,"Thu", "16" , "12" ,"Showers"))),
    (dateSep15,"Scattered Showers") -> List(("Valkenburg aan de Geul",WeatherResponse("39",dateSep15,"Fri", "14" , "10" ,"Scattered Showers")), ("Venlo",WeatherResponse("39",dateSep15,"Fri", "16" , "10" ,"Scattered Showers")), ("Zaandam",WeatherResponse("39",dateSep15,"Fri", "15" , "11" ,"Scattered Showers"))),
    (dateSep10,"Partly Cloudy") -> List(("Valkenburg aan de Geul",WeatherResponse("30", dateSep10,"Sun", "17" , "10" ,"Partly Cloudy")), ("Venlo",WeatherResponse("30", dateSep10,"Sun", "18" , "8" ,"Partly Cloudy")), ("Vlissingen",WeatherResponse("30", dateSep10,"Sun", "18" , "10" ,"Partly Cloudy"))),
    (dateSep10,"Scattered Showers") -> List(("Zandvoort",WeatherResponse("39",dateSep10,"Sun", "17" , "10" ,"Scattered Showers"))),
    (dateSep11,"Scattered Showers") -> List(("Volendam",WeatherResponse("39",dateSep11,"Mon", "17" , "12" ,"Scattered Showers")), ("Zaandam",WeatherResponse("39",dateSep11,"Mon", "16" , "12" ,"Scattered Showers"))),
    (dateSep15,"Showers") -> List(("Zandvoort",WeatherResponse("11", dateSep15,"Fri", "16" , "13" ,"Showers"))))

}
