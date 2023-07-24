package com.example.service.ServiceImpl;

import com.example.entity.NhaSX;
import com.example.repository.NhaSXRepository;
import com.example.service.NhaSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhaSXServiceImpl implements NhaSXService {
    @Autowired
    private NhaSXRepository nhaSXRepository;
    @Override
    public List<NhaSX> getAll() {
        return nhaSXRepository.findAll();
    }

    @Override
    public void add(NhaSX nhaSX) {
        nhaSXRepository.save(nhaSX);
    }

    @Override
    public void update(NhaSX nhaSX) {
        nhaSXRepository.save(nhaSX);
    }

    @Override
    public void delete(UUID id) {
        nhaSXRepository.deleteById(id);
    }

    @Override
    public NhaSX detail(UUID id) {
        return nhaSXRepository.getById(id);
    }

    @Override
    public NhaSX getById(UUID id) {
        return nhaSXRepository.findById(id).orElse(null);
    }
}
