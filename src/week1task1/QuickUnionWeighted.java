/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1task1;

/**
 *
 * @author User
 */
public class QuickUnionWeighted extends QuickUnion {

    int[] treeSize = new int[this.array.length];

    public QuickUnionWeighted() {
        super();
        for (int i = 0; i < this.treeSize.length; i++) {
            this.treeSize[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {

        int rootP = root(p);
        int rootQ = root(q);
        
        if (rootP == rootQ) return;
        
        if (treeSize[rootP] >= treeSize[rootQ]) {
            this.array[rootQ] = rootP;
            treeSize[rootP] += treeSize[rootQ];
        } else {
            this.array[rootP] = rootQ;
            treeSize[rootQ] += treeSize[rootP];
        }
        
    }

}
