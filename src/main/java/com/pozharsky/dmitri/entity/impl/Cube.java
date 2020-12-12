package com.pozharsky.dmitri.entity.impl;

import com.pozharsky.dmitri.entity.Shape;
import com.pozharsky.dmitri.exception.ShapeException;

import java.util.ArrayList;
import java.util.List;

public class Cube implements Shape<CubePoint> {
    private long id;
    private List<CubePoint> cubePoints;

    public Cube() {
    }

    public Cube(long id, List<CubePoint> cubePoints) {
        this.id = id;
        this.cubePoints = new ArrayList<>(cubePoints);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<CubePoint> getCubePoints() {
        return new ArrayList<>(cubePoints);
    }

    public void setCubePoints(List<CubePoint> cubePoints) {
        this.cubePoints = new ArrayList<>(cubePoints);
    }

    @Override
    public boolean addPoint(CubePoint point) throws ShapeException {
        if (point == null) {
            throw new ShapeException("Can not add zero point to cube");
        }
        return cubePoints.add(point);
    }

    @Override
    public CubePoint getPoint(int index) throws ShapeException {
        if (index < 0 || index >= cubePoints.size()) {
            throw new ShapeException("Incorrect index. It should be more than zero and less than size");
        }
        return null;
    }

    @Override
    public CubePoint setPoint(int index, CubePoint point) throws ShapeException {
        if (point == null) {
            throw new ShapeException("Can not add zero point to cube");
        }
        if (index < 0 || index >= cubePoints.size()) {
            throw new ShapeException("Incorrect index. It should be more than zero and less than size");
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube cube = (Cube) o;

        if (id != cube.id) return false;
        return cubePoints != null ? cubePoints.equals(cube.cubePoints) : cube.cubePoints == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (cubePoints != null ? cubePoints.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cube{");
        sb.append("id=").append(id);
        sb.append(", cubePoints=").append(cubePoints);
        sb.append('}');
        return sb.toString();
    }
}
