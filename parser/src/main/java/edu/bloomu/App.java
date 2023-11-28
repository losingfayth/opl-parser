package edu.bloomu;

import java.util.Scanner;

/**
 * Driver for testing Parser class
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        /*
         * PASSERS
         */
        String s00 = "{n}";
        String s01 = "{n,n}";
        String s02 = "{n,n,n}";
        String s03 = "{{n}}";
        String s04 = "{{n},n}";
        String s05 = "{{n},{n}}";
        String s06 = "{{n},{n},{n}}";
        String s07 = "{n,{n}}";
        String s08 = "{{n,n}}";
        String s09 = "{{{n},n}}";
        String s10 = "{{{n}}}";
        String s11 = "{n,{n,{n},n},n,n,{{{{n}}}}}";
        String s12 = "{}";

        /*
         * FAILERS
         */
        String s13 = "{A}";
        String s14 = "n}";
        String s15 = "{n";
        String s16 = "n";
        String s17 = "{n}{n}";
        String s18 = "{n}n";
        String s19 = "{n,.n}";
        String s20 = "{n, n}";
        
        Scanner in = new Scanner(System.in);
        String s = new String();
        Parser p = new Parser();

        String ps = "\u001B[42m" + "PASS" + "\u001B[40m";    // "PASS" in Green
        String fs = "\u001B[41m" + "FAIL" + "\u001B[40m";    // "FAIL" in Red

        System.out.printf("CASE 00: %32s\tPARSE:%s\tEXPECTED:%s\n", s00, p.parse(s00) ? ps : fs, ps);
        System.out.printf("CASE 01: %32s\tPARSE:%s\tEXPECTED:%s\n", s01, p.parse(s01) ? ps : fs, ps);
        System.out.printf("CASE 02: %32s\tPARSE:%s\tEXPECTED:%s\n", s02, p.parse(s02) ? ps : fs, ps);
        System.out.printf("CASE 03: %32s\tPARSE:%s\tEXPECTED:%s\n", s03, p.parse(s03) ? ps : fs, ps);
        System.out.printf("CASE 04: %32s\tPARSE:%s\tEXPECTED:%s\n", s04, p.parse(s04) ? ps : fs, ps);
        System.out.printf("CASE 05: %32s\tPARSE:%s\tEXPECTED:%s\n", s05, p.parse(s05) ? ps : fs, ps);
        System.out.printf("CASE 06: %32s\tPARSE:%s\tEXPECTED:%s\n", s06, p.parse(s06) ? ps : fs, ps);
        System.out.printf("CASE 07: %32s\tPARSE:%s\tEXPECTED:%s\n", s07, p.parse(s07) ? ps : fs, ps);
        System.out.printf("CASE 08: %32s\tPARSE:%s\tEXPECTED:%s\n", s08, p.parse(s09) ? ps : fs, ps);
        System.out.printf("CASE 09: %32s\tPARSE:%s\tEXPECTED:%s\n", s09, p.parse(s09) ? ps : fs, ps);
        System.out.printf("CASE 10: %32s\tPARSE:%s\tEXPECTED:%s\n", s10, p.parse(s10) ? ps : fs, ps);
        System.out.printf("CASE 11: %32s\tPARSE:%s\tEXPECTED:%s\n", s11, p.parse(s11) ? ps : fs, ps);
        System.out.printf("CASE 12: %32s\tPARSE:%s\tEXPECTED:%s\n", s12, p.parse(s12) ? ps : fs, ps);
        System.out.printf("CASE 13: %32s\tPARSE:%s\tEXPECTED:%s\n", s13, p.parse(s13) ? ps : fs, fs);
        System.out.printf("CASE 14: %32s\tPARSE:%s\tEXPECTED:%s\n", s14, p.parse(s14) ? ps : fs, fs);
        System.out.printf("CASE 15: %32s\tPARSE:%s\tEXPECTED:%s\n", s15, p.parse(s15) ? ps : fs, fs);
        System.out.printf("CASE 16: %32s\tPARSE:%s\tEXPECTED:%s\n", s16, p.parse(s16) ? ps : fs, fs);
        System.out.printf("CASE 17: %32s\tPARSE:%s\tEXPECTED:%s\n", s17, p.parse(s17) ? ps : fs, fs);
        System.out.printf("CASE 18: %32s\tPARSE:%s\tEXPECTED:%s\n", s18, p.parse(s18) ? ps : fs, fs);
        System.out.printf("CASE 19: %32s\tPARSE:%s\tEXPECTED:%s\n", s19, p.parse(s19) ? ps : fs, fs);
        System.out.printf("CASE 20: %32s\tPARSE:%s\tEXPECTED:%s\n", s20, p.parse(s20) ? ps : fs, fs);

        while (true)
        {

            System.out.print("Enter Custom Case (Q to Quit): ");

            if (in.hasNext("Q") || in.hasNext("q")) break;

            s = in.nextLine();

            System.out.printf("CASE CC: %32s\tPARSE:%s\n", s, p.parse(s) ? ps : fs);

        }
        
        in.close();

    }

}
