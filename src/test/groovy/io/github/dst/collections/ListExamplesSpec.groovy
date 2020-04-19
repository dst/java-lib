package io.github.dst.collections

import spock.lang.Specification

class ListExamplesSpec extends Specification {

    def "nCopies example"() {
        expect:
            ListExamples.nCopies()
    }
}
