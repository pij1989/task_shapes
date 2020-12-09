package com.pozharsky.dmitri.factory;

import com.pozharsky.dmitri.entity.Point;
import com.pozharsky.dmitri.entity.Shape;

import java.util.List;

public abstract class ShapeFactory<T extends Shape> {
    public abstract T createShape(List<Point> points);
}
