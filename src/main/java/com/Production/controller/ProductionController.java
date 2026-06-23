package com.Production.controller;


import com.Production.dto.ProductionDto;
import com.Production.entity.Production;
import com.Production.service.ProductionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/production")
public class ProductionController {

    private ProductionService productionService;

    public ProductionController(ProductionService productionService) {
        this.productionService = productionService;
    }

    @GetMapping
    public ResponseEntity<List<ProductionDto>>getAllProductions(){
        List<ProductionDto> allProductions = productionService.getAllProductions();
        return new ResponseEntity<>(allProductions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductionDto>createProductions(@RequestBody ProductionDto productionDto){
        ProductionDto savedProduction = productionService.createProduction(productionDto);
        return new ResponseEntity<>(savedProduction,HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String>deleteProduction(@RequestParam long id){
        productionService.deleteProduction(id);
        return new ResponseEntity<>("DELETED",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductionDto>updateProduction(@PathVariable long id,@RequestBody ProductionDto productionDto){
        ProductionDto upPro = productionService.updateProduction(id, productionDto);
        return new ResponseEntity<>(upPro,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductionDto>getProduction(@PathVariable long id){
        ProductionDto proById = productionService.getProduction(id);
        return new ResponseEntity<>(proById,HttpStatus.OK);
    }

}
