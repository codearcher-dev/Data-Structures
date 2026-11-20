package Generics;

import java.util.Arrays;

public class Conversion <T> {

    public Conversion(){}

    public void printToString(T[][] array){
        for(T[] arr :  array){
            System.out.println(Arrays.toString(arr));
        }
    }
    public void printToString(boolean[][] array){
        for(boolean[] arr :  array){
            System.out.println(Arrays.toString(arr));
        }
    }

    public void printToString(int[][] array) {
        for(int[] arr : array){
            System.out.println(Arrays.toString(arr));
        }
    }
}
