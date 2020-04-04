package com.bridgelabz.junit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {
    public static MoodAnalyser createMoodAnalyser(String message) {
        try {
            Constructor<?> constructor = Class.forName("com.bridgelabz.junit.MoodAnalyser").getConstructor(String.class);
            Object moodObject = constructor.newInstance(message);
            return (MoodAnalyser) moodObject;
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
        return null;
    }
    //kya ye invokeMethod predefined hai??
    public static Object invokeMethod(MoodAnalyser moodObject, String analyseMood)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return moodObject.getClass().getMethod(analyseMood).invoke(moodObject);
    }
}
