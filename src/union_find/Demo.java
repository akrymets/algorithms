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
        
        QuickFind qf = new QuickFind();
        qf.showArray();
        qf.union(5, 4);
        qf.union(9, 8);
        qf.union(1, 5);
        qf.union(7, 2);
        qf.union(7, 8);
        qf.union(4, 0);
        qf.showArray();
        
        
    }
    
}
