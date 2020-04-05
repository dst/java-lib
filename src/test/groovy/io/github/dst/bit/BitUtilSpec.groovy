package io.github.dst.bit

import spock.lang.Specification
import spock.lang.Unroll

class BitUtilSpec extends Specification {

    def "bit manipulation"() {
        expect:
            1 << 0 == 1
            1 << 1 == 2
            1 << 2 == 4
            4 << 1 == 8

            1 >> 0 == 1
            1 >> 1 == 0
            1 >> 2 == 0
            4 >> 1 == 2
    }

    @Unroll
    def "bitmasks from 0..00 to 1..11 for #n == #bitmasks"() {
        expect:
            BitUtil.generateAllBitmasks(n) == bitmasks
            println BitUtil.subsets([1, 2, 3] as int[])
        where:
            n || bitmasks
            1 || ['0', '1']
            2 || ['00', '01', '10', '11']
    }
}
