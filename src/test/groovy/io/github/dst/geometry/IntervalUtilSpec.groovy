package io.github.dst.geometry

import io.github.dst.algorithms.LongestConsecutiveSubsequence
import spock.lang.Specification
import spock.lang.Unroll

class IntervalUtilSpec extends Specification {

    @Unroll
    def "#a and #b has overlap? = #overlapped"() {
        expect:
            new IntervalUtil().hasOverlap(a as int[], b as int[]) == overlapped
        where:
            a      | b      || overlapped
            [1, 2] | [3, 4] || false
            [3, 4] | [1, 2] || false
            [1, 4] | [2, 3] || true
            [2, 3] | [1, 4] || true
            [1, 5] | [2, 7] || true
            [1, 5] | [0, 3] || true
            [1, 2] | [2, 5] || true
    }
}
