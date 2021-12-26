package com.crud.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.model.Sale;

public interface SaleDao extends JpaRepository<Sale, Integer>{

}
