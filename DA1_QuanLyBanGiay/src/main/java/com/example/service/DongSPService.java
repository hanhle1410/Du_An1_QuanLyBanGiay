package com.example.service;

import com.example.entity.DongSP;

import java.util.List;
import java.util.UUID;

public interface DongSPService {
    List<DongSP> getAll();
    void add(DongSP dongSP);
    void update(DongSP dongSP);
    void delete(UUID id);
    DongSP detail(UUID id);
    DongSP getById(UUID id);
}
