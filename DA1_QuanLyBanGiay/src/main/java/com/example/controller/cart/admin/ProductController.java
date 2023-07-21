package com.example.controller.cart.admin;

import com.example.service.impl.ChiTietSPService;
import com.example.service.impl.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private SanPhamService sanPhamService;
    private ChiTietSPService chiTietSPService;

}
