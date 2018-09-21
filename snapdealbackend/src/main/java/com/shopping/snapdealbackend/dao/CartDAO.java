package com.shopping.snapdealbackend.dao;

import com.shopping.snapdealbackend.dto.Cart;

public interface CartDAO {
	boolean addCart(Cart cart);
	Cart getCartByCustomer(String customerId);
	boolean deleteCart(int cartId);
}
