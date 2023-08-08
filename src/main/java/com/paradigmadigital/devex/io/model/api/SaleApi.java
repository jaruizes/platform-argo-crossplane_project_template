package com.paradigmadigital.devex.io.model.api;

import lombok.Builder;

@Builder
public class SaleApi {

    public Long id;
    public long productId;
    public int amount;
    public float price;
    public long shopId;

}
