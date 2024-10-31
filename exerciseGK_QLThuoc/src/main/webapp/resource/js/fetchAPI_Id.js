function fetchAPI_Id(event) {
    event.preventDefault();
    const searchID = document.getElementById('search-input').value;

    const productId = document.getElementById('pro_id');
    const productName = document.getElementById('name_product');
    const productDescription = document.getElementById('des');
    const img_path = document.getElementById('img');

    fetch(`http://localhost:8080/week03_PhanTienSinh-1.0-SNAPSHOT/api/products/${searchID}`)
        .then(response => response.json())
        .then(data => {
            productId.value = data.id;
            productName.value = data.name;
            productDescription.value = data.description;
            img_path.value = data.imgPath;
        })
        .catch(err => {
            console.error('Error:', err);
        })

}

document.getElementById('searchForm').addEventListener('submit', fetchAPI_Id);