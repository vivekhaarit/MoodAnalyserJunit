package com.bridgelabz.junit;

public class MoodAnalyser {
    private String message;

    public MoodAnalyser(String message) {
        this.message = message;
    }
    public String analyseMood(String message) throws MoodAnalyserException {
        //why this method overloading is done & why a call in the return stmt.
        this.message=message;   //jab constructor se kaam ho raha tha to ye kahe likhe??
        return analyseMood();
    }
    public String analyseMood() throws MoodAnalyserException{
        try{
            if(message.length()==0)
                //condition true hone ke baad to exception throw ho jayega, to catch block to kabhi nahi chalega?
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_EMPTY,"Enter proper mood");
            if(message.contains("HAPPY"))
                return "HAPPY";
            else
                return "SAD";
        }catch (NullPointerException e){
            //my doubt is that this line should never execute.
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_NULL,"Enter proper mood");
        }
    }
    @Override
    public boolean equals(Object anotherObject) {
        //why we are creating this method
        if(this.message.equals(((MoodAnalyser)anotherObject).message))
            return true;
        return false;
    }
}
