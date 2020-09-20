package com.example.demo.stock.data.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.stock.data.model.StockData;

@Repository
public interface StockDataRepository extends CrudRepository<StockData,Long> {

	@Query(value="select * from stock_data s where s.stock_name = ?1", nativeQuery=true)
	List<StockData> findByStockName(String stockName);

}
