package com.bridgelabz.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserTest {

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
            Assert.assertEquals("Enter proper mood",e.getMessage());
        }
    }
    @Test
    public void givenMessage_WhenEmptyString_ShouldReturnMoodAnalyseException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
              moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
              Assert.assertEquals("Enter proper mood",e.getMessage());
        }
    }


    @Test
    public void moodAnalyzerObject_whenProper_ShouldReturnSad() {
        try {
        /*  Constructor  constructor = Class.forName("com.bridgelabz.junit.MoodAnalyser").getConstructor(String.class);
            MoodAnalyser mood = (MoodAnalyser) constructor.newInstance("I am in Sad Mood");
            String analyseMood = mood.analyseMood();
            Assert.assertEquals("sad", analyseMood);*/
            Constructor<?> constructor = MoodAnalyserReflector.getConstructor(String.class);
            MoodAnalyser mood = (MoodAnalyser) MoodAnalyserReflector.createMoodAnalyser(constructor," I am in sad mood ");
            Assert.assertEquals(new MoodAnalyser(" I am in sad mood "), mood );
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenMoodAnalyserObject_WhenProper_ShouldReturnSad() throws MoodAnalyserException {
        Constructor<?> constructor = null;
        try {
            constructor = Class.forName("com.bridgelabz.junit.MoodAnalyser").getConstructor(String.class);
            Object mood = (MoodAnalyser)constructor.newInstance("I'm in HAPPY Mood");
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
    public void moodAnalyzerObject_WhenProper_ShouldReturnObject() throws MoodAnalyserException{
        Constructor<?> constructor = MoodAnalyserReflector.getConstructor(String.class);
        MoodAnalyser moodAnalyser =  (MoodAnalyser) MoodAnalyserReflector.createMoodAnalyser(constructor, "I am in HAPPY mood");
        Assert.assertEquals(new MoodAnalyser("I am in HAPPY mood"), moodAnalyser);
    }
    @Test
    public void givenSadMessage_UsingReflection_ShouldReturnSad() throws MoodAnalyserException {
        Constructor<?> constructor = MoodAnalyserReflector.getConstructor(String.class);
        MoodAnalyser modeAnalyserObject = (MoodAnalyser) MoodAnalyserReflector.createMoodAnalyser(constructor,"I am in SAD mood");
        Object analyseMood = MoodAnalyserReflector.invokeMethod(modeAnalyserObject, "analyseMood");
        Assert.assertEquals("SAD",analyseMood);
    }
    @Test
    public void givenMoodAnalyser_OnChangeMood_ShouldReturnHappy() throws MoodAnalyserException {
        Constructor<?> constructor = MoodAnalyserReflector.getConstructor(String.class);
        MoodAnalyser modeAnalyserObject = (MoodAnalyser) MoodAnalyserReflector.createMoodAnalyser(constructor," ");
        MoodAnalyserReflector.setFieldValue(modeAnalyserObject,"message","I Am in HAPPY Mood");
        Object analyseMood = MoodAnalyserReflector.invokeMethod(modeAnalyserObject, "analyseMood");
        Assert.assertEquals("HAPPY",analyseMood);
    }
    @Test
    public void givenHappyMessage_WithDefaultConstructor_ShouldReturnHappy() throws MoodAnalyserException {
        Constructor<?> constructor = MoodAnalyserReflector.getConstructor();
        MoodAnalyser modeAnalyserObject = (MoodAnalyser) MoodAnalyserReflector.createMoodAnalyser(constructor);
        MoodAnalyserReflector.setFieldValue(modeAnalyserObject,"message","I Am in HAPPY Mood");
        Object analyseMood = MoodAnalyserReflector.invokeMethod(modeAnalyserObject, "analyseMood");
        Assert.assertEquals("HAPPY",analyseMood);
    }
    @Test
    public void givenMoodAnalyser_WithType_ShouldReturnHappy() throws MoodAnalyserException {
        Constructor<?> constructor = MoodAnalyserReflector.getConstructor(String.class,MoodAnalyser.MoodType.class);
        MoodAnalyser mood = (MoodAnalyser) MoodAnalyserReflector.createMoodAnalyser(constructor," I am in HAPPY mood ",MoodAnalyser.MoodType.happy);
        Assert.assertEquals(new MoodAnalyser(" I am in HAPPY mood "), mood );
    }

}
