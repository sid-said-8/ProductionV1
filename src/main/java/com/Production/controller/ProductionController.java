package com.Production.controller;


import com.Production.entity.Production;
import com.Production.service.ProductionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/production")
public class ProductionController {

    private ProductionService productionService;

    public ProductionController(ProductionService productionService) {
        this.productionService = productionService;
    }

    @GetMapping
    public ResponseEntity<List<Production>>getAllProductions(){
        List<Production> allProductions = productionService.getAllProductions();
        return new ResponseEntity<>(allProductions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Production>createProductions(@RequestBody Production pro){
        Production savedProduction = productionService.createProduction(pro);
        return new ResponseEntity<>(savedProduction,HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String>deleteProduction(@RequestParam long id){
        productionService.deleteProduction(id);
        return new ResponseEntity<>("DELETED",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Production>updateProduction(@PathVariable long id,@RequestBody Production production){
        Production upPro = productionService.updateProduction(id, production);
        return new ResponseEntity<>(upPro,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Production>getProduction(@PathVariable long id){
        Production proById = productionService.getProduction(id);
        return new ResponseEntity<>(proById,HttpStatus.OK);
    }

}
