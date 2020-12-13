package com.pozharsky.dmitri.storage;

import com.pozharsky.dmitri.entity.ParameterCube;

import java.util.HashMap;
import java.util.Map;

public class CubeWarehouse {
    private Map<Long, ParameterCube> parameterCubeMap;
    private static CubeWarehouse cubeWarehouse;

    private CubeWarehouse() {
        this.parameterCubeMap = new HashMap<>();
    }

    public static CubeWarehouse getInstance() {
        if (cubeWarehouse == null) {
            cubeWarehouse = new CubeWarehouse();
        }
        return cubeWarehouse;
    }

    public void putParameterCube(long id, ParameterCube parameterCube) {
        parameterCubeMap.put(id, parameterCube);
    }

    public void updateParameterCube(long id, ParameterCube parameterCube) {
        parameterCubeMap.put(id, parameterCube);
    }

    public ParameterCube getParameterCube(long id) {
        return parameterCubeMap.get(id);
    }
}
