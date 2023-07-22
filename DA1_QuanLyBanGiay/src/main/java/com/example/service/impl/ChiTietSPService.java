package com.example.service.impl;

import com.example.entity.ChiTietSP;

import java.util.List;
import java.util.UUID;

public interface ChiTietSPService {
    List<ChiTietSP> layDanhSachChiTietSP(UUID idSanPham);

    ChiTietSP layChiTietSP(UUID id);
    public void addToCart(ChiTietSP chiTietSP, int soLuong);

}
