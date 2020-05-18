package com.ipl;

public class CricketLeagueAnalyserException extends Exception {

    enum ExceptionType {
        CSV_FILE_PROBLEM, FILE_NOT_PRESENT,DATA_NOT_APPROPRIATE,INCORRECT_DELIMITER
        ,NOT_ABLE_TO_PARSE
    }
    ExceptionType type;
    CricketLeagueAnalyserException(String message, ExceptionType type){
        super(message);
        this.type = type;
    }
}
