//document.addEventListener('DOMContentLoaded', ()=>{
    var router = new VueRouter({
        mode: 'history',
        routes: []
    });
    const v = new Vue({
        router,
        el: '#orders',
        data : {
            orders: [],
            currentOrder: '',
        },

        created: function(){
           fetch('data.json').then(d=>d.json()).then(dd=>
           {
               this.orders = dd
               this.currentOrder = this.orders.find(obj => { return obj.orderNumber == v.$route.query.id })
           })
        },

        // goTo : function (where) {
        //     this.window = where;
        // },        
    });
    
//})



