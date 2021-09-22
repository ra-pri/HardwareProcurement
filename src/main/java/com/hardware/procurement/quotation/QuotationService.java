package com.hardware.procurement.quotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QuotationService {

    @Autowired
    private QuotationRepo quotationRepo;

    public List<Long> bestDeal(){
        BigDecimal minPrice = quotationRepo.getMinCost();
        int minDelivery = quotationRepo.getMinDeliveryTime();
        HashMap<Long,Double> weightHashMap = new HashMap<>();
        Iterable<Quotations> quotations = quotationRepo.findAll();
        List<Double> weightedParameters = new ArrayList<>();
        for(Quotations q : quotations){
            BigDecimal multiplier = new BigDecimal(0.6);
            BigDecimal addNormalizeDelivery = new BigDecimal((minDelivery/q.getDeliveryTime())*0.4);
            double sum = (minPrice.divide(q.getCost()).multiply(multiplier).add(addNormalizeDelivery)).doubleValue();
            weightHashMap.put(q.getQuotationId(),sum);
        }
        List<Long> quotationIds = weightHashMap.entrySet().stream().sorted(Map.Entry.<Long,Double>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
        return quotationIds;
    }
}

