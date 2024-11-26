package com.vircheneko.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "address", schema = "entities", catalog = "warehouse")
public class Address {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "entities.address_id_seq"
    )
    @SequenceGenerator(
            name = "entities.address_id_seq",
            schema = "entities",
            catalog = "warehouse",
            allocationSize = 1
    )
    private Integer id;
    private String country;
    private String city;
    private String street;
    private String house;
    private String apartment;
    private String zip;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Address address = (Address) o;
        return getId() != null && Objects.equals(getId(), address.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
