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
public class Demo {

    public static void main(String[] args) {

        UnionFind union1 = new QuickUnion();
        union1.union(5, 4);
        union1.union(9, 8);
        union1.union(1, 5);
        union1.union(7, 2);
        union1.union(7, 8);
        union1.union(4, 0);
        union1.showArray();

        UnionFind union2 = new QuickFind();
        union2.union(5, 4);
        union2.union(9, 8);
        union2.union(1, 5);
        union2.union(7, 2);
        union2.union(7, 8);
        union2.union(4, 0);
        union2.showArray();

    }

}
