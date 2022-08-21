package com.hcl.ecommcapstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommcapstone.entity.Invoice;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

}
