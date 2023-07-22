<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giỏ hàng</title>
    <!-- Thêm các tài nguyên Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="container">



    <h1 class="my-4">Giỏ hàng</h1>
    <div class="row">
        <div class="col-md-8">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Sản phẩm</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col">Giá</th>
                    <th scope="col">Tổng cộng</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${CART_ITEMS}" var="item">
                    <form action="/shopping-cart/update/${item.id}" method="post">
                        <tr>
                            <input type="hidden" name="id" value="${item.idChiTietSP.id}" />
                            <td>${item.idChiTietSP.idSP.idDongSP.ten} - ${item.idChiTietSP.idSP.idDeGiay.chatLieu} - Màu sắc: ${item.idChiTietSP.idMauSP.mau} - Kích cỡ: ${item.idChiTietSP.idKichCo.coGiay}</td>
                            <td>
                                <input name="soLuong" value="${item.soLuong}" onblur="this.form.submit()" style="width: 50px;">
                            </td>
                            <td>${item.idChiTietSP.idSP.giaBan}</td>
                            <td>${item.idChiTietSP.idSP.giaBan * item.soLuong}</td>
                            <td>
                                <a class="btn btn-danger btn-sm" href="/shopping-cart/remove/${item.id}">Xóa</a>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>
                <a class="btn btn-primary btn-sm" href="/shopping-cart/clear">Xóa giỏ hàng</a>
                <a class="btn btn-primary btn-sm" href="/product/views"> Thêm sản phẩm mới</a>
        </div>
        <div class="col-md-4">
            <div class="card">
                <div class="card-header">Thông tin thanh toán</div>
                <div class="card-body">
                    <form action="/hoa-don/luu" method="post">
                        <div class="form-group">
                            <label for="email">Nhân viên:</label>
                            <input type="email" name="email" id="email" class="form-control" required>
                        </div>
                        <p>Tổng tiền: ${TOTAL}</p>
                        <div class="form-group">
                            <label for="ten">Tên khách hàng:</label>
                            <input type="text" name="ten" id="ten" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="sdt">Số điện thoại:</label>
                            <input type="text" name="sdt" id="sdt" class="form-control" required>
                        </div>
                        <div class="form-group text-center">
                            <a class="btn btn-primary" style="position: relative;top: 10px;">Tạo hóa đơn</a>
                            <button class="btn btn-primary" type="submit" style="position: relative;top: 10px;">Thanh toán</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

</body>
</html>