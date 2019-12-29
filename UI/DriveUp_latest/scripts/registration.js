const v = new Vue({

    el : '#registration',

    data:{
        phone:'',
        password:'',
        passwordConfirmed:'',
        role:'client',
        response: null
    },

    methods:{
        isPasswordEquals: function () {
            if(this.password!=this.passwordConfirmed){
                document.querySelector('.msg').innerHTML = 'Passwords are not equal';
                document.querySelector('.msg').style.marginBottom = '7%';
            }
            return this.password==this.passwordConfirmed;     
        },
        createUser: function(){
            if(this.role=='client'){
                if(this.isPasswordEquals()){
                    axios
                        .post('http://localhost:8888/brain/registration', {
                            "phone" : this.phone,
                            "password": this.password
                        })
                        .then(response => (this.response = response.status))
                        .then(function(){
                            if(v.response==200){
                                window.location.replace("login.html");
                            }
                        });  
                }
            }else{

            }
        }
    }
})