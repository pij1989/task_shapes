package com.pozharsky.dmitri.entity;

import com.pozharsky.dmitri.exception.ShapeException;

public interface Shape<T extends Point> {
    void addPoint(T point) throws ShapeException;

    T getPoint(int index) throws ShapeException;

    void setPoint(int index, T point) throws ShapeException;
}
