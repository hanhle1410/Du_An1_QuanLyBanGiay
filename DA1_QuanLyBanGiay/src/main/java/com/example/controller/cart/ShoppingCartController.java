package com.example.controller.cart;

import com.example.service.impl.ChiTietSPService;
import com.example.service.impl.SanPhamService;
import com.example.service.impl.ShoppingCartService;
import com.example.entity.GioHangCT;
import com.example.entity.ChiTietSP;
import com.example.entity.SanPham;
import com.example.service.impl.ChiTietSPService;
import com.example.service.impl.SanPhamService;
import com.example.service.impl.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/shopping-cart/")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ChiTietSPService chiTietSPService;
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("views")
    public String viewProduct(Model model) {
        model.addAttribute("CART_ITEMS", shoppingCartService.getAllItems());
        model.addAttribute("TOTAL", shoppingCartService.getAmount());

        return "cart/cart-items";
    }

    @GetMapping("add/{id}")
    public String addCart(Model model, @PathVariable("id") UUID id
    ) {
        ChiTietSP chiTietSP = chiTietSPService.layChiTietSP(id);
        if (chiTietSP != null) {
            GioHangCT item = new GioHangCT();
            item.setIdChiTietSP(chiTietSP);
            SanPham sanPham = chiTietSP.getIdSP();
            if (sanPham != null) {
                item.setDonGia(sanPham.getGiaBan());
                item.setSoLuong(1);
                chiTietSPService.addToCart(chiTietSP, item.getSoLuong());
                shoppingCartService.add(item);
            }
        }
        model.addAttribute("list_product", shoppingCartService);
        return "redirect:/shopping-cart/views";
    }


    @GetMapping("clear")
    public String clearCart() {
        shoppingCartService.clear();
        return "redirect:/shopping-cart/views";
    }


    @GetMapping("remove/{id}")
    public String deleteCart(
            Model model,
            @PathVariable("id") UUID id
    ) {
        shoppingCartService.remove(id);
        return "redirect:/shopping-cart/views";
    }


    @PostMapping("update/{id}")
    public String updateCart(
            Model model,
            @PathVariable("id") UUID id, @RequestParam("soLuong")Integer soLuong
    ) {

        shoppingCartService.update(id,soLuong);
        return "redirect:/shopping-cart/views";
    }

}
