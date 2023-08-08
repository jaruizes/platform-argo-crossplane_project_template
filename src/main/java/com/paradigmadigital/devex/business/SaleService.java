package com.paradigmadigital.devex.business;

import com.paradigmadigital.devex.business.model.Sale;
import com.paradigmadigital.devex.io.model.api.SaleApi;

import java.util.List;

public interface SaleService {

    void createSale(Sale sale);
    SaleApi getSaleById(long id) throws Exception;
    List<SaleApi> getSales(Long productId, Long shopId);


}
