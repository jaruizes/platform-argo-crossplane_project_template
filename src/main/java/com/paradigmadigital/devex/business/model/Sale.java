package com.paradigmadigital.devex.business.model;

import lombok.Builder;

@Builder
public class Sale {

    public Long id;
    public long productId;
    public int amount;
    public float price;
    public long shopId;

}
