import java.util.*;
class Main {
    public static void main(String[] args) {
        // put your code here

        //size of the array
        Scanner sc = new Scanner(System.in);

        int numberfind, sums = 0;
//        //elements of the array
//        Scanner numb = new Scanner(System.in);
//        //the magic N number (we sum everything above that number)
//        Scanner largen = new Scanner(System.in);

        /*Given Array*/

        //System.out.println("Input the size of the array");
        int arrs = sc.nextInt();
        int a[] = new int[arrs];

        //Get input
        for (int i = 0; i != arrs; i++) {
            //System.out.println(i + ": Please, give me a number:");
            a[i] = sc.nextInt();

        }

        sc.close();

        for (int i = 0; i != a.length; i++) {
                sums = sums+a[i];
                //System.out.println(numberfind+" appears "+sums+" times");
        }
        sc.close();
        System.out.println(sums);
    }
}