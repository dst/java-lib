package io.github.dst.pattern

import spock.lang.Specification
import spock.lang.Unroll

import static io.github.dst.pattern.IpPatterns.IP_V4_PATTERN

class IpPatternsSpec extends Specification {

    @Unroll
    def "#input should #matchingDescription IP v4 pattern"() {
        expect:
            IP_V4_PATTERN.matcher(input).matches() == matches
        where:
            input             || matches
            "127.0.0.1"       || true
            "192.168.1.1"     || true
            "192.168.1.255"   || true
            "255.255.255.255" || true
            "0.0.0.0"         || true
            "1.1.1.01"        || true
            "30.168.1.255. 1" || false
            "127.1"           || false
            "192.168.1.256"   || false
            "-1.2."           || false
            "3.4"             || false
            "3 ... 3"         || false

            matchingDescription = matches ? 'match' : 'not match'
    }
}
