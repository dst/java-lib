package io.github.dst.string

import spock.lang.Specification
import spock.lang.Unroll

class StringUtilSpec extends Specification {

    @Unroll
    def "reversed '#word' is '#reversed'"() {
        expect:
            StringUtil.reverse(word) == reversed
        where:
            word                                || reversed
            ""                                  || ""
            "a"                                 || "a"
            "abc"                               || "cba"
            "aba"                               || "aba"
    }
}
