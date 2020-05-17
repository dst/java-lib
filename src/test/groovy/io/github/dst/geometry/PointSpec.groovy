package io.github.dst.geometry

import spock.lang.Specification
import spock.lang.Unroll

class PointSpec extends Specification {

    @Unroll
    def "distance between #point1 and #point2 is #distance"() {
        expect:
            point1.distanceTo(point2) == distance
        where:
            point1            | point2           || distance
            new Point(0, 0)   | new Point(0, 1)  || 1
            new Point(0, 0)   | new Point(1, 1)  || Math.sqrt(2)
            new Point(-1, -1) | new Point(-1, 1) || 2
    }

    @Unroll
    def "center of #point1 and #point2 is #center"() {
        expect:
            point1.center(point2) == center
        where:
            point1            | point2           || center
            new Point(0, 0)   | new Point(0, 1)  || new Point(0, 0.5)
            new Point(0, 0)   | new Point(1, 1)  || new Point(0.5, 0.5)
            new Point(-1, -1) | new Point(-1, 1) || new Point(-1, 0)
    }
}
