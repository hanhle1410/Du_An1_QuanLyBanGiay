document.addEventListener('DOMContentLoaded', function () {
  var checkoutTableBody = document.querySelector('#checkoutTable tbody');
  var totalPriceSpan = document.getElementById('totalPrice');

  // Lấy dữ liệu giỏ hàng từ Local Storage
  var cartData = JSON.parse(localStorage.getItem('cartData')) || [];

  // Hiển thị dữ liệu giỏ hàng lên bảng
  cartData.forEach(function (product) {
    var totalPrice = product.price * product.quantity;
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
    `;
    checkoutTableBody.appendChild(row);
  });

  // Tính tổng tiền và hiển thị
  var totalSelectedPrice = cartData.reduce(function (total, product) {
    return total + (product.price * product.quantity);
  }, 0);
  totalPriceSpan.textContent = totalSelectedPrice.toFixed(2);
});
