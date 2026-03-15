package org.almb.domain.model;

import java.util.List;

public class Company {

    private Long id;
    private String cvr;
    private String phoneNumber;
    private Address address;
    private Profitability profitability;
    private List<Owner> owners;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Profitability getProfitability() {
        return profitability;
    }

    public void setProfitability(Profitability profitability) {
        this.profitability = profitability;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }
}