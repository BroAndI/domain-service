package com.vircheneko.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(schema = "entities", name = "options", catalog = "warehouse")
public class Option {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "entities.options_id_seq"
    )
    @SequenceGenerator(
            name = "entities.options_id_seq",
            schema = "entities",
            catalog = "warehouse",
            allocationSize = 1
    )
    private Integer id;
    private String name;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Option option = (Option) o;
        return getId() != null && Objects.equals(getId(), option.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
