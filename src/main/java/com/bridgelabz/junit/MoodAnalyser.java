package com.bridgelabz.junit;

public class MoodAnalyser {
    private String message;

    public enum MoodType {
        happy,sad;
    }
    private MoodType moodType;
    public MoodAnalyser() {  }
    public MoodAnalyser(String message) { this.message = message; }
    public MoodAnalyser(String message, MoodType moodType) {
        this.message = message;
        this.moodType=moodType;
    }

    public String analyseMood(String message) throws MoodAnalyserException {
        this.message=message;
        return analyseMood();
    }
    public String analyseMood() throws MoodAnalyserException{
        try{
            if(message.length()==0)
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_EMPTY,"Enter proper mood");
            if(message.contains("HAPPY"))
                return "HAPPY";
            else
                return "SAD";
        }catch (NullPointerException e){
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_NULL,"Enter proper mood");
        }
    }
    @Override
    public boolean equals(Object anotherObject) {
        if(this.message.equals(((MoodAnalyser)anotherObject).message))
            return true;
        return false;
    }
}
