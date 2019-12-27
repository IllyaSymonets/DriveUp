// new Vue({
//   el: '#driver',
//   data() {
//     return {
//       drivers: null
//     };
//   },
//   mounted() {
//     axios
//       .get('http://localhost:8761/driveUp/driver/driver/profile/2d20af1a-7a03-478d-854c-1e141675b62b')
//       .then(response => (this.drivers = response.data));
//   }
// });

new Vue({
  el: '#tester',
  data() {
    return {
      tester: null
    };
  },
  mounted() {
    axios
      .post('http://localhost:8888/brain/registration', {
        "phone" : "luboi",
        "password": "luboiTojje"
      })
      .then(response => (this.tester = response.status));
  }
});


// new Vue({
//   el: '#billing',
//   data() {
//     return {
//       billings: null
//     };
//   },
//   mounted() {
//     axios
//       .get('http://localhost:8080/allBills')
//       .then(response => (this.billings = response.data));
//   }
// });

// new Vue({
//   el: '#customers',
//   data() {
//     return {
//       customers: []
//     };
//   },
//   mounted() {
//     axios
//       .get('http://localhost:8761/driveUp/customer/customers/get_all')
//       .then(response => (this.customers = response.data));
//   }
// });

var obj = this.drivers
console.log(obj);

// drivers.forEach(function searchInfo(item) {
//   console.log("name:" + item.firstName +", " + "e-mail:" + item.email);
// });


// new Vue({
//   el: '#find',
//   data(){
//     return {
//      info: null
//     };
//   },
//   mounted() {
//     axios
//       .post('http://localhost:8081/driver/find', {
//       babyCarSeat: "true",
//       conditioner: "true",
//       courier: "true",
//       english: "true",
//       nonSmoker: "true",
//       pet: "true",
//       silence: "true",
//       type: "Business"
//   })
//   .then(response => (this.info = response.data));
//   }
// });

// new Vue({
//   el: '#profile',
//   data(){
//     return {
//       info: null
//     };
//   },
//   mounted() {
//      axios
//       .get('http://localhost:8081/driver/profile/888c7d81-6424-485f-b68c-16ed745c8892')
//       .then(response => (this.info = response.data));
//   }
// });


// function Table(data){

//   let keys = ["city", "firstName", "lastName", "email", "phone"];
  
//   function getLine(obj, keys) {
//     let tempX = "";
//     for(let i = 0; i < keys.length; i++) {
//       tempX += "<td>" + obj[keys[i]] + "</td>";
//     }
//     return "<tr>" + tempX + "</tr>";
//   }

//   function getBody() {
//     let tempY = "";
//     for (let i = 0; i < data.length; i++) {
//       tempY += getLine(data[i], keys);
//     }
//     return tempY;
//   }

//   this.render = function render () {
//     document.write( `<table>${getBody()}</table>` );
//   }
// }

// [new Table(x)].forEach(function(item) {
//   if (item instanceof Table) {
//     item.render()
//   }
// })


