package com.inventorymgmt.api.controller;

import com.inventorymgmt.Exception.CustomNotFoundException;
import com.inventorymgmt.dto.Stock;
import com.inventorymgmt.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventorymgmt")
@AllArgsConstructor
public class StockApiController {
    private final StockService stockService;
    @GetMapping(value="{modelNo}/Available",produces= MediaType.APPLICATION_JSON_VALUE)
    public Stock getAvailableStockDetails(@PathVariable("modelNo") String modelNo){
        return stockService.getAvailableStockDetails(modelNo);
    }
   @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<String> handleException(CustomNotFoundException e){
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

   }
}
