package io.github.dst.collections

import spock.lang.Specification

class ComparingExamplesSpec extends Specification {

    def "multi key sorting example"() {
        expect:
            new ComparingExamples().multiKeySorting()
    }
}
