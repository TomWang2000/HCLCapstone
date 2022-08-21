package com.hcl.ecommcapstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommcapstone.dto.InvoiceDto;
import com.hcl.ecommcapstone.entity.Address;
import com.hcl.ecommcapstone.entity.Invoice;
import com.hcl.ecommcapstone.entity.User;
import com.hcl.ecommcapstone.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	InvoiceRepository invoiceRepository;

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
	public Invoice updateInvoice(InvoiceDto invoiceDto, Address address) {
		Invoice invoice = getInvoice(invoiceDto.getOrderId());
		if (invoice != null) {
			BeanUtils.copyProperties(invoiceDto, invoice);
			invoice.setAddressId(address);
			return invoiceRepository.save(invoice);
		}
		return null;
	}

	@Override
	public Invoice addInvoice(InvoiceDto invoiceDto, Address address, User user) {
		Invoice invoice = new Invoice();
		//BeanUtils.copyProperties(invoiceDto, invoice);
		invoice.setDateordered(invoiceDto.getDateOrdered());
		invoice.setOrderstatus(invoiceDto.getOrderStatus());
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
	
}
