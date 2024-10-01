package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.*;

public class Exercise32 {

    public static void main(String[] args) {

        BufferedReader reader;
        String line;
        try{
            reader = new BufferedReader(new FileReader("src/main/resources/data.txt"));
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String stringToSave = generateStringToSave(line);
        printToFile(stringToSave);
    }

    public static String generateStringToSave(String string) {
        return string == null ? generateUserInputToSave() : string;
    }

    private static String generateUserInputToSave(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while(!(string = Utils.string()).isEmpty()){
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        try (PrintWriter out = new PrintWriter("src/main/resources/data.txt")) {
            out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
