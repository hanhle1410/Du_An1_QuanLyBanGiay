package com.example.service.ServiceImpl;


import com.example.entity.DeGiay;
import com.example.repository.DeGiayRepository;
import com.example.service.DeGiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeGiayServiceImpl implements DeGiayService {
    @Autowired
    private DeGiayRepository deGiayRepository;
    @Override
    public List<DeGiay> getAll() {
        return deGiayRepository.findAll();
    }

    @Override
    public void add(DeGiay deGiay) {
        deGiayRepository.save(deGiay);
    }

    @Override
    public void update(DeGiay deGiay) {
        deGiayRepository.save(deGiay);
    }

    @Override
    public void delete(UUID id) {
        deGiayRepository.deleteById(id);
    }

    @Override
    public DeGiay detail(UUID id) {
        return deGiayRepository.getById(id);
    }

    @Override
    public DeGiay getById(UUID id) {
        return deGiayRepository.findById(id).orElse(null);
    }
}
