/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

/**
 *
 * @author franc
 */
public class Exercise1main {
    
     public static void main(String[] args) {
        Exercise1 exercise = new Exercise1();
        int[] intArray = new int[]{4,7,1,6,3};
        int ans = exercise.solution(intArray);
        System.out.println(ans);
    }
}
