package com.bridgelabz.junit;

public class MooodAnalyser {
    private String message;
    public MooodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() throws MoodAnalyserException{
        try{
            if(message.length()==0)
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_EMPTY,"Enter proper mood");
            if(message.contains("HAPPY") )
                return "HAPPY";
            return "SAD";
        }catch (NullPointerException e){
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_NULL,"Enter proper mood");
        }
    }
}
