/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.exercise3.controllers;

import com.example.exercise3.models.Stock;
import com.example.exercise3.service.StockService;
import java.math.BigDecimal;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author franc
 */
@RestController
public class HomeController {
    
     @Autowired
    private StockService stockService;
            
    @GetMapping("/api/stocks")
    public Iterable<Stock> getStocks(){
        return stockService.findAllStocks();
    }
    
    @GetMapping("/api/stocks/{id}")
    public Stock getStock(@PathVariable Long id){
        Optional optionalStock = stockService.findStockById(id);
        if(!optionalStock.isPresent())
            throw new RuntimeException("stock not present id = "+id);
        
        return (Stock)optionalStock.get();
    }
    
    @PostMapping("/api/stocks")
    public ResponseEntity<Void> createStock(@RequestBody Stock stock){
        stockService.save(stock);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
     @PostMapping("/api/stocks/{id}")
    public ResponseEntity<Void> updateStock(@Valid @RequestBody Stock stockDetails,@PathVariable Long id ){
         Optional optionalStock = stockService.findStockById(id);
        if(!optionalStock.isPresent())
            throw new RuntimeException("stock not present id = "+id);
        Stock stock = (Stock)optionalStock.get();
        stock.setCurrentPrice(stockDetails.getCurrentPrice());
        stock.setName(stockDetails.getName());
        stockService.save(stock);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @DeleteMapping("/api/stocks/{id}")
    public void deleteStock(@PathVariable Long id){
        stockService.delete(id);
    }
}
