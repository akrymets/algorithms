/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1task1;

/**
 *
 * @author User
 */
public class Forest {

    public void showForest(String resultingArray) {

        StringBuilder sb = null;

        String[] sRoots = resultingArray.split(" ");
        int[] roots = new int[sRoots.length];

        for (int i = 0; i < roots.length; i++) {
            roots[i] = Integer.parseInt(sRoots[i]);
        }

        for (int i = 0; i < roots.length; i++) {

            sb = new StringBuilder();

            if (roots[i] == i) {    // search of base roots
                System.out.print(i + ": ");
                sb.append("(");
                for (int j = 0; j < roots.length; j++) {
                    if (roots[j] == i && j != i) {
                        sb.append(j).append(", ");
                    }
                }
                sb.append(")");
                System.out.println(sb.toString());
            }
            

        }

    }

}
