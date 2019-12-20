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

document.querySelector('.btn_login').onclick = (event) => {
    event.preventDefault();

    let phone = document.querySelector('#phone');
    let password = document.querySelector('#pass');
    let roleClient = document.querySelector('#radio_client');
    let roleDriver = document.querySelector('#radio_driver');
    let div_out = document.querySelector('.msg');

    user.phone = phone.value;
    user.password = password.value;

    if (roleClient.checked) {

        if (searchEquals(customers, user)) {
            window.location.replace("Sasha.html");
        } else {
            div_out.innerHTML = 'Oops, that`s not a match';
            div_out.style.marginBottom = '7%';
        }
    }

    if (roleDriver.checked) {

        if (searchEquals(drivers, user)) {
            window.location.replace("Sasha.html");
        } else {
            div_out.innerHTML = 'Oops, that`s not a match';
            div_out.style.marginBottom = '7%';
        }
    }
}