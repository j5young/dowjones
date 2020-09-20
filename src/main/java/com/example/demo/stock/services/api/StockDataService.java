package com.example.demo.stock.services.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.stock.data.model.StockData;
import com.example.demo.stock.data.repositories.StockDataRepository;

@Service
public class StockDataService{
	
	@Autowired
	private StockDataRepository repository;

	public List<StockData> findByStockName(String stockName) {
		List<StockData> result = repository.findByStockName(stockName);
	    if (!result.isEmpty()) {
	        return result;
	    } else {
	        return null;
	    }
	}

	public StockData insert(StockData s) {
		// TODO Auto-generated method stub
		return repository.save(s);
	}

}
