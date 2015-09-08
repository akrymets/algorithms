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

        UnionFind union1 = new QuickFind();
        System.out.print("     ");
        union1.showArray();
        union1.union(5, 4);
        System.out.print("5-4: ");
        union1.showArray();
        union1.union(9, 8);
        System.out.print("9-8: ");
        union1.showArray();
        union1.union(1, 5);
        System.out.print("1-5: ");
        union1.showArray();
        union1.union(7, 2);
        System.out.print("7-2: ");
        union1.showArray();
        union1.union(7, 8);
        System.out.print("7-8: ");
        union1.showArray();
        union1.union(4, 0);
        System.out.print("4-0: ");
        union1.showArray();

//        UnionFind union2 = new QuickUnionWeighted();
//        union2.showArray();
//        union2.union(3, 1);
//        union2.showArray();
//        union2.union(2, 8);
//        union2.showArray();
//        union2.union(7, 9);
//        union2.showArray();
//        union2.union(2, 4);
//        union2.showArray();
//        union2.union(1, 9);
//        union2.showArray();
//        union2.union(4, 0);
//        union2.showArray();
//        union2.union(6, 2);
//        union2.showArray();
//        union2.union(3, 6);
//        union2.showArray();
//        union2.union(1, 5);
//        union2.showArray();

    }

}
