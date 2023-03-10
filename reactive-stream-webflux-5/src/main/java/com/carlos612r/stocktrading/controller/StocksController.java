package com.carlos612r.stocktrading.controller;


import java.math.BigDecimal;

import com.carlos612r.stocktrading.dto.StockRequest;
import com.carlos612r.stocktrading.dto.StockResponse;
import com.carlos612r.stocktrading.service.StocksService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/stocks")
public class StocksController {

    private StocksService stocksService;

    @GetMapping("/{id}")
    public Mono<StockResponse> getOneStock(@PathVariable String id) {
        return stocksService.getOneStock(id);
    }

    @GetMapping
    public Flux<StockResponse> getAllStocks(
        @RequestParam(required = false, defaultValue = "0") 
            BigDecimal priceGreaterThan) {
        return stocksService.getAllStocks(priceGreaterThan);
    }

    @PostMapping
    public Mono<StockResponse> createStock(@RequestBody StockRequest stock) {
        return stocksService.createStock(stock);
    }

}
