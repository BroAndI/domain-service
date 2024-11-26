package com.vircheneko.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(schema = "entities", name = "rooms", catalog = "warehouse")
public class Room {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "entities.rooms_id_seq"
    )
    @SequenceGenerator(
            name = "entities.rooms_id_seq",
            schema = "entities",
            catalog = "warehouse",
            allocationSize = 1
    )
    private Integer id;
    private String name;
    private String description;
    private Integer people;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @ManyToMany
    @JoinTable(
            name = "room_to_option",
            schema = "entities",
            catalog = "warehouse",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id")
    )
    private List<Option> options;
    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Room room = (Room) o;
        return getId() != null && Objects.equals(getId(), room.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
