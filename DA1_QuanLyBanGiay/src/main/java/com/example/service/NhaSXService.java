package com.example.service;

import com.example.entity.NhaSX;

import java.util.List;
import java.util.UUID;

public interface NhaSXService {
    List<NhaSX> getAll();
    void add(NhaSX nhaSX);
    void update(NhaSX nhaSX);
    void delete(UUID id);
    NhaSX detail(UUID id);
    NhaSX getById(UUID id);
}
