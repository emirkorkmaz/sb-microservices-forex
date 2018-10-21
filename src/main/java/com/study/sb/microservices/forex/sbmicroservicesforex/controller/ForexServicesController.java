package com.study.sb.microservices.forex.sbmicroservicesforex.controller;

import com.study.sb.microservices.forex.sbmicroservicesforex.entity.ExchangeDetail;
import com.study.sb.microservices.forex.sbmicroservicesforex.entity.ExchangeDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexServicesController {

    @Autowired
    public Environment environment;

    @Autowired
    public ExchangeDetailRepository exchangeDetailRepository;

    @GetMapping("/currency-exchange-info/from/{from}/to/{to}")
    public ExchangeDetail getExchangeDetail(@PathVariable String from, @PathVariable String to) {
        ExchangeDetail exchangeDetail = exchangeDetailRepository.
                findByFromCurrencyAndToCurrency(from, to);

        if(null != exchangeDetail) {
            exchangeDetail.setPort(Integer.parseInt(environment.getProperty("server.port")));
        }

        return exchangeDetail;
    }
}
