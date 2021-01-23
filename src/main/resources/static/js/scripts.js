let form = document.forms['location']
let country = form['country'];
let city = form['city'];
const tableBody = document.querySelector('.tbody');

function buttonFind(event) {
    event.preventDefault();
    console.log('user written: country: ' + country.value + " city: " + city.value);

    var x;
    fetch("http://localhost:8080/city?country=" + country.value.toLowerCase() + '&city=' + city.value.toLowerCase())
        .then(response => response.json())
        .then(cityInfo => {


            tableBody.innerHTML = `<div th:insert="city_temp :: city_result"/>`;
        })
};
console.log('Created table');
form.addEventListener('submit', buttonFind)


