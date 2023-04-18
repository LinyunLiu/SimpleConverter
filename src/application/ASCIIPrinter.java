/*
Name: Linyun Liu
Title: Simple Converter
 */
package application;

import java.util.ArrayList;

public class ASCIIPrinter {
    private final String TEXT_RESET = "\u001B[0m";
    private final String TEXT_BLACK = "\u001B[30m";
    private final String TEXT_RED = "\u001B[31m";
    private final String TEXT_GREEN = "\u001B[32m";
    private final String TEXT_YELLOW = "\u001B[33m";
    private final String TEXT_BLUE = "\u001B[34m";
    private final String TEXT_PURPLE = "\u001B[35m";
    private final String TEXT_CYAN = "\u001B[36m";
    private final String TEXT_WHITE = "\u001B[37m";

    private ArrayList<String> listDec = new ArrayList<>();
    private ArrayList<String> listHex = new ArrayList<>();
    private ArrayList<String> listBi = new ArrayList<>();
    private ArrayList<String> listHTML = new ArrayList<>();
    private ArrayList<String> listChar = new ArrayList<>();

    private String output = "";

    public ASCIIPrinter(){

    }

    public String PrintASCIITable(){
        output += "------------------------------------------------"+"\n";
        output += "                   ASCII Table                  "+"\n";
        output += "------------------------------------------------"+"\n";
        output += "Dec   Hex   Binary      HTML   Character"+"\n";

        Populate();
        for (int i=0; i<=127; i++) {
            output += listDec.get(i)+"    "+listHex.get(i)+"    "+listBi.get(i)+"    "+listHTML.get(i)+"    ";
            output += listChar.get(i)+"\n";
        }

        return output;
    }

    public void Populate(){
        for (int i=0; i<=127; i++) {
            if (String.valueOf(i).length()==1){
                listDec.add("0"+i);
            }
            else {
                listDec.add(String.valueOf(i));
            }
            listHTML.add("&#"+i);
        }

        for (int i=0; i<=127; i++) {
            if (Integer.toHexString(i).length()==1){
                listHex.add("0"+Integer.toHexString(i).toUpperCase());
            }
            else {
                listHex.add(Integer.toHexString(i).toUpperCase());
            }
        }

        for (int i=0; i<=127; i++) {
            listBi.add("0".repeat(8 - Integer.toBinaryString(i).length()) + Integer.toBinaryString(i));
        }


        for (int i=0; i<=32; i++){
            listChar.add(Character.getName(i));
        }
        for (int i=33; i<127; i++){
            listChar.add(Character.toString(i));
        }
        listChar.add(Character.getName(127));
    }
}
