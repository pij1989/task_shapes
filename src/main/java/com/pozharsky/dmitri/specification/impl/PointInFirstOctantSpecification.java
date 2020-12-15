package com.pozharsky.dmitri.specification.impl;

import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.entity.impl.CubePoint;
import com.pozharsky.dmitri.specification.Specification;

import java.util.List;

public class PointInFirstOctantSpecification implements Specification<Cube> {
    private static final double ZERO_COORDINATE = 0.0;

    @Override
    public boolean specify(Cube cube) {
        List<CubePoint> cubePoints = cube.getCubePoints();
        for (CubePoint point : cubePoints) {
            if (point.getX() < ZERO_COORDINATE || point.getY() < ZERO_COORDINATE || point.getZ() < ZERO_COORDINATE) {
                return false;
            }
        }
        return true;
    }
}
