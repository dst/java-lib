package io.github.dst.uf;

public class UnionFind {
    private int[] parents;

    public UnionFind(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        parents[pRoot] = qRoot;
    }

    private int root(int p) {
        while (p != parents[p]) {
            p = parents[p];
        }
        return p;
    }
}