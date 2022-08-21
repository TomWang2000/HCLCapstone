package com.hcl.ecommcapstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommcapstone.dto.AddressDto;
import com.hcl.ecommcapstone.entity.Address;
import com.hcl.ecommcapstone.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	@Override
	public Address addAddress(AddressDto addressDto) {
		Address address = new Address();
		BeanUtils.copyProperties(addressDto, address);
		return addressRepository.save(address);
	}
	
	@Override 
	public Address getAddress(Long addressId) {
		Optional<Address> address = addressRepository.findById(addressId);
		if (address.isPresent()) {
			return address.get();
		}
		return null;
	}
	
	@Override
	public void deleteAddress(Long addressId) {
		addressRepository.deleteById(addressId);
	}
	
	@Override
	public List<Address> getAllAddresses(int pageNumber, int pageSize){
		return addressRepository.findAll();
	}
	
	@Override 
	public Address updateAddress(AddressDto addressDto) {
		Address address = getAddress(addressDto.getAddressId());
		if (address != null) {
			BeanUtils.copyProperties(addressDto, address);
			return addressRepository.save(address);
		}
		return null;
	}
}
