// Make a GET request to an API
fetch('http://localhost:8080/week03_PhanTienSinh-1.0-SNAPSHOT/api/products')
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        return response.json(); // Parse the JSON response
    })
    .then(data => {
        console.log(data); // Handle the data here
    })
    .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
    });