package com.pozharsky.dmitri.factory.impl;

import com.pozharsky.dmitri.entity.impl.CubePoint;
import com.pozharsky.dmitri.factory.PointFactory;

public class CubePointFactory implements PointFactory<CubePoint> {

    @Override
    public CubePoint createPoint(double x, double y, double z) {
        return new CubePoint(x, y, z);
    }
}
