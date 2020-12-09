package com.pozharsky.dmitri.factory.impl;

import com.pozharsky.dmitri.entity.impl.CubePoint;
import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.factory.ShapeFactory;

import java.util.List;

public class CubeFactory implements ShapeFactory<Cube> {
    @Override
    public Cube createShape(List<CubePoint> cubePoints) {
        return new Cube(cubePoints);
    }
}
