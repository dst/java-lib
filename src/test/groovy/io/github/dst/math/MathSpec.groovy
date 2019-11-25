package io.github.dst.math

import spock.lang.Specification

class MathSpec extends Specification {

    def "signum"() {
        expect:
            Math.signum(-3.2) == -1.0
            Math.signum(0.2) == 1.0
            Math.signum(0.0) == 0.0

            Integer.signum(-3) == -1
            Integer.signum(1) == 1
            Integer.signum(0) == 0
    }
}
