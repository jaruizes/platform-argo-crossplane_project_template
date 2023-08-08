package com.paradigmadigital.devex.business;

import com.paradigmadigital.devex.business.model.Sale;
import com.paradigmadigital.devex.io.SaleRepository;
import com.paradigmadigital.devex.io.model.api.SaleApi;
import com.paradigmadigital.devex.io.model.dto.SaleEntity;
import com.paradigmadigital.devex.utils.SaleMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceDefault implements SaleService{

    private final SaleRepository saleRepository;

    public SaleServiceDefault(SaleRepository saleRepository){
        this.saleRepository = saleRepository;
    }

    @Override
    public void createSale(Sale sale){
        saleRepository.save(SaleMapper.businessToEntity(sale));
    }

    @Override
    public List<SaleApi> getSales(Long productId, Long shopId){
        List<Sale> sales = saleRepository.findByFilters(productId, shopId).stream().map(SaleMapper::entityToBusiness).toList();
        return sales.stream().map(SaleMapper::businessToApi).toList();
    }

    @Override
    public SaleApi getSaleById(long id) throws Exception {
        Sale sale = SaleMapper.entityToBusiness(saleRepository.findById(id).orElseThrow(Exception::new));
        return SaleMapper.businessToApi(sale);
    }

    @PostConstruct
    private void init(){
        // init
        saleRepository.save(SaleEntity.builder().productId(1L).amount(10).price(20.0f).shopId(1L).build());
        saleRepository.save(SaleEntity.builder().productId(2L).amount(2).price(50.0f).shopId(1L).build());
        saleRepository.save(SaleEntity.builder().productId(1L).amount(10).price(20.0f).shopId(2L).build());
        saleRepository.save(SaleEntity.builder().productId(2L).amount(2).price(50.0f).shopId(2L).build());
        saleRepository.save(SaleEntity.builder().productId(3L).amount(10).price(20.0f).shopId(3L).build());
        saleRepository.save(SaleEntity.builder().productId(1L).amount(2).price(50.0f).shopId(3L).build());
        saleRepository.save(SaleEntity.builder().productId(1L).amount(10).price(20.0f).shopId(4L).build());
        saleRepository.save(SaleEntity.builder().productId(3L).amount(2).price(50.0f).shopId(4L).build());
        saleRepository.save(SaleEntity.builder().productId(4L).amount(10).price(20.0f).shopId(4L).build());
        saleRepository.save(SaleEntity.builder().productId(2L).amount(2).price(50.0f).shopId(4L).build());
    }

}
