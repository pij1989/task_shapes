package com.pozharsky.dmitri.repository.impl;

import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.repository.Repository;
import com.pozharsky.dmitri.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CubeRepository implements Repository<Cube> {
    private List<Cube> cubes;
    private static CubeRepository cubeRepository;

    private CubeRepository() {
        this.cubes = new ArrayList<>();
    }

    public static CubeRepository getInstance() {
        if (cubeRepository == null) {
            cubeRepository = new CubeRepository();
        }
        return cubeRepository;
    }

    @Override
    public void add(Cube entity) {
        cubes.add(entity);
    }

    @Override
    public void remove(Cube entity) {
        cubes.remove(entity);
    }

    @Override
    public Cube get(int index) {
        return cubes.get(index);
    }

    @Override
    public List<Cube> sort(Comparator<? super Cube> comparator) {
        return cubes.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public List<Cube> query(Specification<Cube> specification) {
        return cubes.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
    }
}
