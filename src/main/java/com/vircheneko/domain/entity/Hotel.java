package com.vircheneko.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "hotels", schema = "entities", catalog = "warehouse")
public class Hotel {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "entities.hotels_id_seq"
    )
    @SequenceGenerator(
            name = "entities.hotels_id_seq",
            schema = "entities",
            catalog = "warehouse",
            allocationSize = 1
    )
    private Integer id;
    private String name;
    private String description;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Hotel hotel = (Hotel) o;
        return getId() != null && Objects.equals(getId(), hotel.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
