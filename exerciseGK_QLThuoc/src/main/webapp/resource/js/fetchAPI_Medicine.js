// Make a GET request to an API
function fetchAPIAllProduct() {

    const productDiv = document.getElementById('productList');

    fetch('http://localhost:8080/week03_PhanTienSinh-1.0-SNAPSHOT/api/products', { cache: "no-store" })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json(); // Parse the JSON response
        })
        .then(data => {
           // Handle the data here
            productDiv.innerHTML = ``;

            data.forEach(product => {
               productDiv.innerHTML +=`
                    <div class="col-md-3">
                      <div class="card mb-4">
                        <img src="${product.imgPath}" class="card-img-top fixed-img" alt="${product.name}">
                        <div class="card-body">
                          <h5 class="card-title">${product.name}</h5>
                          <p class="card-text">${product.description}</p>
                          <p class="card-text"><strong>Price:</strong> ${product.price}</p>
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

document.addEventListener('DOMContentLoaded', fetchAPIAllProduct);


