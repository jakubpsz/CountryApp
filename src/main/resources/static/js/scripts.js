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
            console.log('Created table');

            tableBody.innerHTML = `<div th:insert="template :: city_resoult"ZZZ/>`;
        })
};

form.addEventListener('submit', buttonFind)


