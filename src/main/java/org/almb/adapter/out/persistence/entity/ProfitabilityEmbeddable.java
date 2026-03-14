package org.almb.adapter.out.persistence.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProfitabilityEmbeddable {

    private Double revenue;
    private Double expenses;
    private Double netProfit;


    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public Double getExpenses() {
        return expenses;
    }

    public void setExpenses(Double expenses) {
        this.expenses = expenses;
    }

    public Double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(Double netProfit) {
        this.netProfit = netProfit;
    }

    @Override
    public String toString() {
        return "ProfitabilityEmbeddable{" +
                "revenue=" + revenue +
                ", expenses=" + expenses +
                ", netProfit=" + netProfit +
                '}';
    }
}
