package io.github.dst.collections

import spock.lang.Specification

class MapExamplesSpec extends Specification {

    def "merge example"() {
        expect:
            new MapExamples().merge()
    }

    def "removeIf example"() {
        expect:
            new MapExamples().removeIf()
    }
}
