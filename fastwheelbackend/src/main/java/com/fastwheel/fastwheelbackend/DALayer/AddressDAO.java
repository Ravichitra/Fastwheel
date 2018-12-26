package com.fastwheel.fastwheelbackend.DALayer;

import java.util.List;

import com.fastwheel.fastwheelbackend.model.Address;

public interface AddressDAO {
	
	boolean CreateAddress(Address address);
	boolean UpdateAddress(Address address);
	boolean DeleteAddress(int id);
	Address SelectoneAddress(int addressid);
	List<Address> SelectallAddress(int cartid);

	
	

}
