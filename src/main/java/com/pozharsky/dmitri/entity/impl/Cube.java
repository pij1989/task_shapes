package com.pozharsky.dmitri.entity.impl;

import com.pozharsky.dmitri.entity.Point;
import com.pozharsky.dmitri.entity.Shape;

import java.util.ArrayList;
import java.util.List;

public class Cube implements Shape {
    private List<Point> points;
    private double edge;

    public Cube(List<Point> points, double edge) {
        this.points = points;
        this.edge = edge;
    }

    public boolean addPoint(Point point) {
        return points.add(point);
    }

    public Point getPoint(int index) {
        return points.get(index);
    }

    public void setPoint(int index, Point point) {
        points.set(index, point);
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public void setPoints(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube cube = (Cube) o;

        if (Double.compare(cube.edge, edge) != 0) return false;
        return points != null ? points.equals(cube.points) : cube.points == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = points != null ? points.hashCode() : 0;
        temp = Double.doubleToLongBits(edge);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cube{");
        sb.append("points=").append(points);
        sb.append(", edge=").append(edge);
        sb.append('}');
        return sb.toString();
    }
}
