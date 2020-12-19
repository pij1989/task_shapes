package com.pozharsky.dmitri.factory;

import com.pozharsky.dmitri.entity.Point;
import com.pozharsky.dmitri.entity.Shape;
import com.pozharsky.dmitri.exception.ShapeException;

import java.util.List;

public interface ShapeFactory<T extends Shape, E extends Point> {
    T createShape(long id, List<E> points) throws ShapeException;
}
