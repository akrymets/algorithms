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
public class QuickUnion {

    int[] array = new int[10];

    public QuickUnion() {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    void union(int p, int q) {
    }

}
