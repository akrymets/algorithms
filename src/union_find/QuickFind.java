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
public class QuickFind extends UnionFind{

    public QuickFind() {
        super();
    }

    @Override
    public void union(int p, int q) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == this.array[p]) {
                this.array[i] = this.array[q];
            }
        }
    }

    @Override
    public boolean find(int p, int q) {
        return this.array[p] == this.array[q];
    }

}
