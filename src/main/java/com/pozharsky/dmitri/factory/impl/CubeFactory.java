package com.pozharsky.dmitri.factory.impl;

import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.entity.impl.CubePoint;
import com.pozharsky.dmitri.exception.ShapeException;
import com.pozharsky.dmitri.factory.ShapeFactory;
import com.pozharsky.dmitri.validator.CubeValidator;

import java.util.List;

public class CubeFactory implements ShapeFactory<Cube, CubePoint> {
    @Override
    public Cube createShape(long id, List<CubePoint> cubePoints) throws ShapeException {
        CubeValidator cubeValidator = new CubeValidator();
        if (!cubeValidator.isCube(cubePoints)) {
            throw new ShapeException("Can not create a cube. List of points is not a cube: " + cubePoints);
        }
        return new Cube(id, cubePoints);
    }
}
