package com.shopping.snapdealbackend.dto;


import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@SuppressWarnings("unused")
@Entity
@Table(name="CartTable")
public class Cart {

	@Id
	@GeneratedValue
	private int cartId;
	
	private int cardProductId; //productId fetched from product entity and put into cart entity
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userMailId")
	private User cartUserDetails; //this object will be used in ur shipping.jsp
	
	
	private double cartPrice; //product price added in cart
	private int cartQuantity; //no. of products added in cart against a particular pid
	private String cartImage; //product image in cart
	private String cartProductName; //productname
	private String status;
	
	public Cart(){
		
	}

	public Cart(int cartId, int cardProductId, User cartUserDetails,
			double cartPrice, int cartQuantity) {
		super();
		this.cartId = cartId;
		this.cardProductId = cardProductId;
		this.cartUserDetails = cartUserDetails;
		this.cartPrice = cartPrice;
		this.cartQuantity = cartQuantity;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCardProductId() {
		return cardProductId;
	}

	public void setCardProductId(int cardProductId) {
		this.cardProductId = cardProductId;
	}

	public User getCartUserDetails() {
		return cartUserDetails;
	}

	public void setCartUserDetails(User cartUserDetails) {
		this.cartUserDetails = cartUserDetails;
	}

	public double getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(double cartPrice) {
		this.cartPrice = cartPrice;
	}

	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public String getCartImage() {
		return cartImage;
	}

	public void setCartImage(String cartImage) {
		this.cartImage = cartImage;
	}

	public String getCartProductName() {
		return cartProductName;
	}

	public void setCartProductName(String cartProductName) {
		this.cartProductName = cartProductName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCustomerId(String userEmail) {
		// TODO Auto-generated method stub
		
	}

	public void setUser(User userById) {
		// TODO Auto-generated method stub
		
	}

	public void setItems(ArrayList<Item> al) {
		// TODO Auto-generated method stub
		
	}
		
	
	
}
