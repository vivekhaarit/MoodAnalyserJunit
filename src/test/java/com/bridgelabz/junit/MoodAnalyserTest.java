package com.bridgelabz.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyserTest {
    @Test
    public void MoodTest() throws MoodAnalyserException {
        MooodAnalyser mooodAnalyser = new MooodAnalyser("I'm in SAD mood");
        String message = mooodAnalyser.analyseMood();
        Assert.assertEquals("SAD",message);
    }

    @Test
    public void happyMoodTest() throws MoodAnalyserException {
        MooodAnalyser mooodAnalyser=new MooodAnalyser("I'm in HAPPY mood");
        String mood = mooodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMessage_WhenNull_ShouldReturnMoodAnalyseException()  {
        MooodAnalyser mooodAnalyser = new MooodAnalyser(null);
        String mood = null;
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalyserException.class);
            mood = mooodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("Enter proper mood",e.getMessage());
        }
    }

    @Test
    public void givenMessage_WhenEmptyString_ShouldReturnMoodAnalyseException() {
        MooodAnalyser moodAnalyser = new MooodAnalyser("");
        String mood = null;
        try {
              moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
              Assert.assertEquals(MoodAnalyserException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }
}
