package com.pozharsky.dmitri.specification.impl;

import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.specification.Specification;

public class IdIntervalSpecification implements Specification<Cube> {
    private long from;
    private long to;

    public IdIntervalSpecification(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specify(Cube cube) {
        long id = cube.getId();
        return (from <= id && id <= to);
    }
}
