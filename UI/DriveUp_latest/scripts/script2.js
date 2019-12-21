var place;
const v = new Vue({
  el : '#maps',

  data: {
    window : 'start-address',


    startAddress : '',
    endAddress : '',
    time : '',
    year : '',
    month : '',
    day : '',
    insidePlace : place,
    inpStAddr: document.querySelector('#start')
  },

  methods : {
    goTo : function (where) {
      this.window = where;
    },
    CourierClick : function (){
      var elem = document.querySelector("#courier");
      elem.classList.toggle("courier--content");
      elem.classList.toggle("comfort--color");
    },
       BabySeatClick : function (){
      var elem = document.querySelector("#babySeat");
      elem.classList.toggle("babySeat--content");
      elem.classList.toggle("comfort--color");
     },
     ConditionerClick : function (){
      var elem = document.querySelector("#conditioner");
      elem.classList.toggle("conditioner--content");
      elem.classList.toggle("comfort--color");
     },
     EnglishClick : function (){
      var elem = document.querySelector("#english");
      elem.classList.toggle("english--content");
      elem.classList.toggle("comfort--color");
     },
     NonSmokerClick : function (){
      var elem = document.querySelector("#nonSmoker");
      elem.classList.toggle("nonSmoker--content");
      elem.classList.toggle("comfort--color");
     },
     PetsClick : function (){
      var elem = document.querySelector("#pets");
      elem.classList.toggle("pets--content");
      elem.classList.toggle("comfort--color");
     },
     SilenceClick : function (){
      var elem = document.querySelector("#silecne");
      elem.classList.toggle("silecne--content");
      elem.classList.toggle("comfort--color");
     },
   
    EconomClick : function (){
      document.all.econom.src = "cars/EconomCar.png";
      document.all.business.src = "cars/BusinessCarBW.png";
      document.all.VIP.src = "cars/VIPCarBW.png";
      document.all.minivan.src = "cars/MinivanCarBW.png";
      document.querySelector(".econom--selected").style.backgroundColor = "#292e34";
      document.querySelector(".business--selected").style.backgroundColor = "#68747d";
      document.querySelector(".VIP--selected").style.backgroundColor = "#68747d";
      document.querySelector(".Minivan--selected").style.backgroundColor = "#68747d";
  },
  businessClick : function (){
      document.all.econom.src = "cars/EconomCarBW.png";
      document.all.business.src = "cars/BusinessCar.png";
      document.all.VIP.src = "cars/VIPCarBW.png";
      document.all.minivan.src = "cars/MinivanCarBW.png";
      document.querySelector(".econom--selected").style.backgroundColor = "#68747d";
      document.querySelector(".business--selected").style.backgroundColor = "#292e34";
      document.querySelector(".VIP--selected").style.backgroundColor = "#68747d";
      document.querySelector(".Minivan--selected").style.backgroundColor = "#68747d";
  },
  VIPClick : function (){

      document.all.econom.src = "cars/EconomCarBW.png";
      document.all.business.src = "cars/BusinessCarBW.png";
      document.all.VIP.src = "cars/VIPCar.png";
      document.all.minivan.src = "cars/MinivanCarBW.png";
      document.querySelector(".econom--selected").style.backgroundColor = "#68747d";
      document.querySelector(".business--selected").style.backgroundColor = "#68747d";
      document.querySelector(".VIP--selected").style.backgroundColor = "#292e34";
      document.querySelector(".Minivan--selected").style.backgroundColor = "#68747d";
  },
  MinivanClick : function (){
      document.all.econom.src = "cars/EconomCarBW.png";
      document.all.business.src = "cars/BusinessCarBW.png";
      document.all.VIP.src = "cars/VIPCarBW.png";
      document.all.minivan.src = "cars/MinivanCar.png";
      document.querySelector(".econom--selected").style.backgroundColor = "#68747d";
      document.querySelector(".business--selected").style.backgroundColor = "#68747d";
      document.querySelector(".VIP--selected").style.backgroundColor = "#68747d";
      document.querySelector(".Minivan--selected").style.backgroundColor = "#292e34";
  },
  DisplayModal : function(){
    document.querySelector(".modal-frame").style.display = "block";
    document.querySelector(".disable-all").style.display = "block";
  },




    // calcRoute : function () {
    //   origin: document.getElementById('start'),
  //     destination: document.getElementById('end'),
    //   var request = {
    //     origin: start,
    //     destination: end,
    //     travelMode: 'DRIVING'
    //   };
    //   directionsService.route(request, function(result, status) {
    //     if (status == 'OK') {
    //       directionsRenderer.setDirections(result);
    //     }
    //   });
    // }
    
                                          // myFunction : function() {
                                          //   // myVar = setTimeout(inChange, 500);
                                          //   startAddress = setInterval(function(){ inChange(); }, 500);
                                          // }
  }

  

  //   calcRoute : function () {

  //     for (i = 0; i < markerArray.length; i++) {
  //       markerArray[i].setMap(null);
  //     }

  //     // var startInput = document.getElementById('start');
  //     var start =  startAutocomplete.getPlace();

  //     // var endInput = document.getElementById('end');
  //     var end = startAutocomplete.getPlace();
  //     // var start = autocomplete.getPlace();
  //     // var end = autocomplete.getPlace();;
  //     var request = {
  //       origin: start,
  //       destination: end,
  //       travelMode: 'DRIVING'
  //     };
  //     directionsService.route(request, function(result, status) {
  //       if (status == 'OK') {
  //         directionsRenderer.setDirections(result);
  //       }
  //     });
  //   }
  // })

                                        // function inChange(){
                                        //   this.startAddress = this.inpStAddr.value;
                                        //   return startAddress;
                                        // }
});


// Configure map
var map;
var marker;
var directionsService;
var directionsRenderer;
var markerArray = [];
var startAutocomplete;
var endAutocomplete;


function createMap () {
  directionsService = new google.maps.DirectionsService();
  var options = {
    center: { lat: 48.4647, lng: 35.0462 },
    zoom: 12,
    disableDefaultUI: true,
    mapTypeControlOptions: {
      style: google.maps.MapTypeControlStyle.DEFAULT,
    }
  },
  map = new google.maps.Map(document.getElementById('map'), options);
  
  var rendererOptions = {
    map: map
  }
  directionsRenderer = new google.maps.DirectionsRenderer(rendererOptions);
  directionsRenderer.setMap(map);

  //Bias search results to Dnipropetrovsk Oblast
  var defaultBounds = new google.maps.LatLngBounds(
    new google.maps.LatLng(48.3447, 34.9899),
    new google.maps.LatLng(48.5725, 35.0869),
  );
          // var defaultBounds = {'country': 'ua'};
  var autocopmleteOptions = {
    bounds : defaultBounds,
    types: ['address']
  };
  //Configure autocomplete
  
  var start = document.getElementById('start');
  autocomplete = new google.maps.places.Autocomplete(start, autocopmleteOptions);
  place =  autocomplete.getPlace();
  // var inputValue = place.name + " " + place.formatted_address;
  var end = document.getElementById('end');
  endAutocomplete = new google.maps.places.Autocomplete(end, autocopmleteOptions);



  // var onChangeHandler = function() {
  //   calculateAndDisplayRoute(directionsService, directionsRenderer);
  // };
  // document.getElementById('start').addEventListener('change', onChangeHandler);
  // document.getElementById('end').addEventListener('change', onChangeHandler);

                  // Configure marker either with infowindow or without it. By default - plain marker without infowindow
                  // var infowindow = new google.maps.InfoWindow();
  var endmarker = new google.maps.Marker({
    map: map,
    draggable : true
  });

  var marker = new google.maps.Marker({
    map: map,
    draggable : true
  });

  google.maps.event.addListener(autocomplete, 'place_changed', function() {
    // infowindow.close();
    marker.setVisible(false);
    var place = autocomplete.getPlace();
    if (!place.geometry) {
      return;
    }
    // If the place has a geometry, then present it on a map.
    if (place.geometry.viewport) {
      map.fitBounds(place.geometry.viewport);
    } else {
      map.setCenter(place.geometry.location);
      map.setZoom(12);  
    }
    marker.setIcon(({
      url: place.icon,
      size: new google.maps.Size(71, 71),
      origin: new google.maps.Point(0, 0),
      anchor: new google.maps.Point(17, 34),
      scaledSize: new google.maps.Size(35, 35)
    }));
    marker.setPosition(place.geometry.location);
    marker.setVisible(true);
  },
    google.maps.event.addListener(endAutocomplete, 'place_changed', function() {
      // infowindow.close();
      endmarker.setVisible(false);
      var place = endAutocomplete.getPlace();
      if (!place.geometry) {
        return;
      }
      // If the place has a geometry, then present it on a map.
      if (place.geometry.viewport) {
        map.fitBounds(place.geometry.viewport);
      } else {
        map.setCenter(place.geometry.location);
        map.setZoom(12);  
      }
      endmarker.setIcon(({
        url: place.icon,
        size: new google.maps.Size(71, 71),
        origin: new google.maps.Point(0, 0),
        anchor: new google.maps.Point(17, 34),
        scaledSize: new google.maps.Size(35, 35)
      }));
      endmarker.setPosition(place.geometry.location);
      endmarker.setVisible(true);
}));
  }




  // function calcRoute() {
  //   for (i = 0; i < markerArray.length; i++) {
  //           markerArray[i].setMap(null);
  //         }

  //   var start = autocomplete.getPlace();
  //   var end = endAutocomplete.getPlace();
  //   var request = {
  //     origin: start,
  //     destination: end,
  //     travelMode: 'DRIVING'
  //   };
  //   directionsService.route(request, function(result, status) {
  //     if (status == 'OK') {
  //       directionsRenderer.setDirections(result);
  //     }
  //   });
  // }

  // function calculateAndDisplayRoute(directionsService, directionsRenderer) {
  //   directionsService.route({
  //     origin: document.getElementById('start'),
  //     destination: document.getElementById('end'),
  //     travelMode: 'DRIVING'
  //   }, function(response, status) {
  //     if (status === 'OK') {
  //       directionsRenderer.setDirections(response);
  //     } else {
  //       window.alert('Directions request failed due to ' + status);
  //     }
  //   });
  // }

  // function calculateAndDisplayRoute(directionsService, directionsRenderer) {
  //   directionsService.route(
  //       {
  //         origin: {query: document.getElementById('start')},
  //         destination: {query: document.getElementById('end')},
  //         travelMode: 'DRIVING'
  //       },
  //       function(response, status) {
  //         if (status === 'OK') {
  //           directionsRenderer.setDirections(response);
  //         } else {
  //           window.alert('Directions request failed due to ' + status);
  //         }
  //       });
  // }


  function calcRoute() {
    var start = this.startAddress;
    var end = this.endAddress;
    var request = {
      origin: start,
      destination: end,
      travelMode: 'DRIVING'
    };
    directionsService.route(request, function(result, status) {
      if (status == 'OK') {
        directionsRenderer.setDirections(result);
      }
    });
  }

  

  // var onChangeHandler = function() {
  //   calculateAndDisplayRoute(directionsService, directionsRenderer);
  // };
  // document.getElementById('start').addEventListener('change', onChangeHandler);
  // document.getElementById('end').addEventListener('change', onChangeHandler);

  
            
  
          /* Most probably, not needed*/
  // function doAutocomplete() {
  //   const element = document.getElementById('start')
  //   this.autocomplete = new google.maps.places.Autocomplete(element)
  
  //   this.autocomplete.addListener('place_changed', () => {
  //   const place = this.autocomplete.getPlace()
  
  //   if (!place.geometry) {
  //     this.startAddress = ''
        
  //     console.log(startAddress);
  //   }
  // })
  // }

  

   // Get the address details from the place returned by autocomplete for Infowindow.
   // var address = '';
   // if (place.address_components) {
   //   address = [
   //     (place.address_components[0] && place.address_components[0].short_name || ''),
   //     (place.address_components[1] && place.address_components[1].short_name || ''),
   //     (place.address_components[2] && place.address_components[2].short_name || '')
   //   ].join(' ');
   // }
   // infowindow.setContent('<div><strong>' + place.name + '</strong><br>' + address);
   // infowindow.open(map, marker);
   // infowindow.open(map, marker);




  // var searchInput = 'start-input';

  // $(document).ready(function () {
  //     var autocomplete;
  //     autocomplete = new google.maps.places.Autocomplete((document.getElementById(searchInput)), {
  //         types: ['geocode'],
  //     });
    
  //     google.maps.event.addListener(autocomplete, 'change', function () {
  //         var place = autocomplete.getPlace();
  //         startAddress = extractFromAdress(place.address_components, "locality");
  //         document.getElementById('city').value = town;
          
  //     });
  // });

 
  

// function BabySeatClick(){
//     document.getElementById("babySeat").style.background = '#416d85';
// }
// function ConditionerClick(){
//     document.getElementById("conditioner").style.background = '#416d85';
// }
// function EnglishClick(){
//     document.getElementById("english").style.background = '#416d85';
// }
// function NonSmokerClick(){
//     document.getElementById("nonSmoker").style.background = '#416d85';
// }
// function PetsClick(){
//     document.getElementById("pets").style.background = '#416d85';
// }
// function SilenceClick(){
//     document.getElementById("silecne").style.background = '#416d85';
// }

// }