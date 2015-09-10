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

        UnionFind union1 = new QuickFind();
        //union1.applyUnionsFromFile("unions.txt");
        //union1.applyUnionsFromString("5-4 9-8 1-5 7-2 7-8 4-0");

        UnionFind union2 = new QuickUnionWeighted();
        union2.applyUnionsFromString("4-3 0-2 1-9 6-7 2-1 8-6 4-6 9-6 1-5");

    }

}
