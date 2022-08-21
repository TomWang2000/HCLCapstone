package com.hcl.ecommcapstone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommcapstone.dto.InvoiceDto;
import com.hcl.ecommcapstone.entity.Address;
import com.hcl.ecommcapstone.entity.Invoice;
import com.hcl.ecommcapstone.entity.User;
import com.hcl.ecommcapstone.repository.AddressRepository;
import com.hcl.ecommcapstone.repository.UserRepository;
import com.hcl.ecommcapstone.service.InvoiceService;

@RestController
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	UserRepository userRepository;

	@PostMapping("/invoice/add")
	public Invoice addInvoice(@RequestBody InvoiceDto invoiceDto) {
		Optional<Address> optionalAddress = addressRepository.findById(invoiceDto.getDeliverAddress());
		Optional<User> optionalUser = userRepository.findById(invoiceDto.getUserId());
		return invoiceService.addInvoice(invoiceDto, optionalAddress.get(), optionalUser.get());
	}

	@PostMapping("/invoice/update")
	public Invoice updateInvoice(@RequestBody InvoiceDto invoiceDto) {
		Optional<Address> optionalAddress = addressRepository.findById(invoiceDto.getDeliverAddress());
		Optional<User> optionalUser = userRepository.findById(invoiceDto.getUserId());
		return invoiceService.addInvoice(invoiceDto, optionalAddress.get(), optionalUser.get());
	}

	@GetMapping("/invoice/{orderId}")
	public Invoice getInvoice(@PathVariable Long orderId) {
		return invoiceService.getInvoice(orderId);
	}

	@DeleteMapping("/invoice/delete")
	public String deleteUser(@RequestParam Long orderId) {
		invoiceService.deleteInvoice(orderId);
		return "Invoice " + orderId + " has been deleted";
	}

	@GetMapping("/invoice/all")
	public List<Invoice> getAllInvoices(int pageNumber, int pageSize) {
		return invoiceService.getAllInvoices(pageNumber, pageSize);
	}

}
