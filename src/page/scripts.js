
// const buttonFind = document.querySelector('.btn');
let form = document.forms['location']
let country = form['country'];
let city = form['city'];


function buttonFind (event) {
    event.preventDefault();
    console.log('user written: country: ' + country.value + " city: " + city.value );

    var x;
    fetch("http://localhost:8080/city?country=" + country.value.toLowerCase() + '&city=' + city.value.toLowerCase())
        .then(response => response.json())
        .then(response => {
            x = response;
            response.forEach(function (element){
                tableBody.innerHTML = tableBody.innerHTML + `
            <tr>
                <td>${element.name}</td>
                <td>${element.address.city}</td>
                <td>${element.address.zipcode}</td>
            </tr>
    `;
            })
        })

};

form.addEventListener('submit', buttonFind)


