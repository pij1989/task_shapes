package com.pozharsky.dmitri.factory;

import com.pozharsky.dmitri.entity.Point;
import com.pozharsky.dmitri.entity.impl.Cube;

import java.util.List;

public class CubeFactory extends ShapeFactory<Cube> {
    @Override
    public Cube createShape(List<Point> points) {
        return new Cube(points);
    }
}
