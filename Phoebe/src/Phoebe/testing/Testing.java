package Phoebe.testing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Testing {

    public static void main (String [] args) throws java.io.IOException {

        String sourceText = "";
        String testResult = "";
        String y = "", z = "";
        int line=1;

        System.out.println("Enter the first file's place:");
        Scanner scanIn = new Scanner(System.in);
        String s1 = scanIn.nextLine();

        System.out.println("Enter the second file's place:");
        scanIn = new Scanner(System.in);
        String s2 = scanIn.nextLine();

        BufferedReader bfr = new BufferedReader(new FileReader(s1));
        BufferedReader bfr1 = new BufferedReader(new FileReader(s2));


        while ( ( (z = bfr1.readLine()) != null) &&  ( (y = bfr.readLine()) != null) )
        {

            if( ( z.charAt(0) - (int)'9')<=0 )
                z=z.substring(z.indexOf(" "));
            testResult += z;

            if( ( y.charAt(0) - (int)'9')<=0 )
                y=y.substring(y.indexOf(" "));
            sourceText += y;


            if(y.equals(z)==false) {
                System.out.println("\tThe files are not the same. Difference at line " + line + ":");

                System.out.println("\tin the first file: "+z);
                System.out.println("\tin the second file: "+y);

            }
            line++;
        }
        if ( ( (z = bfr1.readLine()) != null)  &&  ( (y = bfr.readLine()) == null) || ( ( (z = bfr1.readLine()) == null) &&  ( (y = bfr.readLine()) != null)  ) )
            System.out.println("- The files are not the same. The length differs!" );
        else if (testResult.equals(sourceText))
        {
            System.out.println("- The files are the same" );
        }

        sourceText="";
        testResult="";

        line=1;
        bfr.close();
        bfr1.close();
    }
}






