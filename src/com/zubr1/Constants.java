package com.zubr1;

/**
 * Class for holding static strings
 * @author Michał Cendrowski (zubr)
 * @version 1.0
 */
class Constants {
    /**
     * The menu description with 3 options
     */
    static final String MENU="Wybierz odpowiednią opcję:\n1. Czytaj dane z cmd\n2. Czytaj operacje z pliku\n3. Koniec programu";
    /**
     * Prompt for command line mode
     */
    static final String CMD_PROMPT="Wpisz wyrażenie które chcesz policzyć";
    /**
     * Info about file mode
     */
    static final String FILE_MODE_PROMPT="Czytanie danych z pliku...";
    /**
     * Special string which ends possibility to read next data
     */
    static final String END_CMD_MODE="koniec";
    /**
     * Equal sign used for concatenate expression with it's result
     */
    static final String EQUAL_SIGN="=";
    /**
     * Error info about wrong expression
     */
    static final String WRONG_EXPRESSION_TEXT="Podane wyrażenie jest nieobsługiwane lub nieprawidłowe: ";
    /**
     * Directory to the file which can be read from file mode
     */
    static final String FILE_DIRECTORY ="txtFiles\\expressions.txt";
    /**
     * Error info about missing file
     */
    static final String FILE_NOT_FOUND= "Nie znaleziono pliku: "+FILE_DIRECTORY;
    /**
     * 1 sign used in main menu
     */
    static final String OPTION_1="1";
    /**
     * 2 sign used in main menu
     */
    static final String OPTION_2="2";
    /**
     * 3 sign used in main menu
     */
    static final String OPTION_3="3";
}
