package org.example.chuyen_doi_tien_te.service.impl;

import org.example.chuyen_doi_tien_te.service.ICurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrencyService {
    
    @Override
    public Double convert(String rateStr, String usdStr) {
        try{
            double rate = Double.parseDouble(rateStr);
            double usd = Double.parseDouble(usdStr);
            return rate * usd;
        }catch (NumberFormatException e){
            return null;
        }
       
    }
}
