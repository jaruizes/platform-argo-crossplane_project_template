package com.paradigmadigital.devex.io;

import com.paradigmadigital.devex.business.SaleServiceDefault;
import com.paradigmadigital.devex.io.model.api.SaleApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleController {

    private SaleServiceDefault saleService;

    public SaleController(SaleServiceDefault saleService){
        this.saleService = saleService;
    }

    @GetMapping(value = "/sales", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<SaleApi> getSales(@RequestParam(required = false) Long productId, @RequestParam(required = false) Long shopId) {
        return saleService.getSales(productId, shopId);
    }

    @GetMapping(value = "/sales/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public SaleApi getSalesById(@PathVariable("id") long id) throws Exception {
        return saleService.getSaleById(id);
    }




}
