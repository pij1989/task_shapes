package com.pozharsky.dmitri.observer.impl;

import com.pozharsky.dmitri.entity.ParameterCube;
import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.observer.Observer;
import com.pozharsky.dmitri.service.CubeService;
import com.pozharsky.dmitri.storage.CubeWarehouse;
import com.pozharsky.dmitri.validator.CubeValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeObserver implements Observer<Cube> {
    private static final Logger logger = LogManager.getLogger(CubeObserver.class);

    @Override
    public void performedSurfaceSquare(Cube cube) {
        CubeService cubeService = new CubeService();
        CubeValidator cubeValidator = new CubeValidator();
        if (cubeValidator.isCube(cube.getCubePoints())) {
            CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
            long id = cube.getId();
            double square = cubeService.surfaceSquare(cube);
            ParameterCube parameterCube = cubeWarehouse.getParameterCube(id);
            parameterCube.setSquare(square);
            cubeWarehouse.updateParameterCube(id, parameterCube);
        } else {
            logger.info("Invalid value. Shape isn't a cube");
        }
    }

    @Override
    public void performedVolume(Cube cube) {
        CubeService cubeService = new CubeService();
        CubeValidator cubeValidator = new CubeValidator();
        if (cubeValidator.isCube(cube.getCubePoints())) {
            CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
            long id = cube.getId();
            double volume = cubeService.volumeCube(cube);
            ParameterCube parameterCube = cubeWarehouse.getParameterCube(id);
            parameterCube.setVolume(volume);
            cubeWarehouse.updateParameterCube(id, parameterCube);
        } else {
            logger.info("Invalid value. Shape isn't a cube");
        }
    }
}
