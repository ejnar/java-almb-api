package org.almb.adapter.out.persistence.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "companies")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cvr;

    private String phoneNumber;

    @Embedded
    private ProfitabilityEmbeddable profitability;

    @Embedded
    private AddressEmbeddable address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OwnerEntity> owners;

    public Long getId() {
        return id;
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

    public ProfitabilityEmbeddable getProfitability() {
        return profitability;
    }

    public void setProfitability(ProfitabilityEmbeddable profitability) {
        this.profitability = profitability;
    }

    public AddressEmbeddable getAddress() {
        return address;
    }

    public void setAddress(AddressEmbeddable address) {
        this.address = address;
    }

    public List<OwnerEntity> getOwners() {
        return owners;
    }

    public void setOwners(List<OwnerEntity> owners) {
        this.owners = owners;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity that = (CompanyEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "id=" + id +
                ", cvr='" + cvr + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", profitability=" + profitability +
                ", address=" + address +
                ", owners=" + owners +
                '}';
    }
}