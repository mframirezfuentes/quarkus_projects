package org.acme.hibernate.orm.panache;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;


@Entity
@Cacheable
@ApplicationScoped
public class Fruit extends PanacheEntity {

    @Column(length = 40, unique = true)
    public String name;


}
