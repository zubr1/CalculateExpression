package com.zubr1;

import org.mariuszgromada.math.mxparser.Expression;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static com.zubr1.Constants.*;

/**
 * Class which implements simple calculator.
 * @author Michał Cendrowski (zubr)
 * @version 1.0
 */
class Calculator {
    /**
     *  Just runs calculator. User have 3 options: read data from command, read data from file or exit program.
     */
    void run(){
        Scanner scScanner = new Scanner(System.in);
        String sData;
        do{
            show(MENU);
            sData = scScanner.nextLine();
            if(sData.equals(OPTION_1)){
                cmdMode();
            }else if(sData.equals(OPTION_2)){
                fileMode();
            }
        }while(!sData.equals(OPTION_3));
    }

    /**
     * Provides command line mode to the user. It simply reads expression from command line.
     */
    private void cmdMode(){
        Scanner scScanner = new Scanner(System.in);
        while(true){
            show(CMD_PROMPT);
            if(captureExpression(scScanner.nextLine())==false){
                return;
            }
        }
    }

    /**
     * Provides file mode to the user. It simply reads expressions from file (line by line).
     */
    private void fileMode(){
        show(FILE_MODE_PROMPT);
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_DIRECTORY));
            String line =  br.readLine();
            while (line != null){
                if(captureExpression(line)==false){
                    return;
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            show(FILE_NOT_FOUND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        I know that method seems to be stupid (external library handles validation), but according to task, calculator should
        only handle * - + and / operators. So I had to nerf it a litte bit, because normally it calculates also powers,
        roots, factorials etc... :)
     */
    /**
     * Validates expression which should contains only numbers, optional spaces and specified characters (+-*\/).
     * @param sExpression Not checked math expression.
     * @return If expression is valid, then returns true. Otherwise retunrs false.
     */
    private boolean isValidExpression(String sExpression){
        return sExpression.matches("^[0-9*/+-.]+$");
    }

    /**
     * Calculates expression using external library.
     * @param sExpression Raw math expression.
     * @return Expression concatenated with the result
     */
    private String calculateExpression(String sExpression){
        Expression e = new Expression(sExpression);
        return String.valueOf(e.calculate());

    }

    /**
     * Captures expression. After validation prints the results.
     * @param sExpression Raw math expression.
     * @return Returns false if it's end of input data or end command was read. Otherwise returns true.
     */
    private boolean captureExpression(String sExpression){
        if(sExpression.equals(END_CMD_MODE)){
            return false;
        }
        String result = calculateExpression(sExpression);
        if(isValidExpression(sExpression+result)) {
            show(sExpression + EQUAL_SIGN + result);
        }else{
            show(WRONG_EXPRESSION_TEXT + sExpression);
        }
        return true;
    }

    /**
     * Prints text inside command line.
     * @param s Text to print.
     */
    private void show(String s){
        System.out.println(s);
    }
}

