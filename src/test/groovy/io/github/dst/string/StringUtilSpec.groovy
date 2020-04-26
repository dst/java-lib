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
    def "'#word' has #digits digits"() {
        expect:
            StringUtil.countDigits(word) == digits
        where:
            word  || digits
            ""    || 0
            "a"   || 0
            "1"   || 1
            "a1"  || 1
            "9a1" || 2
    }

    @Unroll
    def "'#word' has #count '#c' chars"() {
        expect:
            StringUtil.countChar(word, c as char) == count
        where:
            word   | c   | count
            ""     | 'a' | 0
            "a"    | 'a' | 1
            "a1"   | '1' | 1
            "9a1a" | 'a' | 2
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

    @Unroll
    def "'#word' without prefix '#prefix' is '#result'"() {
        expect:
            StringUtil.removePrefix(word, prefix) == result
        where:
            word | prefix || result
            ""   | ""     || ""
            "ab" | "a"    || "b"
            "ab" | "ab"   || ""
    }
}
