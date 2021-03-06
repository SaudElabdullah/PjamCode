import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {
        // if number of test cases is required.

        // int numberOfLines = in.nextInt();
        // // don't forgat to use readLine if you need it
        // // readLine();
        // for (int i = 0; i < numberOfLines; i++) {
        // //write your code here
        // }

        in.close();
    }

    // Chlorine Compounds
    static public void q1() {
        double px = (double) Math.round(readInt()) / 100;
        double py = (double) Math.round(readInt()) / 100;
        double pz = (double) Math.round(readInt()) / 100;
        double L = (double) Math.round(readDouble());

        double sx = (L * pz - L * py) / (px - py);
        double sy = L - sx;

        int[] x = { (int) sx, (int) sy };
        // print(x, " ");
        print((int) sx);
        print(" ");
        print((int) sy);

    }

    // Calorie Conscious
    static public void q2() {

        HashMap<String, Integer> SIZE_INDEX = new HashMap<String, Integer>(3);
        SIZE_INDEX.put("Small", 0);
        SIZE_INDEX.put("Medium", 1);
        SIZE_INDEX.put("Large", 2);

        int[] calBySize = { 270, 350, 450 };
        HashMap<String, int[]> DATA = new HashMap<String, int[]>(13);

        DATA.put("Haloumi", new int[] { 120, 135, 150 });
        DATA.put("Greenolive", new int[] { 45, 48, 52 });
        DATA.put("Chicken", new int[] { 95, 110, 125 });
        DATA.put("Beef", new int[] { 110, 125, 140 });
        DATA.put("Onion", new int[] { 15, 28, 45 });
        DATA.put("Pepper", new int[] { 35, 45, 66 });
        DATA.put("Pineapple", new int[] { 28, 35, 42 });
        DATA.put("Tomato", new int[] { 36, 52, 75 });
        DATA.put("Garlic", new int[] { 18, 22, 26 });
        DATA.put("Feta", new int[] { 125, 145, 165 });
        DATA.put("Jalapeno", new int[] { 16, 20, 24 });
        DATA.put("Mushroom", new int[] { 28, 33, 38 });
        DATA.put("Sausage", new int[] { 95, 115, 128 });

        try {
            int n = readInt();

            int sum = 0;
            for (int i = 0; i < n; i++) {
                int count = readInt();
                String size = readString();

                String listString = readLine();

                String[] ls = listString.trim().split(",");
                int cal = 0;
                int sizeIndex = SIZE_INDEX.get(size);
                for (String elm : ls) {

                    cal += DATA.get(elm)[sizeIndex];
                }
                sum += (calBySize[sizeIndex] + cal) * count;
            }
            println(sum);
        } catch (Exception e) {
            println(0);
        }

    }

    // Teaching Mathematics and English
    static void q5() {
        Scanner in = new Scanner(System.in);
        String input = readLine();
        if (input.isEmpty())
            System.out.println(0);
        in.close();

        char[] charList = input.toCharArray();

        Arrays.toString(charList);

        System.out.println(q3Count(charList, 0));
    }

    static int q3Count(char[] arr, int index) {

        int max = 1;
        if (arr.length <= index + 1)
            return 1;

        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] > arr[index]) {

                max = Math.max(max, q3Count(arr, i) + 1);
            }
        }
        return max;
    }

    // Iron Welding Rods
    static void q4() {
        int count = in.nextInt();
        int[] rods = readInt(count);
        List<Integer> intList = new ArrayList<Integer>(rods.length);
        for (int i : rods) {
            intList.add(i);
        }
        ;
        Collections.sort(intList);
        int cost = 0;
        while (intList.size() != 1) {
            intList.set(0, intList.get(0) + intList.get(1));
            intList.remove(1);
            cost += intList.get(0);
            Collections.sort(intList);

        }
        print(cost);
    }

    /*
     * ****************** * HELP METHODS * ****************** *
     */

    static Scanner in = new Scanner(System.in);

    /*
     * 
     * read methods *
     * 
     */

    public static int readInt() {
        int x = in.nextInt();

        return x;
    }

    public static double readDouble() {
        double x = in.nextDouble();

        return x;
    }

    public static String readString() {
        String x = in.next();

        return x;
    }

    public static String readLine() {
        String x = in.nextLine();
        return x;
    }

    // read array[]

    public static int[] readInt(int size) {

        int[] x = new int[size];

        for (int i = 0; i < x.length; i++) {
            x[i] = readInt();
        }
        return x;
    }

    public static double[] readDouble(int size) {
        double[] x = new double[size];

        for (int i = 0; i < x.length; i++) {
            x[i] = readDouble();
        }
        return x;
    }

    public static String[] readString(int size) {
        String[] x = new String[size];

        for (int i = 0; i < x.length; i++) {
            x[i] = readString();
        }
        return x;
    }

    public static String[] readLine(int numberOfLines) {
        String[] x = new String[numberOfLines];

        for (int i = 0; i < x.length; i++) {
            x[i] = readLine();
        }
        return x;
    }

    // read 2d array[]

    public static int[][] readInt(int rows, int columns) {

        int[][] x = new int[rows][columns];

        for (int i = 0; i < x.length; i++) {
            x[i] = readInt(columns);
        }
        return x;
    }

    public static double[][] readDouble(int rows, int columns) {
        double[][] x = new double[rows][columns];

        for (int i = 0; i < x.length; i++) {
            x[i] = readDouble(columns);
        }
        return x;
    }

    public static String[][] readString(int rows, int columns) {
        String[][] x = new String[rows][columns];

        for (int i = 0; i < x.length; i++) {
            x[i] = readString(columns);
        }
        return x;
    }

    /*
     * 
     * print methods *
     * 
     */

    public static void println(Object obj) {

        System.out.println(obj);
    }

    public static void println(int elm) {
        System.out.println(elm);

    }

    public static void println(short elm) {
        System.out.println(elm);

    }

    public static void println(long elm) {
        System.out.println(elm);

    }

    public static void println(double elm) {
        System.out.println(elm);

    }

    public static void println(float elm) {
        System.out.println(elm);

    }

    public static void println(char elm) {
        System.out.println(elm);

    }

    public static void println(byte elm) {
        System.out.println(elm);

    }

    public static void println(boolean elm) {

        System.out.println(elm);

    }

    public static void print(String elm) {
        System.out.print(elm);

    }

    public static void print(int elm) {
        System.out.print(elm);

    }

    public static void print(short elm) {
        System.out.print(elm);

    }

    public static void print(long elm) {
        System.out.print(elm);

    }

    public static void print(double elm) {
        System.out.print(elm);

    }

    public static void print(float elm) {
        System.out.print(elm);

    }

    public static void print(char elm) {
        System.out.print(elm);

    }

    public static void print(byte elm) {
        System.out.print(elm);

    }

    public static void print(boolean elm) {

        System.out.print(elm);

    }

    // Arrays

    public static void print(Object[] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1)
                System.out.print(separator);
        }

    }

    public static void print(int[] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1)

                System.out.print(separator);
        }

    }

    public static void print(double[] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i]);
            if (i != arr.length - 1)

                System.out.print(separator);
        }

    }

    public static void print(char[] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i]);
            if (i != arr.length - 1)

                System.out.print(separator);
        }

    }

    public static void print(byte[] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i]);
            if (i != arr.length - 1)

                System.out.print(separator);
        }

    }

    public static void print(boolean[] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1)

                System.out.print(separator);

        }

    }

    // matrix

    public static void print(Object[][] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {
            print(arr[i], separator);
            println("");

        }

    }

    public static void print(int[][] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {
            print(arr[i], separator);
            println("");

        }

    }

    public static void print(double[][] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {
            print(arr[i], separator);
            println("");

        }

    }

    public static void print(char[][] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {
            print(arr[i], separator);
            println("");

        }

    }

    public static void print(byte[][] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {
            print(arr[i], separator);
            println("");

        }
    }

    public static void print(boolean[][] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {
            print(arr[i], separator);
            println("");

        }

    }

}
