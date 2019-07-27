package com.example.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		logger.info("++++++++++++++++ Entered into convert service ++++++++++++++++++++++");

//		Map<String, String> uriVariables = new HashMap<>();
//		uriVariables.put("from", from);
//		uriVariables.put("to", to);

//		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
//				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
//				uriVariables);
//		
//		CurrencyConversionBean response = responseEntity.getBody();
		CurrencyConversionBean response=currencyExchangeServiceProxy.retrieveExchangeValue(from, to);
		
	
		return new CurrencyConversionBean(1L, from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
}
