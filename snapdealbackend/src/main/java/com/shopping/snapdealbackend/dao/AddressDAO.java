package com.shopping.snapdealbackend.dao;

import com.shopping.snapdealbackend.dto.Address;

public interface AddressDAO {

	public void insertAddress(Address address);
	public Address getAddressById(int addressId);
	public void updateAddress(Address address);
	public void deleteAddress(int addressId);
}
