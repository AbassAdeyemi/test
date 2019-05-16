/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.exercise3.service;

import com.example.exercise3.models.Stock;
import com.example.exercise3.repositories.StockRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franc
 */
@Service
public class StockService {
     @Autowired
    private StockRepository stockRepository;
    
    public void save(Stock stock){
        stockRepository.save(stock);
    }
    
    public Optional<Stock> findStockById(Long id){
        return stockRepository.findById(id);
    }
    
    public Iterable<Stock> findAllStocks(){
        return stockRepository.findAll();
    }
    
    public void delete(Long id){
        stockRepository.deleteById(id);
    }
}
