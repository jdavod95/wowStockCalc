package com.david.wowStockCalculator;

import com.david.wowStockCalculator.domain.dto.ResourceDto;
import com.david.wowStockCalculator.domain.dto.SaleDto;
import com.david.wowStockCalculator.domain.entities.Resource;
import com.david.wowStockCalculator.domain.entities.Sale;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class TestDataUtil {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    private TestDataUtil(){}

    public static Resource createTestResourceA() {
        return Resource.builder()
                .id(1L)
                .name("Dracothyst")
                .onStock(1)
                .build();
    }

    public static Resource createTestResourceB() {
        return Resource.builder()
                .id(2L)
                .name("Zaralek Glowspore")
                .onStock(300)
                .build();
    }

    public static Resource createTestResourceC() {
        return Resource.builder()
                .id(3L)
                .name("Sliken Gemdust")
                .onStock(0)
                .build();
    }

    public static Sale createTestSaleA() {
        return createTestSaleA(null);
    }

    public static Sale createTestSaleA(final Resource resource) {
        return Sale.builder()
                .id(1L)
                .date(getNow())
                .resource(resource)
                .amount(1)
                .cost(1)
                .build();
    }


    public static Sale createTestSaleB(final Resource resource) {
        return Sale.builder()
                .id(2L)
                .date(getNow())
                .resource(resource)
                .amount(300)
                .cost(2)
                .build();
    }

    public static SaleDto createTestSaleDtoA(final ResourceDto resourceDto) {
        return SaleDto.builder()
                .id(1L)
                .date(getNow())
                .resource(resourceDto)
                .amount(1)
                .cost(1)
                .build();
    }

    public static ResourceDto createTestResourceDtoA() {
        return ResourceDto.builder()
                .id(1L)
                .name("Dracothyst")
                .onStock(1)
                .build();
    }

    public static String getNow() {
        return LocalDate.now().format(DateTimeFormatter.ISO_DATE);
    }

    public static String getYesterday() {
        return LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_DATE);
    }
}
