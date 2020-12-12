package com.pozharsky.dmitri.action;

import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.entity.impl.CubePoint;
import com.pozharsky.dmitri.exception.ShapeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CubeAction {
    private static final Logger logger = LogManager.getLogger(CubeAction.class);
    private static final double ZERO_RESULT = 0.0;

    public double surfaceSquare(Cube cube) {
        double edge = defineEdge(cube);
        return 6 * edge * edge;
    }

    public double volumeCube(Cube cube) {
        double edge = defineEdge(cube);
        return edge * edge * edge;
    }

    public boolean isCube(Cube cube) {
        List<CubePoint> cubePoints = cube.getCubePoints();
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

    private double defineEdge(Cube cube) {
        try {
            double edge = Math.abs(cube.getPoint(1).getX() - cube.getPoint(0).getX());
            if (edge == ZERO_RESULT) {
                edge = Math.abs(cube.getPoint(1).getY() - cube.getPoint(0).getY());
            }
            return edge;
        } catch (ShapeException e) {
            logger.fatal("Can not find value of edge for calculate: " + e);
            throw new RuntimeException(e);
        }
    }
}
