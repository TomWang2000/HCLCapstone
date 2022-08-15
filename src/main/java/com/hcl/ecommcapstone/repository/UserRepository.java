package com.hcl.ecommcapstone.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hcl.ecommcapstone.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "select u.* from user u where u.user_name = :username and password = :password", nativeQuery = true)
	User getUserForLogin(String username, String password);
	User findByUsernameAndPassword(String username, String password);
	
	User findByUsername(String username);
	
}

