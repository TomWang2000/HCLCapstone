package com.hcl.ecommcapstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommcapstone.dto.AddressDto;
import com.hcl.ecommcapstone.dto.InvoiceDto;
import com.hcl.ecommcapstone.entity.Address;
import com.hcl.ecommcapstone.entity.Invoice;
import com.hcl.ecommcapstone.entity.User;
import com.hcl.ecommcapstone.repository.AddressRepository;
import com.hcl.ecommcapstone.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired 
	AddressRepository addressRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	AddressService addressService;

	@Override
	public Invoice getInvoice(Long orderId) {
		Optional<Invoice> invoice = invoiceRepository.findById(orderId);
		if (invoice.isPresent()) {
			return invoice.get();
		}
		return null;
	}
	
	@Override
	public void deleteInvoice(Long orderId) {
		invoiceRepository.deleteById(orderId);
	}
	
	@Override 
	public List<Invoice> getAllInvoices(int pageNumber, int pageSize){
		return invoiceRepository.findAll();
	}
	
	@Override 
	public Invoice updateInvoice(InvoiceDto invoiceDto, User user) {
		Invoice invoice = getInvoice(invoiceDto.getOrderId());
		if (invoice != null) {
			BeanUtils.copyProperties(invoiceDto, invoice);
			return invoiceRepository.save(invoice);
		}
		return null;
	}

	@Override
	public Invoice addInvoice(InvoiceDto invoiceDto) {
		Invoice invoice = new Invoice();
		Address address = addressService.getAddress(invoiceDto.getAddressId());
		User user = userService.getUser(invoiceDto.getUserId());
		BeanUtils.copyProperties(invoiceDto, invoice);
		invoice.setDateordered(invoiceDto.getDateOrdered());
		invoice.setOrderstatus("Not Checked Out");
		invoice.setTotalprice(invoiceDto.getTotalPrice());
		invoice.setAddressId(address);
		invoice.setUserId(user);
		return invoiceRepository.save(invoice);	
	}

	@Override
	public Invoice findById(Long orderId) {
		Optional<Invoice> invoice = invoiceRepository.findById(orderId);
		return invoice.get();
	}

	@Override
	public Invoice addInvoice(InvoiceDto invoiceDto, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address addAddress(AddressDto addressDto, Address address) {
		BeanUtils.copyProperties(addressDto, address);
		address.setAddressId(addressDto.getAddressId());
		return addressRepository.save(address);
	}
	
}
