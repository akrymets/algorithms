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
public abstract class UnionFind {

    int[] array = new int[10];

    public UnionFind() {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    abstract void union(int p, int q);

    abstract boolean find(int p, int q);

    public void showArray() {
        for (int i = 0; i < this.array.length; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }
}
