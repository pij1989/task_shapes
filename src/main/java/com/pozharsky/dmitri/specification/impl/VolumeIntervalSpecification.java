package com.pozharsky.dmitri.specification.impl;

import com.pozharsky.dmitri.service.CubeService;
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
        CubeService cubeService = new CubeService();
        double volume = 0;
        if (cubeService.isCube(cube)) {
            volume = cubeService.volumeCube(cube);
        }
        return (volumeFrom <= volume && volume <= volumeTo);
    }
}
