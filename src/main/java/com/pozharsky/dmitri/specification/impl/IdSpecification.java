package com.pozharsky.dmitri.specification.impl;

import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.specification.Specification;

public class IdSpecification implements Specification<Cube> {
    private long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Cube entity) {
        return entity.getId() == id;
    }
}
