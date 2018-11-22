package net.ebook.model;

import java.io.Serializable;

import ebookbackend.dto.Cart;
import ebookbackend.dto.Favourite;
public class UserModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String fullName;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private Cart cart;
	private Favourite favourite;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Favourite getFavourite() {
		return favourite;
	}
	public void setFavourite(Favourite favourite) {
		this.favourite = favourite;
	}
		
}
