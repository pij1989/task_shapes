package com.pozharsky.dmitri.specification.impl;

import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.service.CubeService;
import com.pozharsky.dmitri.specification.Specification;

public class SurfaceSquareIntervalSpecification implements Specification<Cube> {
    private double squareFrom;
    private double squareTo;

    public SurfaceSquareIntervalSpecification(double squareFrom, double squareTo) {
        this.squareFrom = squareFrom;
        this.squareTo = squareTo;
    }

    @Override
    public boolean specify(Cube cube) {
        CubeService cubeService = new CubeService();
        double square = cubeService.volumeCube(cube);
        return (squareFrom <= square && square <= squareTo);
    }
}
