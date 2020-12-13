package com.pozharsky.dmitri.observer.impl;

import com.pozharsky.dmitri.action.CubeAction;
import com.pozharsky.dmitri.entity.ParameterCube;
import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.observer.Observer;
import com.pozharsky.dmitri.storage.CubeWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeObserver implements Observer<Cube> {
    private static final Logger logger = LogManager.getLogger(CubeObserver.class);

    @Override
    public void performedSurfaceSquare(Cube cube) {
        CubeAction cubeAction = new CubeAction();
        if (cubeAction.isCube(cube)) {
            CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
            long id = cube.getId();
            double square = cubeAction.surfaceSquare(cube);
            ParameterCube parameterCube = cubeWarehouse.getParameterCube(id);
            parameterCube.setSquare(square);
            cubeWarehouse.updateParameterCube(id, parameterCube);
        } else {
            logger.info("Invalid value. Shape isn't a cube");
        }
    }

    @Override
    public void performedVolume(Cube cube) {
        CubeAction cubeAction = new CubeAction();
        if (cubeAction.isCube(cube)) {
            CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
            long id = cube.getId();
            double volume = cubeAction.volumeCube(cube);
            ParameterCube parameterCube = cubeWarehouse.getParameterCube(id);
            parameterCube.setVolume(volume);
            cubeWarehouse.updateParameterCube(id, parameterCube);
        } else {
            logger.info("Invalid value. Shape isn't a cube");
        }
    }
}
