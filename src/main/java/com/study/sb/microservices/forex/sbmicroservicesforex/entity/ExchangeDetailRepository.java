package com.study.sb.microservices.forex.sbmicroservicesforex.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeDetailRepository extends JpaRepository<ExchangeDetail, Long> {

    ExchangeDetail findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
