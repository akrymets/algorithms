/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void applyUnionsFromFile(String fileName) throws IOException {

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String pair = reader.readLine();
            while (pair != null) {
                String[] pAndQ = pair.split("-");
                int p = Integer.parseInt(pAndQ[0]);
                int q = Integer.parseInt(pAndQ[1]);
                union(p, q);
                System.out.print(p + "-" + q + ": ");
                showArray();
                pair = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UnionFind.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

    }

    public void applyUnionsFromString(String s) {

        String[] pairs = s.split(" ");

        for (int i = 0; i < pairs.length; i++) {
            String[] pair = pairs[i].split("-");
            int p = Integer.parseInt(pair[0]);
            int q = Integer.parseInt(pair[1]);
            union(p, q);
            System.out.print(p + "-" + q + ": ");
            showArray();

        }

    }
}
