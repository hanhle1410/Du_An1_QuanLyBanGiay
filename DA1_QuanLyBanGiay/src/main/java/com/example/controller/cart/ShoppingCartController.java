package com.example.controller.cart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopping-cart/")
public class ShoppingCartController {

    @GetMapping("views")
    public String ViewCart(Model model){


        return " ";
    }


}
