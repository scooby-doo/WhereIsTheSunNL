$(function() {

  var list = $('[data-list]')
  currentCities = ["Aalsmeer", "Almere", "Alphen aan den Rijn", "Amersfoort", "Amsterdam",
   "Apeldoorn", "Arnhem", "Assen", "Bergen aan Zee", "Bloemendaal", "Breda",
   "Bolsward", "Cadzand", "Coevorden", "Delft", "Den Bosch", "Deventer",
   "Doesburg", "Doetinchem", "Dokkum", "Domburg", "Dordrecht", "Drachten",
   "Edam", "Eindhoven", "Elburg", "Emmeloord", "Emmen", "Enkhuizen",
   "Giethoorn", "Gouda", "Groningen", "Haarlem", "Harderwijk", "Harlingen",
   "Hasselt", "Hattem", "Heerenveen", "Heusden", "Hindeloopen", "Hoogeveen",
   "Hoorn", "IJlst", "Kampen", "Katwijk", "Kijkduin", "Leeuwarden", "Leiden",
   "Lelystad", "Maastricht", "Marken", "Meppel", "Middelburg", "Monnickendam",
   "Naarden", "Nijmegen", "Noordwijk", "Oostkapelle", "Ouddorp", "Renesse",
   "Rotterdam", "Scheveningen", "Sloten", "Sneek", "Stavoren", "The Hague", "Tilburg",
   "Utrecht", "Valkenburg aan de Geul", "Venlo", "Vlissingen", "Volendam",
   "Zaandam", "Zandvoort", "Zierikzee", "Zutphen", "Zwolle", "Workum"]

   list.empty()
   currentCities.map(function(city) {
     var li = $('<li/>', {
       class: 'mdl-list__item',
       text: city
     });
     list.append(li)
   })

   $(document).ready(function() {
   	$('.popup-with-form').magnificPopup({
   		type: 'inline',
   		preloader: false,
   		focus: '#name',

   		// When elemened is focused, some mobile browsers in some cases zoom in
   		// It looks not nice, so we disable it:
   		callbacks: {
   			beforeOpen: function() {
   				if($(window).width() < 700) {
   					this.st.focus = false;
   				} else {
   					this.st.focus = '#name';
   				}
   			}
   		}
   	});
   });

   $(document).on('click', '.popup-modal-dismiss', function (e) {
     e.preventDefault();
     $.magnificPopup.close();
   });

   $(document).on('click', '.popup-modal-submit-dismiss', function (e) {
     var name = $('#city-name').val()
     if (name.length > 0) {
       $.ajax({
         method: "POST",
         url: "/suggest-city",
         contentType: "application/json",
         data: '{"city": ' + '"' + name  + '"}'
       })
       .done(function(msg) {

         var notification = document.querySelector('.mdl-js-snackbar');
          notification.MaterialSnackbar.showSnackbar(
            {
              message: 'City submitted'
            }
        );
       });
     }
     e.preventDefault();
     $('#city-name').val("")
     $.magnificPopup.close();
   });
});
