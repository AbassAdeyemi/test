/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.util.Arrays;


/**
 *
 * @author franc
 */
public class Exercise1 {
    
    public int solution(int[] A) {
        int b = 0;
        while (has(A, ++b)) ;
        return b;
    }
    public static boolean has(int[] arr, int item) {
        for (int n : arr) {
            if (item == n) {
                return true;
            }
        }
        return false;
    }
    
}
