package com.hardware.procurement.quotation;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

public interface QuotationRepo extends CrudRepository<Quotations, Long> {

    @Query(value = "select MIN(cost) from quotations")
    public BigDecimal getMinCost();

    @Query(value = "select MIN(deliveryTime) from quotations")
    public int getMinDeliveryTime();


}
