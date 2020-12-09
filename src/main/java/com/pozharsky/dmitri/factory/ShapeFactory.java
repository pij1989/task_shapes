package com.pozharsky.dmitri.factory;

import com.pozharsky.dmitri.entity.impl.CubePoint;
import com.pozharsky.dmitri.entity.Shape;

import java.util.List;

public interface ShapeFactory<T extends Shape> {
    T createShape(List<CubePoint> cubePoints);
}
