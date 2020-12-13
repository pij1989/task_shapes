package com.pozharsky.dmitri.observer;

import com.pozharsky.dmitri.entity.Shape;

public interface Observer<T extends Shape> {
    void performedSurfaceSquare(T entity);
    void performedVolume(T entity);
}
