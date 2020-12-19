package com.pozharsky.dmitri.service;

import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.entity.impl.CubePoint;
import com.pozharsky.dmitri.exception.ShapeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CubeService {
    private static final Logger logger = LogManager.getLogger(CubeService.class);
    private static final double ZERO_RESULT = 0.0;
    private static final int SIDE_NUMBER = 6;
    private static final int COORDINATE_NUMBER = 4;

    public double surfaceSquare(Cube cube) {
        double edge = defineEdge(cube);
        return SIDE_NUMBER * edge * edge;
    }

    public double volumeCube(Cube cube) {
        double edge = defineEdge(cube);
        return edge * edge * edge;
    }

    public boolean isBaseOnCoordinatePlane(Cube cube) {
        int countX = 0;
        int countY = 0;
        int countZ = 0;
        List<CubePoint> cubePoints = cube.getCubePoints();
        for (CubePoint cubePoint : cubePoints) {
            double x = cubePoint.getX();
            double y = cubePoint.getY();
            double z = cubePoint.getZ();
            if (x == ZERO_RESULT) {
                countX++;
            }
            if (y == ZERO_RESULT) {
                countY++;
            }
            if (z == ZERO_RESULT) {
                countZ++;
            }
            if (countX == COORDINATE_NUMBER || countY == COORDINATE_NUMBER || countZ == COORDINATE_NUMBER) {
                return true;
            }
        }
        return false;
    }

    public double relationVolumeAfterPlaneDissect(Cube cube) {
        List<CubePoint> cubePoints = cube.getCubePoints();
        List<Double> coordinateX = new ArrayList<>();
        List<Double> coordinateY = new ArrayList<>();
        List<Double> coordinateZ = new ArrayList<>();
        for (CubePoint cubePoint : cubePoints) {
            double x = cubePoint.getX();
            double y = cubePoint.getY();
            double z = cubePoint.getZ();
            if (x >= ZERO_RESULT) {
                coordinateX.add(x);
            }
            if (y >= ZERO_RESULT) {
                coordinateY.add(y);
            }
            if (z >= ZERO_RESULT) {
                coordinateZ.add(z);
            }
        }
        if (coordinateX.size() == COORDINATE_NUMBER) {
            return calculateRelation(cube, coordinateX);
        } else {
            if (coordinateY.size() == COORDINATE_NUMBER) {
                return calculateRelation(cube, coordinateY);
            } else {
                if (coordinateZ.size() == COORDINATE_NUMBER) {
                    return calculateRelation(cube, coordinateY);
                } else {
                    return ZERO_RESULT;
                }
            }
        }
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

    private double calculateRelation(Cube cube, List<Double> coordinate) {
        double edge = defineEdge(cube);
        double firstPartOfEdge = Math.abs(coordinate.get(0));
        double secondPartOfEdge = edge - firstPartOfEdge;
        double firstVolume = edge * edge * firstPartOfEdge;
        double secondVolume = edge * edge * secondPartOfEdge;
        if (firstVolume >= secondVolume) {
            return firstVolume / secondVolume;
        } else {
            return secondVolume / firstVolume;
        }
    }
}
