/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package union_find;

/**
 *
 * @author Andrey
 */
public class QuickUnion extends UnionFind{

    public QuickUnion() {
        super();
    }

    private int root(int p) {
        
        int idx = p;
        
        for (int i = 0; i < this.array.length; i++) {
        
            if (idx == this.array[idx]) {
                return p;
            } else {
                idx = this.array[p];
            }
        }
        return 0;
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
