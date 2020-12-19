package com.pozharsky.dmitri.service;

import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.entity.impl.CubePoint;
import com.pozharsky.dmitri.generator.CubeIdGenerator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CubeServiceTest {
    CubeService cubeService;
    Cube cube;

    @BeforeMethod
    public void setUp() {
        List<CubePoint> points = List.of(new CubePoint(1.0, 1.0, 0.0), new CubePoint(5.0, 1.0, 0.0),
                new CubePoint(5.0, 5.0, 0.0), new CubePoint(1.0, 5.0, 0.0), new CubePoint(1.0, 1.0, 4.0),
                new CubePoint(5.0, 1.0, 4.0), new CubePoint(5.0, 5.0, 4.0), new CubePoint(1.0, 5.0, 4.0));
        cube = new Cube(CubeIdGenerator.generate(), points);
        cubeService = new CubeService();
    }

    @AfterMethod
    public void tearDown() {
        cube = null;
        cubeService = null;
    }

    @Test
    public void testSurfaceSquare() {
        double actual = cubeService.surfaceSquare(cube);
        double expect = 96.0;
        assertEquals(actual, expect);
    }

    @Test
    public void testVolumeCube() {
        double actual = cubeService.volumeCube(cube);
        double expect = 64.0;
        assertEquals(actual, expect);
    }

    @Test
    public void testIsBaseOnCoordinatePlane() {
        boolean actual = cubeService.isBaseOnCoordinatePlane(cube);
        assertTrue(actual);
    }

    @Test
    public void testRelationVolumeAfterPlaneDissect() {
        double actual = cubeService.relationVolumeAfterPlaneDissect(cube);
        double expect = 0.0;
        assertEquals(actual, expect);
    }
}
