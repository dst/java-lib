package io.github.dst.string

import spock.lang.Specification
import spock.lang.Unroll

class StringUtilSpec extends Specification {

    @Unroll
    def "reversed '#word' is '#reversed'"() {
        expect:
            StringUtil.reverse(word) == reversed
        where:
            word  || reversed
            ""    || ""
            "a"   || "a"
            "abc" || "cba"
            "aba" || "aba"
    }

    @Unroll
    def "sorted '#word' is '#sorted'"() {
        expect:
            StringUtil.sort(word) == sorted
        where:
            word  || sorted
            ""    || ""
            "a"   || "a"
            "abc" || "abc"
            "aba" || "aab"
    }

    @Unroll
    def "'#word' without suffix '#suffix' is '#result'"() {
        expect:
            StringUtil.removeSuffix(word, suffix) == result
        where:
            word | suffix || result
            ""   | ""     || ""
            "ab" | "b"    || "a"
            "ab" | "ab"   || ""
    }
}
