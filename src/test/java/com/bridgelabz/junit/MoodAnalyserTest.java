package com.bridgelabz.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserTest {

    @Test
    public void givenMoodAnalyserClass_ShouldReturnObject() throws MoodAnalyserException {

        Constructor<?> constructor = null;
        try {
            constructor = Class.forName("com.bridgelabz.junit.MooodAnalyser").getConstructor(String.class);
            Object mood = (MooodAnalyser)constructor.newInstance("I'm in HAPPY Mood");
            MooodAnalyser moodAnalyser = (MooodAnalyser) mood;
            String analyseMood = moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY",analyseMood);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

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
