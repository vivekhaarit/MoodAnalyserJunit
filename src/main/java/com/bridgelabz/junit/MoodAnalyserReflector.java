package com.bridgelabz.junit;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {
    public static Constructor<?> getConstructor(Class<?>... param) throws MoodAnalyserException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.junit.MoodAnalyser");
            Constructor<?> constructor = moodAnalyserClass.getConstructor(param);
            return constructor;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.CLASS_NOT_FOUND_ISSUE, "Issue with CLASS NOT FOUND");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD, "Enter Proper method name");
        }
    }
    public static Object createMoodAnalyser(Constructor<?> constructor, Object ... message) throws MoodAnalyserException {
        try {
            //Constructor<?> constructor = Class.forName("com.bridgelabz.junit.MoodAnalyser").getConstructor(String.class);
            Object moodObject = constructor.newInstance(message);
            return  moodObject;
        } catch (IllegalAccessException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.METHOD_INVOCATION_ISSUE,"method invocation issue");
        } catch (InstantiationException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.INSTANTIATION_ISSUE,"instantiation issue");
        } catch (InvocationTargetException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.METHOD_INVOCATION_ISSUE,"method invocation issue");
        }
    }
    public static Object invokeMethod(MoodAnalyser moodObject, String analyseMood)
            throws MoodAnalyserException {
        try {
            return moodObject.getClass().getMethod(analyseMood).invoke(moodObject);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.METHOD_INVOCATION_ISSUE, "Issue with data entered");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD, "Enter Proper method name");
        }
    }


    public static void setFieldValue (MoodAnalyser moodObject, String fieldName, String fieldValue) throws MoodAnalyserException {
        try {
            Field field = moodObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(moodObject, fieldValue);
        } catch (IllegalAccessException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_FIELD, "ENTER Proper field name");
        } catch (NoSuchFieldException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.METHOD_INVOCATION_ISSUE, "Issue With Data Entered");
        }
    }
}
