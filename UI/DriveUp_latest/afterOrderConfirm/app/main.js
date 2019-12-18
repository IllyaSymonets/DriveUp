const v = new Vue({
    el: '#DriveUp-menu',
    data:{
        RoleToChange:'driver',
        RoleToChangeIcon:'local_taxi',
        window:'after-order',
    }
    ,
    methods:{
        changeRole: function(){
            if(this.RoleToChange === 'driver'){
                this.RoleToChange='customer';
                this.RoleToChangeIcon='airline_seat_recline_normal';
            }else{
                this.RoleToChange='driver';
                this.RoleToChangeIcon='local_taxi';
            }
        }
        ,
        goToWindow: function(where){
           this.window=where;
        }
    }
})