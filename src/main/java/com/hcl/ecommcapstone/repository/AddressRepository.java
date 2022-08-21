package com.hcl.ecommcapstone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommcapstone.dto.AddressDto;
import com.hcl.ecommcapstone.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {


}
