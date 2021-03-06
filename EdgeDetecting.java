package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static class Detecting {

        int n;
        int m;
        ArrayList<ArrayList<Integer>> matrix;

        Detecting(int n , int m , ArrayList<ArrayList<Integer>> matrix){
            this.n = n;
            this.m = m;
            this.matrix = matrix;
        }

        ArrayList<Integer> calcEdges(){
            ArrayList<Integer> edges = new ArrayList<>();
            int numberOfHorizontalEdges = 0;
            int numberOfVerticalEdges = 0;
            int numberOfDiagonalEdges = 0;

            //for rows
            for(int loop = 0 ; loop < n ; loop++){
                numberOfHorizontalEdges = numberOfHorizontalEdges + horizontalCount(loop);
            }
            edges.add(numberOfHorizontalEdges);
//        for columns
            for(int loop = 0 ; loop < m ; loop++){
                numberOfVerticalEdges = numberOfVerticalEdges + verticalCount(loop);
            }
            edges.add(numberOfVerticalEdges);
            //for right to left diagonal
            for(int loop = 0 ; loop < m ; loop++){
                numberOfDiagonalEdges = numberOfDiagonalEdges + rightToLeftDiagonalCount(0,loop);
                numberOfDiagonalEdges = numberOfDiagonalEdges + rightToLeftDiagonalCount(loop,0);
            }
            //for left to right diagonal
            for(int loop = 0 ; loop < m ; loop++){
                numberOfDiagonalEdges = numberOfDiagonalEdges + leftToRightDiagonalCount(0,loop);
                numberOfDiagonalEdges = numberOfDiagonalEdges + leftToRightDiagonalCount(loop,m-1);
            }
            edges.add(numberOfDiagonalEdges);
            return edges;
        }

        int horizontalCount(int x){
            int count = 0;
            for(int outerLoop = 0 ; outerLoop < m ; outerLoop++){
                if(matrix.get(x).get(outerLoop) == 1){
                    boolean moreThanTwo = false;
                    for(int innerLoop = outerLoop ; innerLoop < m ; innerLoop++){
                        if(innerLoop + 1 < m && matrix.get(x).get(innerLoop + 1) == 1){
                            moreThanTwo = true;
                        } else {
                            outerLoop = innerLoop;
                            break;
                        }
                    }
                    if(moreThanTwo){
                        count = count + 1;
                    }
                }
            }
            return count;
        }

        int verticalCount(int y){
            int count = 0;
            for(int outerLoop = 0 ; outerLoop < n ; outerLoop++){
                if(matrix.get(outerLoop).get(y) == 1){
                    boolean moreThanTwo = false;
                    for(int innerLoop = outerLoop ; innerLoop < n ; innerLoop++){
                        if(innerLoop + 1 < n && matrix.get(innerLoop + 1).get(y) == 1){
                            moreThanTwo = true;
                        } else {
                            outerLoop = innerLoop;
                            break;
                        }
                    }
                    if(moreThanTwo){
                        count = count + 1;
                    }
                }
            }
            return count;
        }

        int rightToLeftDiagonalCount(int x, int y){
            int count = 0;
            int numOfMoves = clacMovesForDiagonal(x , y);
            for(int outerLoop = 0 ; outerLoop < numOfMoves ; outerLoop++){
                if(matrix.get(x).get(y) == 1){
                    boolean moreThanTwo = false;
                    for(int innerLoop = outerLoop ; innerLoop < numOfMoves ; innerLoop++){
                        if(innerLoop + 1 < numOfMoves && matrix.get(x + 1).get(x + 1) == 1){
                            moreThanTwo = true;
                        } else {
                            outerLoop = innerLoop;
                            break;
                        }
                        x = x + 1;
                        y = y + 1;
                    }
                    if(moreThanTwo){
                        count = count + 1;
                    }
                }
            }
            System.out.println(count);
            return count;
        }

        int leftToRightDiagonalCount(int x, int y){
            int count = 0;
            int numOfMoves = clacMovesForDiagonal(x , y);
            for(int outerLoop = 0 ; outerLoop < numOfMoves ; outerLoop++){
                if(matrix.get(x).get(y) == 1){
                    boolean moreThanTwo = false;
                    for(int innerLoop = outerLoop ; innerLoop < numOfMoves ; innerLoop++){
                        if(innerLoop + 1 < numOfMoves && matrix.get(x - 1).get(x - 1) == 1){
                            moreThanTwo = true;
                        } else {
                            outerLoop = innerLoop;
                            break;
                        }
                        x = x - 1;
                        y = y - 1;
                    }
                    if(moreThanTwo){
                        count = count + 1;
                    }
                }
            }
            return count;
        }

        int clacMovesForDiagonal(int x , int y){
            if(x > y){
                return n - x;
            } else if(y > x){
                return m - y;
            } else {
                return Math.max(m , n);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for(int outerLoop = 0 ; outerLoop < n ; outerLoop++){
            ArrayList<Integer> row = new ArrayList<>();
            String line = sc.next();
            String[] lineVector = line.split(",");
            for (int innerLoop = 0 ; innerLoop < m ; innerLoop++) {
                row.add(Integer.parseInt(lineVector[innerLoop]));
            }
            matrix.add(row);
        }
        Detecting detecting = new Detecting(n , m ,matrix);
        System.out.println(detecting.calcEdges());
    }
}
