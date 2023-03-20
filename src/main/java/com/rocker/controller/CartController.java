package com.rocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rocker.model.Cart;
import com.rocker.model.Overall;
import com.rocker.services.CartService;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/cart")
    public ResponseEntity<Cart> addCartHandler(@RequestBody Overall overall) {
        return new ResponseEntity<>(cartService.addCart(overall), HttpStatus.ACCEPTED);
    }

    @PutMapping("/cart")
    public ResponseEntity<Cart> udpateCartHandler(@RequestParam Integer cartId, @RequestBody Overall overall) {
        return new ResponseEntity<>(cartService.updateCart(cartId, overall), HttpStatus.OK);
    }

    @DeleteMapping("/cart")
    public ResponseEntity<Cart> deleteCartHandler(@RequestParam Integer cartId, @RequestParam Integer overallId) {
        return new ResponseEntity<>(cartService.deleteCart(cartId, overallId), HttpStatus.OK);
    }

    @GetMapping("/cart")
    public ResponseEntity<Cart> viewCartHandler(@RequestParam Integer cartId) {
        return new ResponseEntity<>(cartService.viewCart(cartId), HttpStatus.OK);
    }

    @GetMapping("/carts")
    public ResponseEntity<List<Cart>> viewAllCartsHandler() {
        return new ResponseEntity<>(cartService.viewAllCart(), HttpStatus.OK);
    }
}
