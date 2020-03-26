package io.github.dst.math

import spock.lang.Specification

class MathUtilSpec extends Specification {

    def "min"() {
        expect:
            MathUtil.min(2, -3, -1) == -3
    }
}
