package com.rocker.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocker.exceptions.CartException;
import com.rocker.model.Cart;
import com.rocker.model.Overall;
import com.rocker.repository.CartRepository;
import com.rocker.repository.OverallRepository;
import com.rocker.services.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private OverallRepository overRepo;

    @Override
    public Cart addCart(Overall overAll) throws CartException {

        try {
            Cart cart = new Cart();
            cart.getCombinations().add(overAll);
            return cartRepo.save(cart);
        } catch (Exception e) {
            throw new CartException("Not able to add cart");
        }
    }

    @Override
    public Cart updateCart(Integer cartId, Overall overAll) throws CartException {

        Optional<Cart> opt = cartRepo.findById(cartId);
        if (opt.isEmpty()) {
            throw new CartException("You are not authenticated please login first.");
        }
        try {
            Cart cart = opt.get();
            cart.getCombinations().add(overAll);
            return cartRepo.save(cart);
        } catch (Exception e) {
            throw new CartException("Not able to add cart");
        }

    }

    @Override
    public Cart deleteCart(Integer cartId, Integer overallId) throws CartException {
        Optional<Cart> opt = cartRepo.findById(cartId);
        if (opt.isEmpty()) {
            return new Cart();
        }
        Cart cart = opt.get();
        Optional<Overall> overOpt = overRepo.findById(overallId);
        if (overOpt.isEmpty()) {
            throw new CartException("Please check is item in cart.");
        }
        Overall overall = overOpt.get();
        overRepo.delete(overall);
        cart.getCombinations().remove(overall);
        return cartRepo.save(cart);
    }

    @Override
    public Cart viewCart(Integer cartId) throws CartException {
        Optional<Cart> opt = cartRepo.findById(cartId);
        if (opt.isEmpty()) {
            return new Cart();
        }
        return opt.get();
    }

    @Override
    public List<Cart> viewAllCart() throws CartException {
        List<Cart> carts = cartRepo.findAll();
        if (carts.isEmpty()) {
            throw new CartException("There are no carts...");
        }
        return carts;
    }
}
