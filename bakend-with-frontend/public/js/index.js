$(document).ready(function() {
   var days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
   var rainy = ["Rain", "Showers", "Thunderstorms", "Scattered Showers", "Scattered Thunderstorms"]

   $.ajax({
     url: "http://localhost:9000/get-info"
   })
   .done(function(data) {
     loadList(data)
   });

   loadList = function(weatherInfo) {
          Array.prototype.groupBy = function(prop) {
            return this.reduce(function(groups, item) {
              var val = item[prop];
              groups[val] = groups[val] || [];
              groups[val].push(item);
              return groups;
            }, {});
          }

          Array.prototype.flatMap = function(lambda) {
              return Array.prototype.concat.apply([], this.map(lambda));
          };

          Array.prototype.contains = function(obj) {
                 var i = this.length;
                 while (i--) {
                     if (this[i] == obj) {
                         return true;
                     }
                 }
                 return false;
             }


         var groupedByDate = weatherInfo.groupBy('date')

          $.each(groupedByDate, function(key, value) {
            var goodWeather = value.filter( function(el) {
                return el.date && !rainy.contains(el.weatherType) && el.cities
            })

              var allCitiesUnsorted = goodWeather.flatMap(function(city){ return city.cities})
              var allCities = sortByKey(allCitiesUnsorted, "city")

              var dayName = days[new Date(key).getDay()];

              if (allCities.length > 0) {


                // $('#app').append(
                //     $('<div>').attr('class','demo-card-wide mdl-card mdl-shadow--2dp').append(
                //         $('<div>').attr('class','mdl-card__title blue-title').append(dayName + ", " + key ),
                //         $('<div>').attr('class','mdl-card__supporting-text scroll').append(
                //             allCities.map(function(city) {
                //               return $('<div>').attr('class','demo-card-small mdl-card mdl-shadow--2dp').append(
                //                        $('<div>').attr('class','mdl-card__title row').append(
                //                           city.city + " " + city.weather.low + " " + city.weather.high + " " + city.weather.text )
                //                        )
                //             })
                //         )
                //     )
                // );

                $('#app').append(
                    $('<div>').attr('class','demo-card-wide mdl-card mdl-shadow--2dp').append(
                        $('<div>').attr('class','mdl-card__title blue-title').append(dayName + ", " + key ),
                        $('<div>').attr('class','mdl-card__supporting-text scroll').append(
                            allCities.map(function(city) {

                              var table = $('<table></table>').addClass('mdl-data-table mdl-js-data-table mdl-data-table mdl-shadow--2dp full-width');

                              var row = '<tr>' +
                                '<td class="full-width">' + city.city + '</td>' +
                                '<td class="full-width">' + city.weather.low + '&#176; ' + city.weather.high +  '&#8451' + '</td>' +
                                // '<td class="full-width">' + city.weather.text + '</td>' +
                                '</tr>'
                                return table.append(row);
                            })
                        )
                    )
                );
              } else {
                $('#app').append(
                    $('<div>').attr('class','demo-card-no-weather mdl-card mdl-shadow--2dp').append(
                        $('<div>').attr('class','mdl-card__title blue-title').append(dayName + ", " + key ),
                        $('<div>').attr('class','mdl-card__supporting-text scroll center-no-weather').append(
                          "Could not find cities with good weather :("
                        )
                    )
                );
              }

          });
    }

    function sortByKey(array, key) {
      return array.sort(function(a, b) {
        var x = a[key]; var y = b[key];
        return ((x < y) ? -1 : ((x > y) ? 1 : 0));
      });
    }
})
