import java.util.*;
public class Main {
    public static void main(String[] args) {
        // put your code here

        //My scanner
        Scanner sc = new Scanner(System.in);
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


        //System.out.printl
        //
        //
        // n("Give me a number");
        int numberfind = 0;
        if(sc.hasNextInt()){
            numberfind = sc.nextInt();
        }

        int sums = 0;
        for (int i = 0; i != a.length; i++) {
            if(a[i] == numberfind){
                sums = sums+1;
                //System.out.println(numberfind+" appears "+sums+" times");
                }
        }
        sc.close();
        System.out.println(sums);
    }
}