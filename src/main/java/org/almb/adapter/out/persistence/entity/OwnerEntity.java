package org.almb.adapter.out.persistence.entity;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "owners")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpr;

    @Embedded
    private AddressEmbeddable address;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public AddressEmbeddable getAddress() {
        return address;
    }

    public void setAddress(AddressEmbeddable address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OwnerEntity that = (OwnerEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "OwnerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpr='" + cpr + '\'' +
                ", address=" + address +
                '}';
    }
}