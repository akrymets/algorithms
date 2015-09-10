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
public class QuickFind extends UnionFind {

    public QuickFind() {
        super();
    }

    @Override
    public void union(int p, int q) {
        int PValue = this.array[p];
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == PValue) {
                this.array[i] = this.array[q];
            }
        }
    }

    @Override
    public boolean find(int p, int q) {
        return this.array[p] == this.array[q];
    }

}
