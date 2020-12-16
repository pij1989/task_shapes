package com.pozharsky.dmitri.comparator;

import com.pozharsky.dmitri.entity.impl.Cube;
import com.pozharsky.dmitri.entity.impl.CubePoint;

import java.util.Comparator;

public enum CubeComparator implements Comparator<Cube> {
    ID {
        @Override
        public int compare(Cube o1, Cube o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    },
    FIRST_POINT_X {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(0);
            CubePoint point2 = o2.getCubePoints().get(0);
            return CubePointComparator.X.compare(point1, point2);
        }
    },
    FIRST_POINT_Y {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(0);
            CubePoint point2 = o2.getCubePoints().get(0);
            return CubePointComparator.Y.compare(point1, point2);
        }
    },
    FIRST_POINT_Z {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(0);
            CubePoint point2 = o2.getCubePoints().get(0);
            return CubePointComparator.Z.compare(point1, point2);
        }
    },
    SECOND_POINT_X {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(1);
            CubePoint point2 = o2.getCubePoints().get(1);
            return CubePointComparator.X.compare(point1, point2);
        }
    },
    SECOND_POINT_Y {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(1);
            CubePoint point2 = o2.getCubePoints().get(1);
            return CubePointComparator.Y.compare(point1, point2);
        }
    },
    SECOND_POINT_Z {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(1);
            CubePoint point2 = o2.getCubePoints().get(1);
            return CubePointComparator.Z.compare(point1, point2);
        }
    },
    THIRD_POINT_X {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(2);
            CubePoint point2 = o2.getCubePoints().get(2);
            return CubePointComparator.X.compare(point1, point2);
        }
    },
    THIRD_POINT_Y {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(2);
            CubePoint point2 = o2.getCubePoints().get(2);
            return CubePointComparator.Y.compare(point1, point2);
        }
    },
    THIRD_POINT_Z {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(2);
            CubePoint point2 = o2.getCubePoints().get(2);
            return CubePointComparator.Z.compare(point1, point2);
        }
    },
    FOURTH_POINT_X {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(3);
            CubePoint point2 = o2.getCubePoints().get(3);
            return CubePointComparator.X.compare(point1, point2);
        }
    },
    FOURTH_POINT_Y {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(3);
            CubePoint point2 = o2.getCubePoints().get(3);
            return CubePointComparator.Y.compare(point1, point2);
        }
    },
    FOURTH_POINT_Z {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(3);
            CubePoint point2 = o2.getCubePoints().get(3);
            return CubePointComparator.Z.compare(point1, point2);
        }
    },
    FIFTH_POINT_X {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(4);
            CubePoint point2 = o2.getCubePoints().get(4);
            return CubePointComparator.X.compare(point1, point2);
        }
    },
    FIFTH_POINT_Y {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(4);
            CubePoint point2 = o2.getCubePoints().get(4);
            return CubePointComparator.Y.compare(point1, point2);
        }
    },
    FIFTH_POINT_Z {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(4);
            CubePoint point2 = o2.getCubePoints().get(4);
            return CubePointComparator.Z.compare(point1, point2);
        }
    },
    SIX_POINT_X {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(5);
            CubePoint point2 = o2.getCubePoints().get(5);
            return CubePointComparator.X.compare(point1, point2);
        }
    },
    SIX_POINT_Y {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(5);
            CubePoint point2 = o2.getCubePoints().get(5);
            return CubePointComparator.Y.compare(point1, point2);
        }
    },
    SIX_POINT_Z {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(5);
            CubePoint point2 = o2.getCubePoints().get(5);
            return CubePointComparator.Z.compare(point1, point2);
        }
    },
    SEVEN_POINT_X {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(6);
            CubePoint point2 = o2.getCubePoints().get(6);
            return CubePointComparator.X.compare(point1, point2);
        }
    },
    SEVEN_POINT_Y {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(6);
            CubePoint point2 = o2.getCubePoints().get(6);
            return CubePointComparator.Y.compare(point1, point2);
        }
    },
    SEVEN_POINT_Z {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(6);
            CubePoint point2 = o2.getCubePoints().get(6);
            return CubePointComparator.Z.compare(point1, point2);
        }
    },
    EIGHT_POINT_X {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(7);
            CubePoint point2 = o2.getCubePoints().get(7);
            return CubePointComparator.X.compare(point1, point2);
        }
    },
    EIGHT_POINT_Y {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(7);
            CubePoint point2 = o2.getCubePoints().get(7);
            return CubePointComparator.Y.compare(point1, point2);
        }
    },
    EIGHT_POINT_Z {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubePoint point1 = o1.getCubePoints().get(7);
            CubePoint point2 = o2.getCubePoints().get(7);
            return CubePointComparator.Z.compare(point1, point2);
        }
    },
}
