package com.example.service;

import com.example.entity.DeGiay;

import java.util.List;
import java.util.UUID;

public interface DeGiayService {
    List<DeGiay> getAll();
    void add(DeGiay deGiay);
    void update(DeGiay deGiay);
    void delete(UUID id);
    DeGiay detail(UUID id);
    DeGiay getById(UUID id);

}
