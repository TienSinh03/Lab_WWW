// Make a GET request to an API
function fetchAPIAllProdut() {
    const productDiv = document.getElementById('productList');

    fetch('http://localhost:8080/week03_PhanTienSinh-1.0-SNAPSHOT/api/products')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json(); // Parse the JSON response
        })
        .then(data => {
           // Handle the data here
            productDiv.innerHTML = '';

            data.forEach(product => {
               productDiv.innerHTML +=`
                    <div class="col-md-4">
                      <div class="card mb-4">
                        <img src="${product.imgPath}" class="card-img-top" alt="${product.name}">
                        <div class="card-body">
                          <h5 class="card-title">${product.name}</h5>
                          <p class="card-text">${product.description}</p>
                          <p class="card-text"><strong>Price:</strong> 999 USD</p>
                        </div>
                      </div>
                    </div>
               `
            });

        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}

document.addEventListener('DOMContentLoaded', fetchAPIAllProdut);


