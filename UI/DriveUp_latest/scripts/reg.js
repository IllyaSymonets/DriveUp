let drivers = [
    {
        "phone": "001",
        "password": "driver1"
    },
    {
        "phone": "002",
        "password": "driver2"
    },
    {
        "phone": "003",
        "password": "driver3"
    }
]

let customers = [
    {
        "phone": "001",
        "password": "user1"
    },
    {
        "phone": "002",
        "password": "user2"
    },
    {
        "phone": "003",
        "password": "user3"
    }
]

let user = {};


function searchEquals(arr, user1) {
    let result = false;

    for (let i = 0; i < arr.length; i++) {
        if (arr[i].phone == user1.phone && arr[i].password == user1.password) {
            result = true;
        }
    }
    return result;
}


document.querySelector('.btn_registration').onclick = (event) => {
    event.preventDefault();

    let phone = document.querySelector('#phone');
    let password1 = document.querySelector('#pass1');
    let password2 = document.querySelector('#pass2');
    let roleClient = document.querySelector('#radio_client');
    let roleDriver = document.querySelector('#radio_driver');
    let div_out = document.querySelector('.msg');

    user.phone = phone.value;
    user.password1 = password1.value;
    user.password2 = password2.value;

    if (user.password1 == user.password2) {

        if (roleDriver.checked) {

            if (searchEquals(drivers, user)) {
                div_out.innerHTML = 'This user already exist';
                div_out.style.marginBottom = '7%';
            } else {
                drivers.push(user);
                window.location.replace("login.html");
            }
        }

        if (roleClient.checked) {

            if (searchEquals(customers, user)) {
                div_out.innerHTML = 'This user already exist';
                div_out.style.marginBottom = '7%';
            } else {
                customers.push(user);
                window.location.replace("login.html");
            }
        }

    } else {
        div_out.innerHTML = 'Passwords are not equal';
        div_out.style.marginBottom = '7%';
    }
}