package com.paradigmadigital.devex.utils;

import com.paradigmadigital.devex.business.model.Sale;
import com.paradigmadigital.devex.io.model.api.SaleApi;
import com.paradigmadigital.devex.io.model.dto.SaleEntity;

public class SaleMapper {

    public static Sale brokerToBusiness(String[] sale) {
        return Sale
                .builder()
                .productId(Long.parseLong(sale[0]))
                .amount(Integer.parseInt(sale[1]))
                .price(Float.parseFloat(sale[2]))
                .shopId(Long.parseLong(sale[3]))
                .build();
    }

    public static SaleApi businessToApi(Sale sale) {
        return SaleApi
                .builder()
                .id(sale.id)
                .productId(sale.productId)
                .amount(sale.amount)
                .price(sale.price)
                .shopId(sale.shopId)
                .build();
    }

    public static SaleEntity businessToEntity(Sale sale) {
        return SaleEntity
                .builder()
                .productId(sale.productId)
                .amount(sale.amount)
                .price(sale.price)
                .shopId(sale.shopId)
                .build();
    }

    public static Sale entityToBusiness(SaleEntity sale) {
        return Sale
                .builder()
                .id(sale.id)
                .productId(sale.productId)
                .amount(sale.amount)
                .price(sale.price)
                .shopId(sale.shopId)
                .build();
    }

}
