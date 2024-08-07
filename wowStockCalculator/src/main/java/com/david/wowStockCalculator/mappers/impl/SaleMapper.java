package com.david.wowStockCalculator.mappers.impl;

import com.david.wowStockCalculator.domain.dto.SaleDto;
import com.david.wowStockCalculator.domain.dto.SaleResponseDto;
import com.david.wowStockCalculator.domain.entities.Sale;
import com.david.wowStockCalculator.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SaleMapper implements Mapper<Sale, SaleDto> {

    private ModelMapper modelMapper;

    public SaleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public SaleDto mapTo(Sale sale) {
        return modelMapper.map(sale, SaleDto.class);
    }

    @Override
    public Sale mapFrom(SaleDto saleDto) {
        return modelMapper.map(saleDto, Sale.class);
    }
}
