package com.pozharsky.dmitri.creator;

import com.pozharsky.dmitri.service.CubeService;
import com.pozharsky.dmitri.entity.ParameterCube;
import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.repository.impl.CubeRepository;
import com.pozharsky.dmitri.storage.CubeWarehouse;

import java.util.List;

public class CubeWarehouseAndRepositoryCreator {
    public void create(List<Cube> cubes) {
        CubeService cubeService = new CubeService();
        CubeRepository cubeRepository = CubeRepository.getInstance();
        cubes.forEach(cubeRepository::add);
        CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
        for (Cube cube : cubes) {
            if (cubeService.isCube(cube)) {
                double square = cubeService.surfaceSquare(cube);
                double volume = cubeService.volumeCube(cube);
                cubeWarehouse.putParameterCube(cube.getId(), new ParameterCube(square, volume));
            }
        }
    }
}
