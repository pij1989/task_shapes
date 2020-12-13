package com.pozharsky.dmitri.creator;

import com.pozharsky.dmitri.action.CubeAction;
import com.pozharsky.dmitri.entity.ParameterCube;
import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.repository.impl.CubeRepository;
import com.pozharsky.dmitri.storage.CubeWarehouse;

import java.util.List;

public class CubeWarehouseAndRepositoryCreator {
    public void create(List<Cube> cubes) {
        CubeAction cubeAction = new CubeAction();
        CubeRepository cubeRepository = CubeRepository.getInstance();
        cubes.forEach(cubeRepository::add);
        CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
        for (Cube cube : cubes) {
            if (cubeAction.isCube(cube)) {
                double square = cubeAction.surfaceSquare(cube);
                double volume = cubeAction.volumeCube(cube);
                cubeWarehouse.putParameterCube(cube.getId(), new ParameterCube(square, volume));
            }
        }
    }
}