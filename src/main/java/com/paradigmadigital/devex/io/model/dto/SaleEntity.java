package com.paradigmadigital.devex.io.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name = "sales", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    public Long id;

    public long productId;

    public int amount;

    public float price;

    public long shopId;

}
