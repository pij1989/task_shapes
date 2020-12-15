package com.pozharsky.dmitri.specification.impl;

import com.pozharsky.dmitri.action.CubeAction;
import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.specification.Specification;

public class VolumeIntervalSpecification implements Specification<Cube> {
    private double volumeFrom;
    private double volumeTo;

    public VolumeIntervalSpecification(double volumeFrom, double volumeTo) {
        this.volumeFrom = volumeFrom;
        this.volumeTo = volumeTo;
    }

    @Override
    public boolean specify(Cube cube) {
        CubeAction cubeAction = new CubeAction();
        double volume = 0;
        if (cubeAction.isCube(cube)) {
            volume = cubeAction.volumeCube(cube);
        }
        return (volumeFrom <= volume && volume <= volumeTo);
    }
}
