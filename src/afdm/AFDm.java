/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afdm;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author chofo2003
 */
public class AFDm {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String a = "5,7-6,5 6,5-7,6 7,6-5,7";
        String c = "5,7-6,5 6,5-7,6 7,6-57";
        int q = (a.indexOf("6,5-"));
        String b = a.substring(q+4, q+7);
        System.out.println(a);
        //System.out.println(q);
        //System.out.println(b);
        System.out.println(a.contains("5,7-"));
        System.out.println(a.equals(c));
    }
}