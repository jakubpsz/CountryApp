let form = document.forms['register1']
let email = form['email'];
let password = form['password'];
const tableBody = document.querySelector('.tbody');

function buttonFind(event) {
    event.preventDefault();
    console.log('user written: email: ' + email.value + " password: " + password.value);

    let user_register = {
        email: email.value,
        password: password.value
    }

    fetch("register", {
        method: "put",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user_register)
    })

        .then(response => {
            console.log(response.text());
        })
};

form.addEventListener('submit', buttonFind)


