package com.laurentiuene.shopmanagement.utils;

public class LoggerUtils {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private LoggerUtils() {}

    public static String logWithGreen(String loggedInfo) {
        return ANSI_GREEN + loggedInfo + ANSI_RESET;
    }

    public static String logWithBlack(String loggedInfo) {
        return ANSI_BLACK + loggedInfo + ANSI_RESET;
    }

    public static String logWithRed(String loggedInfo) {
        return ANSI_RED + loggedInfo + ANSI_RESET;
    }

    public static String logWithYellow(String loggedInfo) {
        return ANSI_YELLOW + loggedInfo + ANSI_RESET;
    }

    public static String logWithBlue(String loggedInfo) {
        return ANSI_BLUE + loggedInfo + ANSI_RESET;
    }

    public static String logWithPurple(String loggedInfo) {
        return ANSI_PURPLE + loggedInfo + ANSI_RESET;
    }

    public static String logWithCyan(String loggedInfo) {
        return ANSI_CYAN + loggedInfo + ANSI_RESET;
    }

    public static String logWithWhite(String loggedInfo) {
        return ANSI_WHITE + loggedInfo + ANSI_RESET;
    }

}
