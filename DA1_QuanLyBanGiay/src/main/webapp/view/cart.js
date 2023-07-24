document.addEventListener('DOMContentLoaded', function () {
  var cartTableBody = document.querySelector('#cartTable tbody');
  var totalSelectedPriceSpan = document.getElementById('totalSelectedPrice');
  var checkoutButton = document.getElementById('checkoutButton');

  // Load cart data from local storage
  var cart = JSON.parse(localStorage.getItem('cart')) || [];

  // Function to calculate and update the total price of the selected products
  function updateTotalPrice() {
    var totalSelectedPrice = 0;
    cartTableBody.innerHTML = ''; // Clear the existing rows before updating
    cart.forEach(function (product) {
      var totalPrice = product.price * product.quantity;
      totalSelectedPrice += totalPrice;
      var row = document.createElement('tr');
      row.innerHTML = `
        <td><img src="${product.imageUrl}" alt="Product Image"></td>
        <td>${product.name}</td>
        <td>$${product.price.toFixed(2)}</td>
        <td>${product.size}</td>
        <td>${product.color}</td>
        <td>${product.quantity}</td>
        <td>${product.discountCode}</td>
        <td>$${totalPrice.toFixed(2)}</td>
        <td><button class="remove-button" data-product="${product.name}">Remove</button></td>

      `;
      cartTableBody.appendChild(row);
    });
    totalSelectedPriceSpan.textContent = totalSelectedPrice.toFixed(2);
  }

  // Call the updateTotalPrice function to display the initial cart data
  updateTotalPrice();

  // Handler for removing a product from the cart
  cartTableBody.addEventListener('click', function (event) {
    if (event.target.classList.contains('remove-button')) {
      var productName = event.target.dataset.product;
      cart = cart.filter(function (product) {
        return product.name !== productName;
      });
      localStorage.setItem('cart', JSON.stringify(cart));
      updateTotalPrice();
    }
  });

  // // Handler for the "Thanh toán" (Checkout) button
  // checkoutButton.addEventListener('click', function () {
  //   if (cart.length === 0) {
  //     alert('Giỏ hàng của bạn đang trống. Hãy thêm sản phẩm trước khi thanh toán.');
  //   } else {
  //     window.location.href = 'checkout.html'; // Replace 'checkout.html' with your actual checkout page URL
  //   }
  // });




  // Trong phần xử lý sự kiện cho nút "Thanh toán" (checkoutButton)
  checkoutButton.addEventListener('click', function () {
    if (cart.length === 0) {
      alert('Giỏ hàng của bạn đang trống. Hãy thêm sản phẩm trước khi thanh toán.');
    } else {
      localStorage.setItem('cartData', JSON.stringify(cart)); // Lưu dữ liệu giỏ hàng vào Local Storage
      window.location.href = 'checkout.html'; // Chuyển đến trang thanh toán
    }
  });

});