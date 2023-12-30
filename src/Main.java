import java.util.*;
import java.lang.Math;
/*
 * @author Olivia Folliard
 * @since 9/18/2023
 * @version 1.1
 */
import java.lang.Math;
import java.util.*;

public class Main {
    public static int bin2Dec(int []bin){
        //converts binary back to base ten
        int dec = 0;
        for (int i = 0; i < 32; i++){
            if (bin[i] == 1){
                dec += Math.pow(2, (31 - i));
            }
            else{
                dec += 0;
            }
        }
        return dec;
    }

    public static char []hex(int baseTen){
        //converts base ten to hexadecimal
        if (baseTen < 0){
            int [] bin = binary(baseTen);
            int [] twos = twosComplement(bin);
            baseTen = bin2Dec(twos);
        }
        char[] hexArr = new char[8]; //allocates a new array to hold hex value
        int count = 1;
        int remain;
        while (((baseTen * 16) / 16) >= 1){
            //until the base ten value is less than 1, check remainder
            //and use remainder value to assign hexadecimal values
            remain = baseTen % 16;
            if (remain < 10){
                hexArr[8 - count] = (char)(remain + '0');
            }
            else{
                if (remain == 10){
                    hexArr[8 - count] = 'A';
                }
                if (remain == 11){
                    hexArr[8 - count] = 'B';
                }
                if (remain == 12){
                    hexArr[8 - count] = 'C';
                }
                if (remain == 13){
                    hexArr[8 - count] = 'D';
                }
                if (remain == 14){
                    hexArr[8 - count] = 'E';
                }
                if (remain == 15){
                    hexArr[8 - count] = 'F';
                }
            }
            count += 1;
            baseTen = baseTen / 16;
        }
        for (int i = 0; i < 8; i++) {
            if (hexArr[i] == (char) 0) {
                hexArr[i] = '0';
            }
        }
        return hexArr;
    }


    public static int []binary(int baseTen){
        //converts base ten to binary
        //takes a number in decimal and converts it to binary
        int absVal = Math.abs(baseTen);
        int temp = baseTen;
        int []retVal;
        int[] bin = new int[33];
        int count = 1;
        while ((absVal * 2) / 2 > 0){
            if (absVal % 2 == 0){
                bin[32 - count] = 0;
            }
            else{
                bin[32 - count] = 1;
            }
            absVal = absVal / 2;
            count ++;
        }
        for (int i = 0; i < 33; i++){
            if (bin[i] == (int)0){
                bin[i] = 0;
            }
        }
        if (temp < 0){
            retVal = twosComplement(bin);
        }
        else{
            retVal = bin;
        }
        return retVal;
    }

    public static int []twosComplement(int []bin){
        //uses twos complement for negative binary numbers
        for (int i = 0; i < 32; i++){
            if (bin[i] == 0){
                bin[i] = 1;
            }
            else{
                bin[i] = 0;
            }
        }
        int count = 31;
        while (bin[count] == 1){
            count--;
        }
        bin[count] = 1;
        for (int i = 31; i > count; i--) {
            bin[i] = 0;
        }
        return bin;
    }
    //part 2, going from hexadecimal to decimal

    public static void hex2Dec(String hex){
        int dec = 0;
        for (int i = 0; i < 8; i++){
            if (hex.charAt(i) == '0'){
                dec += 0;
            }
            else if (hex.charAt(i) == '1'){
                dec += 1 * Math.pow(16,(7 - i));
            }
            else if (hex.charAt(i) == '2'){
                dec += 2 * Math.pow(16,(7 - i));
            }
            else if (hex.charAt(i) == '3'){
                dec += 3 * Math.pow(16,(7 - i));
            }
            else if (hex.charAt(i) == '4'){
                dec += 4 * Math.pow(16,(7 - i));
            }
            else if (hex.charAt(i) == '5'){
                dec += 5 * Math.pow(16,(7 - i));
            }
            else if (hex.charAt(i) == '6'){
                dec += 6 * Math.pow(16,(7 - i));
            }
            else if (hex.charAt(i) == '7'){
                dec += 7 * Math.pow(16,(7 - i));
            }
            else if (hex.charAt(i) == '8'){
                dec += 8 * Math.pow(16,(7 - i));
            }
            else if (hex.charAt(i) == '9'){
                dec += 9 * Math.pow(16,(7 - i));
            }
            else if (hex.charAt(i) == 'A'){
                dec += 10 * Math.pow(16,(7 - i));
            }
            else if (hex.charAt(i) == 'B'){
                dec += 11 * Math.pow(16,(7 - i));
            }
            else if (hex.charAt(i) == 'C'){
                dec += 12 * Math.pow(16,(7 - i));
            }
            else if (hex.charAt(i) == 'D'){
                dec += 13 * Math.pow(16,(7 - i));
            }
            else if (hex.charAt(i) == 'E'){
                dec += 14 * Math.pow(16,(7 - i));
            }
            else if (hex.charAt(i) == 'F'){
                dec += 15 * Math.pow(16,(7 - i));
            }
        }
        System.out.print("Base 10 Representation: ");
        System.out.print(dec);
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a number in base 10: ");
        int baseTen = scnr.nextInt();

        int []bin = binary(baseTen);
        char []hex = hex(baseTen);

        System.out.print("Binary Representation (Base 2): ");
        for (int i = 0; i < 32; i++) {
            System.out.print(bin[i]);
        }

        System.out.println();
        System.out.print("Hexadecimal Representation (Base 16): ");
        System.out.println(hex);
        System.out.print("Input a number in hexadecimal representation: ");
        Scanner scnr2 = new Scanner(System.in);
        String hex2 = scnr2.nextLine();
        hex2Dec(hex2);
    }
}