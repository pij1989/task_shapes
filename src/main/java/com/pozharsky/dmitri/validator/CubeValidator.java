package com.pozharsky.dmitri.validator;

import com.pozharsky.dmitri.entity.impl.CubePoint;

import java.util.List;

public class CubeValidator {
    private static final double ZERO_RESULT = 0.0;

    public boolean isCube(List<CubePoint> cubePoints) {
        for (int i = 0; i < cubePoints.size(); i++) {
            for (CubePoint cubePoint : cubePoints) {
                double difX = Math.abs(cubePoints.get(i).getX() - cubePoint.getX());
                double difY = Math.abs(cubePoints.get(i).getY() - cubePoint.getY());
                double difZ = Math.abs(cubePoints.get(i).getZ() - cubePoint.getZ());
                if (difX != ZERO_RESULT && difY != ZERO_RESULT || difX != ZERO_RESULT && difZ != ZERO_RESULT || difY != ZERO_RESULT && difZ != ZERO_RESULT) {
                    if (difX != difY && difX != difZ && difY != difZ) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
