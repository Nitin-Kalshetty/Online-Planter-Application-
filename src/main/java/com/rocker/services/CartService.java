package com.rocker.services;

import java.util.List;

import com.rocker.exceptions.CartException;
import com.rocker.model.Cart;
import com.rocker.model.Overall;

public interface CartService {

    public Cart addCart(Overall overAll) throws CartException;

    public Cart updateCart(Integer cartId, Overall overAll) throws CartException;

    public Cart deleteCart(Integer cartId, Integer overallId) throws CartException;

    public Cart viewCart(Integer cartId) throws CartException;

    public List<Cart> viewAllCart() throws CartException;
}
