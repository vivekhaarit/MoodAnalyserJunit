package com.bridgelabz.junit;

public class MoodAnalyserException extends Exception{
    public enum ExceptionType{
        ENTERED_NULL, ENTERED_EMPTY, METHOD_INVOCATION_ISSUE,INSTANTIATION_ISSUE, NO_SUCH_METHOD, CLASS_NOT_FOUND_ISSUE, NO_SUCH_FIELD;
    }
    public ExceptionType type;
    public MoodAnalyserException(ExceptionType type,String message){
        super(message);
        this.type = type;
    }
}
