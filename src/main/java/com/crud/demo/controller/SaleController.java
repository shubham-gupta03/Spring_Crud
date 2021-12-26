package com.crud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.model.Sale;
import com.crud.demo.services.SaleService;

@RestController
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping("/sales")
    public List<Sale> getSales(){   
		return saleService.getSales();
    }
	
	@GetMapping("/sale/{id}")
	public Sale getSale(@PathVariable int id) {
		return saleService.getSale(id);
	}
	
	@PostMapping("/sale")
	public Sale saveSale(@RequestBody Sale sale) {
		return saleService.saveSale(sale);
	}
	
	@PutMapping("/updateSale")
	public Sale updateSale(@RequestBody Sale sale) {
		return saleService.saveSale(sale);
	}
	
	@DeleteMapping("/sale/{id}")
	public String deleteSale(@PathVariable int id) {
		saleService.deleteSale(id);
		return "Removed Sale Id" + id;
	}
}
