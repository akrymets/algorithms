/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1task1;

/**
 *
 * @author Andrey
 */
public class QuickUnion extends UnionFind {

    public QuickUnion() {
        super();
    }

    protected int root(int p) {
        int i = p;

        while (i != this.array[i]) {
            i = this.array[i];
        }
        return i;
    }

    @Override
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        this.array[rootP] = rootQ;
    }

    @Override
    public boolean find(int p, int q) {
        return root(p) == root(q);
    }

}
