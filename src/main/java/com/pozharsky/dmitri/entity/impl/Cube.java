package com.pozharsky.dmitri.entity.impl;

import com.pozharsky.dmitri.entity.Shape;

import java.util.ArrayList;
import java.util.List;

public class Cube implements Shape {
    private List<CubePoint> cubePoints;

    public Cube(List<CubePoint> cubePoints) {
        this.cubePoints = cubePoints;
    }

    public boolean addPoint(CubePoint cubePoint) {
        return cubePoints.add(cubePoint);
    }

    public CubePoint getPoint(int index) {
        return cubePoints.get(index);
    }

    public void setPoint(int index, CubePoint cubePoint) {
        cubePoints.set(index, cubePoint);
    }

    public List<CubePoint> getCubePoints() {
        return new ArrayList<>(cubePoints);
    }

    public void setCubePoints(List<CubePoint> cubePoints) {
        this.cubePoints = new ArrayList<>(cubePoints);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube cube = (Cube) o;

        return cubePoints != null ? cubePoints.equals(cube.cubePoints) : cube.cubePoints == null;
    }

    @Override
    public int hashCode() {
        return cubePoints != null ? cubePoints.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cube{");
        sb.append("points=").append(cubePoints);
        sb.append('}');
        return sb.toString();
    }
}
