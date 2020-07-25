package com.example.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.InventoryClient;
import com.example.demo.StockClient;
import com.example.model.OrderData;
import com.example.model.Stock;
import com.example.model.StockProducts;
import com.example.repository.SalesRepository;
import com.example.repository.StockRepository;

@Service
public class SalesService {

	@Autowired
	SalesRepository salesRepository;

	@Autowired
	InventoryClient inventoryClient;
	@Autowired
	StockClient stockClient;
	@Autowired
	StockRepository stockRepository;

	public List<Stock> getStock() {
		return stockClient.getNewAllStock();
	}

	public Iterable<StockProducts> getProducts(String sid) {
		return inventoryClient.getNewAllProducts(sid);
	}

	public ResponseEntity<String> placeOrder(String sid, String pid, String q) {

		int qty = Integer.parseInt(q);
		Optional<Stock> stock = stockClient.getStockBySid(sid);
		Optional<StockProducts> product = inventoryClient.getProduct(sid, pid);

		if (stock.isPresent() && product.isPresent()) {

			Stock s = stock.get();
			StockProducts sp = product.get();

			if (qty < s.getQty()) {

				s.setQty(s.getQty() - qty);
				stockRepository.save(s);

				OrderData order = new OrderData();
				order.setAmount((double) ((qty * sp.getListPrice()) - sp.getDiscount()));
				order.setDiscount(sp.getDiscount());
				order.setListPrice((double) sp.getListPrice());
				order.setProductName(sp.getProductName());
				order.setStockId(s.getSupplierId());
				order.setProductId(sp.getPid());
				order.setOrderedDate((new Date()).toString());
				order.setQty(qty);

				salesRepository.save(order);
				return new ResponseEntity<>("stock of quantity " + qty + " has been ordered", HttpStatus.ACCEPTED);
			} else {

				return new ResponseEntity<>("Ordered quantity not available in the inventory",
						HttpStatus.NOT_ACCEPTABLE);
			}

		} else {
			return new ResponseEntity<>("Neither stock nor product are present", HttpStatus.NOT_FOUND);
		}

	}

}
