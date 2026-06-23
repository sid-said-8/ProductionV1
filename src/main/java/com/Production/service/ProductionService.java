package com.Production.service;

import com.Production.dto.ProductionDto;
import com.Production.entity.Production;
import com.Production.exception.ResourceNotFoundException;
import com.Production.repository.ProductionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductionService {

    private ProductionRepository productionRepository;

    private ModelMapper modelMapper;

    public ProductionService(ProductionRepository productionRepository, ModelMapper modelMapper) {
        this.productionRepository = productionRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProductionDto> getAllProductions() {
            return productionRepository.findAll()
                    .stream()
                    .map(this::mapToDto)
                    .toList();
//        List<Production> allPros = productionRepository.findAll();
//        List<ProductionDto> proDto = allPros.stream().map(p->mapToDto(p)).collect(Collectors.toList());
//        return proDto;
    }

    Production mapToEntity(ProductionDto productionDto){
        Production production = modelMapper.map(productionDto, Production.class);
        return production;
    }

    ProductionDto mapToDto(Production production){
        ProductionDto productionDto = modelMapper.map(production, ProductionDto.class);
        return  productionDto;
    }

    public ProductionDto createProduction(ProductionDto productionDto) {
        Production production = mapToEntity(productionDto);
        Production savedPros = productionRepository.save(production);
        return mapToDto(savedPros);
    }

    public void deleteProduction(long id) {
        productionRepository.deleteById(id);
    }

    public ProductionDto updateProduction(long id, ProductionDto productionDto) {
        Production pro = productionRepository.findById(id).get();
        pro.setEmail(productionDto.getEmail());
        pro.setName(productionDto.getName());
        pro.setMobile(productionDto.getMobile());
        pro.setUsername(productionDto.getUsername());
        Production updatedPro = productionRepository.save(pro);
        return mapToDto(updatedPro);

    }

    public ProductionDto getProduction(long id) {
        Production production = productionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Record not Found"));
        return mapToDto(production);
    }
}
