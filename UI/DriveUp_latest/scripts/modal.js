// register modal component
Vue.component('modal', {
  iframe: '#openFrame'
})

window.onload = function () {
new Vue({
  el: '.bottomMenu',
  data: {
    showModal: false
  }
})
}