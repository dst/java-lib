package io.github.dst.uf

import spock.lang.Specification
import spock.lang.Unroll

class UnionFindSpec extends Specification {

    @Unroll()
    def "#findUnionImp"() {
        expect:
            !unionFind.connected(0, 9)
        when:
            unionFind.union(0, 9)
        then:
            unionFind.connected(0, 9)
            !unionFind.connected(8, 9)
        when:
            unionFind.union(9, 4)
            unionFind.union(4, 3)
            unionFind.union(3, 8)
        then:
            unionFind.connected(8, 9)
        where:
            unionFind << [
                    new UnionFind(10),
                    new WeightedUnionFind(10),
                    new PathCompressionWeightedUnionFind(10)
            ]
            findUnionImp = unionFind.getClass().getSimpleName()
    }
}
