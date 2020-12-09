package com.pozharsky.dmitri.factory;

import com.pozharsky.dmitri.entity.Point;

public interface PointFactory<T extends Point> {
    T createPoint(double x, double y, double z);
}
