package com.pozharsky.dmitri.entity.impl;

import com.pozharsky.dmitri.entity.Shape;
import com.pozharsky.dmitri.exception.ShapeException;
import com.pozharsky.dmitri.observer.Observable;
import com.pozharsky.dmitri.observer.Observer;
import com.pozharsky.dmitri.observer.impl.CubeObserver;

import java.util.ArrayList;
import java.util.List;

public class Cube implements Shape<CubePoint>, Observable<CubeObserver> {
    private long id;
    private List<CubePoint> cubePoints;
    private Observer<Cube> observer;

    public Cube() {
        this.cubePoints = new ArrayList<>();
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
        notifyObserver();
    }

    @Override
    public void addPoint(CubePoint point) throws ShapeException {
        if (point == null) {
            throw new ShapeException("Can not add zero point to cube");
        }
        cubePoints.add(point);
    }

    @Override
    public CubePoint getPoint(int index) throws ShapeException {
        if (index < 0 || index >= cubePoints.size()) {
            throw new ShapeException("Incorrect index. It should be more than zero and less than size");
        }
        return cubePoints.get(index);
    }

    @Override
    public void setPoint(int index, CubePoint point) throws ShapeException {
        if (point == null) {
            throw new ShapeException("Can not add zero point to cube");
        }
        if (index < 0 || index >= cubePoints.size()) {
            throw new ShapeException("Incorrect index. It should be more than zero and less than size");
        }
        cubePoints.set(index, point);
        notifyObserver();
    }

    @Override
    public void attach(CubeObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detach(CubeObserver observer) {
        this.observer = null;
    }

    @Override
    public void notifyObserver() {
        if (observer != null) {
            observer.performedSurfaceSquare(this);
            observer.performedVolume(this);
        }
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
