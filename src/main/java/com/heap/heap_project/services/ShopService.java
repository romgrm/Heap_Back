package com.heap.heap_project.services;

import com.heap.heap_project.models.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {
    Optional<Shop> findByIdServ(int id);
    List<Shop> findAllServ();
    Shop insertServ(Shop shop);
    Shop updateServ(int id, Shop shop);
    void deleteServ(int id);
}
