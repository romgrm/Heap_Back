package com.heap.heap_project.services;

import com.heap.heap_project.models.Shop;
import com.heap.heap_project.repositories.ShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService{

    private final ShopRepository shopRepository;

    @Override
    public Optional<Shop> findByIdServ(int id){
        return shopRepository.findById(id);
    }

    @Override
    public List<Shop> findAllServ(){
        return shopRepository.findAll();
    }

    @Override
    public Shop insertServ(Shop shop){
        return shopRepository.save(shop);
    }

    @Override
    public Shop updateServ(int id, Shop shop){
        Optional<Shop> optionalShop = shopRepository.findById(id);
        if(optionalShop.isPresent()) {
            return shopRepository.save(shop);
        }
        return null;
    }

    @Override
    public void deleteServ(int id){
        Optional<Shop> shop = shopRepository.findById(id);
        if(shop.isPresent()) {
            shopRepository.delete(shop.get());
        }
    }
}
