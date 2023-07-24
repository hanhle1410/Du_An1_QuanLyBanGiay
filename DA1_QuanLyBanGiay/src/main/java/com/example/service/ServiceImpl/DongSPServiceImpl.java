package com.example.service.ServiceImpl;

import com.example.entity.DongSP;
import com.example.repository.DongSPRepository;
import com.example.service.DongSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongSPServiceImpl implements DongSPService {
    @Autowired
    private DongSPRepository dongSPRepository;
    @Override
    public List<DongSP> getAll() {
        return dongSPRepository.findAll();
    }

    @Override
    public void add(DongSP dongSP) {
        dongSPRepository.save(dongSP);
    }

    @Override
    public void update(DongSP dongSP) {
        dongSPRepository.save(dongSP);
    }

    @Override
    public void delete(UUID id) {
        dongSPRepository.deleteById(id);
    }

    @Override
    public DongSP detail(UUID id) {
        return dongSPRepository.getById(id);
    }

    @Override
    public DongSP getById(UUID id) {
        return dongSPRepository.findById(id).orElse(null);
    }
}
