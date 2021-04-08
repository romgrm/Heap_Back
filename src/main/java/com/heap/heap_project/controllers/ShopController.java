package com.heap.heap_project.controllers;

import com.heap.heap_project.models.Shop;
import com.heap.heap_project.services.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/shop")
@AllArgsConstructor
public class ShopController {
    final private ShopService shopService;

    /*
        GET all Shop
    */
    @GetMapping
    ResponseEntity<List<Shop>> getAllShops() {
        return ResponseEntity.ok().body(
                shopService.findAllServ()
        );
    }

    /*
        GET Shop by Id
    */
//    @PreAuthorize("hasRole('ROLE_PARTICULIER')")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Shop>> collaboratorById(@PathVariable int id) {
        return ResponseEntity.ok(shopService.findByIdServ(id));
    }

    @PostMapping()
    ResponseEntity<Shop> addCollaborator(@RequestBody Shop shop){
        return ResponseEntity.ok().body(shopService.insertServ(shop));
    }
}
