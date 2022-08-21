package com.hcl.ecommcapstone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.ecommcapstone.dto.AddressDto;
import com.hcl.ecommcapstone.entity.Address;

public interface AddressService {

	Address getAddress(Long addressId);

	Address addAddress(AddressDto addressDto);

	Address updateAddress(AddressDto addressDto);

	List<Address> getAllAddresses(int pageNumber, int pageSize);

	void deleteAddress(Long addressId);

}
