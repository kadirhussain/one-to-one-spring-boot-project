package com.jsp.onetoonespringboot.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.onetoonespringboot.dto.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

}
