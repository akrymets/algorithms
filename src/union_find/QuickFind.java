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
public class QuickFind {

    int[] array = new int[10];

    public QuickFind() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = i;
        }
    }

    public void union(int p, int q) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == p) {
                this.array[i] = q;
            }
        }
    }

    public boolean find(int p, int q) {
        return this.array[p] == this.array[q];
    }

    public void showArray() {
        for (int i = 0; i < this.array.length; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }
}
