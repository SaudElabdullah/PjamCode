package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static class gridColoring {

        int d;
        ArrayList<Integer> ri;
        ArrayList<Integer> ci;
        ArrayList<ArrayList<String>> matrix;

        gridColoring(int d, ArrayList<Integer> ri, ArrayList<Integer> ci, ArrayList<ArrayList<String>> matrix) {
            this.d = d;
            this.ri = ri;
            this.ci = ci;
            this.matrix = matrix;
        }

        int coloring(){

            for(int outerLoop = 0 ; outerLoop < d ; outerLoop++){
                for(int innerLoop = 0 ; innerLoop < d ; innerLoop++){
                    boolean AdjacentColumn = checkAdjacentColumn(outerLoop);
                    boolean AdjacentRow = checkAdjacentRow(innerLoop);
                    boolean isColorAble = isColorAble(outerLoop , innerLoop);

                    if (AdjacentColumn && AdjacentRow && isColorAble){
                        decrement(outerLoop , innerLoop);
                    }
                }
            }

            if(checkLoop(ri) && checkLoop(ci)){
                return 1;
            } else {
                return 0;
            }
        }
        boolean isColorAble(int y, int x) {
            String temp = matrix.get(y).get(x);
            return temp.equalsIgnoreCase("0");
        }

        boolean checkAdjacentColumn(int y) {
            int temp = ci.get(y);
            return temp != 0;
        }

        boolean checkAdjacentRow(int x) {
            int temp = ri.get(x);
            return temp != 0;
        }

        void decrement(int y, int x) {
            ci.set(y, ci.get(y) - 1);
            ri.set(x, ri.get(x) - 1);
        }

        boolean checkLoop(ArrayList<Integer> adjacent){
            for(int loop = 0 ; loop < d ; loop++){
                int temp = adjacent.get(loop);
                if(temp != 0){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d = sc.nextInt();
        ArrayList<Integer> ri = new ArrayList<>();
        for(int loop = 0 ; loop < d ; loop++){
            ri.add(sc.nextInt());
        }
        ArrayList<Integer> ci = new ArrayList<>();
        for(int loop = 0 ; loop < d ; loop++){
            ci.add(sc.nextInt());
        }

        ArrayList<ArrayList<String>> matrix = new ArrayList<>();
        for(int outerLoop = 0 ; outerLoop < d ; outerLoop++){
            ArrayList<String> row = new ArrayList<>();
            String input = sc.next();
            int[] array = input.chars().map(i->i-'0').toArray();
            for (int innerLoop = 0 ; innerLoop < d ; innerLoop++) {
                row.add(String.valueOf(array[innerLoop]));
            }
            matrix.add(row);
        }

        gridColoring coloring = new gridColoring(d , ri , ci , matrix);
        System.out.println(coloring.coloring());
    }
}
