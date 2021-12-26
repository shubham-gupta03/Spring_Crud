package com.crud.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.dao.SaleDao;
import com.crud.demo.model.Sale;

@Service
public class SaleService {
	
	@Autowired
	private SaleDao saleDao;
	
	public Sale saveSale(Sale sale) {
		return saleDao.save(sale);
	}
	
	public List<Sale> getSales(){
		return saleDao.findAll();
	}
	
	public Sale getSale(int id) {
		return saleDao.findById(id).orElse(null);
	}
	
	public void deleteSale(int id) {
		saleDao.deleteById(id);
	}
}
