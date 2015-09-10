/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1task1;

import java.io.IOException;

/**
 *
 * @author Andrey
 */
public class Demo {

    public static void main(String[] args) throws IOException {

        System.out.println("Task 1:");
        UnionFind union1 = new QuickFind();
        //union1.applyUnionsFromFile("unions.txt");
        union1.applyUnionsFromString("0-3 4-1 2-6 7-6 2-0 6-9");

        System.out.println("\n\rTask 2");
        UnionFind union2 = new QuickUnionWeighted();
        union2.applyUnionsFromString("7-8 9-4 9-6 5-1 2-4 0-6 8-5 1-6 8-3");
        
        System.out.println("\n\rTask 3");
        Forest f = new Forest();
        System.out.println("Forest 1");
        f.showForest("6 6 7 7 7 0 7 7 7 7");
        System.out.println("Forest 2");
        f.showForest("6 2 8 8 8 5 1 8 8 2");
        System.out.println("Forest 3");
        f.showForest("6 4 5 5 5 5 4 6 3 2");
        System.out.println("Forest 4");
        f.showForest("2 0 6 0 5 0 5 0 0 0");
        System.out.println("Forest 5");
        f.showForest("0 8 2 3 4 5 8 8 8 9");

    }

}
