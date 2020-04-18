package io.github.dst.collections

import spock.lang.Specification

class SortingExamplesSpec extends Specification {

    def "multi key sorting example"() {
        expect:
            new SortingExamples().multiKeySorting()
    }
}
