package com.bridgelabz.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserTest {
    @Test    //jab ham try-catch se handle kar rahe hain to declare karana jaroori hai kya??
    public void givenMoodAnalyserObject_WhenProper_ShouldReturnSad() throws MoodAnalyserException {
        Constructor<?> constructor = null;
        try {                                                                           //only class name??
            constructor = Class.forName("com.bridgelabz.junit.MoodAnalyser").getConstructor(String.class);
            Object mood = (MoodAnalyser)constructor.newInstance("I'm in HAPPY Mood");
            //if you write:: ModeAnalyser mood = (ModeAnalyser) constructor.newInstance("I am in Sad Mood");
            //then you won't need to write to the Object mood wala line.
            MoodAnalyser moodAnalyser = (MoodAnalyser) mood;
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
        }catch (MoodAnalyserException e){
            e.printStackTrace();
        }
    }
    @Test
    public void moodTest() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I'm in SAD mood");
        String message = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD",message);
    }
    @Test
    public void happyMoodTest() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser =new MoodAnalyser("I'm in HAPPY mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }
    @Test
    public void givenMessage_WhenNull_ShouldReturnMoodAnalyseException()  {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String mood = null;
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalyserException.class);
            mood = moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            //e.getMessage() exception class wala message return karta hai na??
            Assert.assertEquals("Enter proper mood",e.getMessage());
        }
    }
    @Test
    public void givenMessage_WhenEmptyString_ShouldReturnMoodAnalyseException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        String mood = null;
        try {
              moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
              Assert.assertEquals("Enter proper mood",e.getMessage());
        }
    }
    //---------------------------------------------------------------------------------------------------------------
    @Test
    public void moodAnalyzerObject_WhenProper_ShouldReturnObject() {
        MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser("I am in happy mood");
        Assert.assertEquals(new MoodAnalyser("I am in happy mood"), moodAnalyser);

    }
    @Test
    public void givenHappyMessage_UsingReflection_ShouldReturnHappy()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MoodAnalyser moodObject = MoodAnalyserReflector.createMoodAnalyser("I am in sad Mood");
        Object analyseMood = MoodAnalyserReflector.invokeMethod(moodObject, "analyseMood");
        Assert.assertEquals("sad",analyseMood);
    }
}
