/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3tasks;

/**
 *
 * @author User
 */
public class Test {

    public static void main(String[] args) {
        
        String s = null;
        
        assert isNotNull(s);
        
        
    }

    private static boolean isNotNull(String s) {
        return s != null;
    }
    
}
