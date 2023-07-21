package com.example.service;

import com.example.entity.GioHangCT;
import com.example.repository.GioHangCTRepository;
import com.example.service.impl.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private GioHangCTRepository gioHangCTRepository;


    private final Map<UUID, GioHangCT> maps = new HashMap<>();

    @Override
    public void add(GioHangCT item) {
        GioHangCT cartItem = maps.get(item.getIdChiTietSP().getId());
        if (cartItem == null) {
            item.setSoLuong(1);
            maps.put(item.getIdChiTietSP().getId(), item);
            this.gioHangCTRepository.save(item);
        } else {
            int newQuantity = cartItem.getSoLuong() + 1;
            cartItem.setSoLuong(newQuantity);
            this.gioHangCTRepository.save(cartItem);
        }
    }

    @Override
    public void remove(UUID id) {
        gioHangCTRepository.deleteById(id);
    }

    @Override
    public GioHangCT update(UUID id , int soLuong) {
        GioHangCT cartItem = gioHangCTRepository.findById(id).orElse(null);
        cartItem.setSoLuong(soLuong);
        gioHangCTRepository.save(cartItem);
        return cartItem;
    }
    @Override
    public void clear() {
        gioHangCTRepository.deleteAll();
    }

    @Override
    public List<GioHangCT> getAllItems() {
        return gioHangCTRepository.findAll();
    }

    @Override
    public int getCount() {
        List<GioHangCT> cartItems = getAllItems();
        if (cartItems != null) {
            return cartItems.size();
        }
        return 0;
    }

    @Override
    public BigDecimal getAmount() {
        Map<UUID, GioHangCT> gioHangCTMap = gioHangCTRepository.findAll().stream()
                .collect(Collectors.toMap(GioHangCT::getId, gioHangCT -> gioHangCT));
        BigDecimal totalAmount = gioHangCTMap.values().stream()
                .map(item -> item.getDonGia().multiply(BigDecimal.valueOf(item.getSoLuong())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalAmount;
    }

}
