package com.Production.service;

import com.Production.entity.Production;
import com.Production.repository.ProductionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductionService {

    private ProductionRepository productionRepository;

    public ProductionService(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    public List<Production> getAllProductions() {
        List<Production> allPros = productionRepository.findAll();
        return allPros;
    }

    public Production createProduction(Production pro) {
        Production savedPros = productionRepository.save(pro);
        return savedPros;
    }

    public void deleteProduction(long id) {
        productionRepository.deleteById(id);
    }

    public Production updateProduction(long id, Production production) {
        Production pro = productionRepository.findById(id).get();
        pro.setEmail(production.getEmail());
        pro.setName(production.getName());
        pro.setMobile(production.getMobile());
        pro.setUsername(production.getUsername());
        Production updatedPro = productionRepository.save(pro);
        return updatedPro;

    }

    public Production getProduction(long id) {
            Optional<Production> proById = productionRepository.findById(id);
            return proById.orElse(null);
    }
}
