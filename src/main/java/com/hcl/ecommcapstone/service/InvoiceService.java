package com.hcl.ecommcapstone.service;

import java.util.List;

import com.hcl.ecommcapstone.dto.InvoiceDto;
import com.hcl.ecommcapstone.entity.Address;
import com.hcl.ecommcapstone.entity.Invoice;
import com.hcl.ecommcapstone.entity.User;

public interface InvoiceService {


	Invoice getInvoice(Long orderId);

	void deleteInvoice(Long orderId);

	List<Invoice> getAllInvoices(int pageNumber, int pageSize);

	Invoice updateInvoice(InvoiceDto invoiceDto, Address address);
	
	Invoice findById(Long orderId);

	Invoice addInvoice(InvoiceDto invoiceDto, Address address, User user);

}
