package com.pozharsky.dmitri.entity;

public class ParameterCube {
    private double square;
    private double volume;

    public ParameterCube(double square, double volume) {
        this.square = square;
        this.volume = volume;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParameterCube that = (ParameterCube) o;

        if (Double.compare(that.square, square) != 0) return false;
        return Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(square);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(volume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ParameterCube{");
        sb.append("square=").append(square);
        sb.append(", volume=").append(volume);
        sb.append('}');
        return sb.toString();
    }
}
