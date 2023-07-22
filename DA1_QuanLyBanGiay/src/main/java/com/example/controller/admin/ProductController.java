package com.example.controller.admin;

import com.example.entity.ChiTietSP;
import com.example.entity.SanPham;
import com.example.service.impl.ChiTietSPService;
import com.example.service.impl.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private ChiTietSPService chiTietSPService;



    @GetMapping("views")
    public String danhSachSanPham(Model model) {
        List<SanPham> sanPhamList = sanPhamService.layDanhSachSanPham();
        model.addAttribute("sanPhamList", sanPhamList);
        return "product/danh-sach-san-pham";
    }

    @GetMapping("views/{id}")
    public String chiTietSanPham(@PathVariable("id") UUID id, Model model) {
        SanPham sanPham = sanPhamService.laySanPham(id);
        if (sanPham == null) {
            return "404";
        }
        List<ChiTietSP> chiTietSPList = chiTietSPService.layDanhSachChiTietSP(id);
        model.addAttribute("sanPham", sanPham);
        model.addAttribute("chiTietSPList", chiTietSPList);
        return "product/chi-tiet-san-pham";
    }


}
