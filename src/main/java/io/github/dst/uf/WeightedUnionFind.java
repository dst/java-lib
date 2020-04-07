package io.github.dst.uf;

public class WeightedUnionFind {
    private int[] parents;
    /** Number of objects in the tree rooted at i */
    private int[] weights;

    public WeightedUnionFind(int n) {
        parents = new int[ n];
        weights = new int[ n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            weights[i] = 1;
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot == qRoot) {
            return;
        }
        if (weights[pRoot] <= weights[qRoot]) {
            parents[pRoot] = qRoot;
            weights[qRoot] += weights[pRoot];
        } else {
            parents[qRoot] = pRoot;
            weights[pRoot] += weights[qRoot];
        }
    }

    private int root(int p) {
        while (p != parents[p]) {
            p = parents[p];
        }
        return p;
    }
}