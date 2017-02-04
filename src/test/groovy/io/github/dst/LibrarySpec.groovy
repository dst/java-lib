package io.github.dst

import spock.lang.Specification

class LibrarySpec extends Specification {

    def 'should some library method work'() {
        given:
            Library classUnderTest = new Library()
        expect:
            classUnderTest.someLibraryMethod()
    }
}
