package com.paradigmadigital.devex.io;

import com.paradigmadigital.devex.business.SaleServiceDefault;
import com.paradigmadigital.devex.utils.SaleMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SaleConsumer {

    private SaleServiceDefault saleService;
    public SaleConsumer(SaleServiceDefault saleService){
        this.saleService = saleService;
    }

    @KafkaListener(topics = "${kafka.topic.sales}", containerFactory = "kafkaListenerContainerFactory")
    public void consumeSalesFromKafka(ConsumerRecord<String, String> record){
        String key = record.key();
        String value = record.value();
        System.out.printf("Message received for key: %s, value : %s%n", key, value.toString());

        saleService.createSale(SaleMapper.brokerToBusiness(value.split(",")));
    }

}
