package com.hardware.procurement.quotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "quotations")
public class Quotations {

    @Id
    @Column(name = "quotationId")
    private long quotationId;

    @Column(name = "requestId")
    private long requestId;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "deliveryTime")
    private int deliveryTime;

    @Column(name = "approval")
    private boolean approval;

    public Quotations(long quotationId,long requestId, BigDecimal cost, int deliveryTime){
        this.quotationId = quotationId;
        this.requestId = requestId;
        this.cost = cost;
        this.deliveryTime = deliveryTime;
    }

    public boolean isApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public long getQuotationId() {

        return quotationId;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public void setQuotationId(long quotationId) {

        this.quotationId = quotationId;
    }
}
