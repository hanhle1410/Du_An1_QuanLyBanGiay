package com.example.service;

import com.example.entity.ChiTietSP;
import com.example.repository.ChiTietSPRepository;
import com.example.service.impl.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChiTietSPServiceImpl implements ChiTietSPService {


    @Autowired
    private ChiTietSPRepository chiTietSPRepository;

    @Override
    public List<ChiTietSP> layDanhSachChiTietSP(UUID sanPham) {
        return this.chiTietSPRepository.findBySanPamId(sanPham);
    }

    @Override
    public ChiTietSP layChiTietSP(UUID id) {
        Optional<ChiTietSP> optional = chiTietSPRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void addToCart(ChiTietSP chiTietSP, int soLuong) {
        // Add the item to the cart
        // ...
        // Update the ChiTietSP quantity
        ChiTietSP chiTietSPInDb = chiTietSPRepository.findById(chiTietSP.getId()).orElse(null);
        if (chiTietSPInDb != null) {
            int remainingQuantity = chiTietSPInDb.getSoLuong() - soLuong;
            chiTietSPInDb.setSoLuong(remainingQuantity);
            chiTietSPRepository.save(chiTietSPInDb);
        }
    }
}
