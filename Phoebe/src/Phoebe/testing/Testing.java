package Phoebe.testing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Testing {

    public static void main (String [] args) throws java.io.IOException {

        String sourceText = "";
        String testResult = "";
        String y = "", z = "";
        int line = 1;

        String path = "results/result.txt";


        //System.out.println("Enter the first file's place:");
        //Scanner scanIn = new Scanner(System.in);
       // String s1 = scanIn.nextLine();

        System.out.println("Enter the file's name you want to compare:");
        Scanner scanIn = new Scanner(System.in);
        String s2 = scanIn.nextLine();
        String s2Path = "expectedresults/"+s2+".txt";

        try {
            BufferedReader bfr = new BufferedReader(new FileReader(path));
            BufferedReader bfr1 = new BufferedReader(new FileReader(s2Path));

            while (((z = bfr1.readLine()) != null) && ((y = bfr.readLine()) != null)) {

                if ((z.charAt(0) - (int) '9') <= 0)
                    z = z.substring(z.indexOf(" "));
                testResult += z;

                if ((y.charAt(0) - (int) '9') <= 0)
                    y = y.substring(y.indexOf(" "));
                sourceText += y;


                if (y.equals(z) == false) {
                    System.out.println("\tThe files are not the same. Difference at line " + line + ":");

                    System.out.println("\tin the first file: " + z);
                    System.out.println("\tin the second file: " + y);

                }
                line++;
            }
            if (((z = bfr1.readLine()) != null) && ((y = bfr.readLine()) == null) || (((z = bfr1.readLine()) == null) && ((y = bfr.readLine()) != null)))
                System.out.println("- The files are not the same. The length differs!");
            else if (testResult.equals(sourceText)) {
                System.out.println("- The files are the same");
            }

            sourceText = "";
            testResult = "";

            line = 1;
            bfr.close();
            bfr1.close();
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            System.out.println("File cannot found");
        }
    }
}






