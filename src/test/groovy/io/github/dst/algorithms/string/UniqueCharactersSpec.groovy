package io.github.dst.algorithms.string

import spock.lang.Specification
import spock.lang.Unroll

class UniqueCharactersSpec extends Specification {

    @Unroll
    def "'#word' #uniqDescription unique characters"() {
        expect:
            UniqueCharacters.check(word) == isUnique
        where:
            word                                || isUnique
            ""                                  || true
            "a"                                 || true
            "abc"                               || true
            "aba"                               || false
            "~`!@#%^&*()_+=-1234567890<>,.;':"  || true
            "~`!@#%^&*()_+=-1234567890<>,.;':~" || false

            uniqDescription = isUnique ? 'has' : 'has not'
    }
}
