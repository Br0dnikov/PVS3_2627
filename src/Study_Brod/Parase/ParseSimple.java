package Study_Brod.Parase;

import java.util.Arrays;

public class ParseSimple {
    public static void main(String[]args){
        String data = "Hello World! 3 3 3 3";

        String[] tokens = data.split(" ");
        System.out.println(Arrays.toString(tokens));

        int paraseNumber = Integer.parseInt(tokens[1]);
        System.out.println(paraseNumber);
    }
}
