package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static class SolutionValidation {

        ArrayList<ArrayList<Integer>> matrix;

        SolutionValidation(ArrayList<ArrayList<Integer>> matrix){
            this.matrix = matrix;
        }

        int validate(){
            ArrayList<ArrayList<Integer>> rows = getMatrixRow();
            ArrayList<ArrayList<Integer>>  columns = getMatrixColumn();

            for(int loop = 0 ; loop < 9 ; loop++){
                boolean checkAnswer = check(rows.get(loop) , columns);
                if(!checkAnswer){
                    return 0;
                }
            }

            return 1;
        }

        ArrayList<ArrayList<Integer>> getMatrixRow (){
            return matrix;
        }

        ArrayList<ArrayList<Integer>> getMatrixColumn (){
            ArrayList<ArrayList<Integer>> columns = new ArrayList<>();

            for(int outerLoop = 0 ; outerLoop < matrix.size() ; outerLoop++){
                ArrayList<Integer> column = new ArrayList<>();
                for(int innerLoop = 0 ; innerLoop < matrix.get(0).size() ; innerLoop++){
                    column.add(matrix.get(innerLoop).get(outerLoop));
                }
                columns.add(column);
            }
            return columns;
        }

        boolean check(ArrayList<Integer> row , ArrayList<ArrayList<Integer>>  columns){

            for(int outerLoop = 0 ; outerLoop < matrix.size() ; outerLoop++){
                int rowValue = row.get(outerLoop);
                boolean encounterItself = false;
                for(int innerLoop = 0 ; innerLoop < matrix.get(0).size() ; innerLoop++){
                    if(rowValue == columns.get(outerLoop).get(innerLoop)){
                        if(encounterItself){
                            return false;
                        }
                        encounterItself = true;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        for(int outerLoop = 0 ; outerLoop < 9 ; outerLoop++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int innerLoop = 0 ; innerLoop < 9 ; innerLoop++){
                row.add(sc.nextInt());
            }
            matrix.add(row);
        }

        SolutionValidation solutionValidation = new SolutionValidation(matrix);
        System.out.println(solutionValidation.validate());
    }
}
