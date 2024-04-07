package com.inventorymgmt.service;

import com.inventorymgmt.Exception.CustomNotFoundException;
import com.inventorymgmt.bean.NetworkSetting;
import com.inventorymgmt.dto.Stock;
import com.inventorymgmt.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StockService {

    private final StockRepository stockRepository;
    private final NetworkSetting networkSetting;

    public Stock getAvailableStockDetails(String modelNo){
          return   stockRepository.findByModelNo(modelNo).stream().map(
                e->{
                    return Stock.of().stockName(e.getProductName())
                            .quantity(e.getQuantity())
                            .price(e.getPrice())
                            .modelNo(e.getModelNo())
                            .networkSetting(networkSetting)
                            .build();
                }
        ).findFirst().orElseThrow(()->new CustomNotFoundException("not found"));
    }
}
