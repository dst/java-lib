package io.github.dst.bit

import spock.lang.Specification

class BitSpec extends Specification {

    def "bit manipulation"() {
        expect:
            1 << 0 == 1
            1 << 1 == 2
            1 << 2 == 4

            1 >> 0 == 1
            1 >> 1 == 0
            1 >> 2 == 0
    }
}
