package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(sc.nextInt());
        arrayList.add(sc.nextInt());
        arrayList.add(sc.nextInt());
        arrayList.add(sc.nextInt());
        arrayList.add(sc.nextInt());

        System.out.println("Minimum number of multiplications is "
                + chainOrder(arrayList, arrayList.size()));
    }

    static int chainOrder(ArrayList<Integer> p, int n)
    {
        int m[][] = new int[n][n];

        int i, j, k, L, q;
        for (i = 1; i < n; i++)
            m[i][i] = 0;
        for (L = 2; L < n; L++) {
            for (i = 1; i < n - L + 1; i++) {
                j = i + L - 1;
                if (j == n)
                    continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++) {
                    q = m[i][k] + m[k + 1][j] + p.get(i - 1) * p.get(k) * p.get(j);
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n - 1];
    }
}
