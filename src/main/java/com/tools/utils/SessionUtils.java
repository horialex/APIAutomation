package com.tools.utils;

import com.tools.constants.SessionConstants;
import net.serenitybdd.core.Serenity;

public class SessionUtils {
    public static <T> T getFromSession(String object){
        return (T) Serenity.getCurrentSession().get(object);
    }
    public static void putOnSession(String objectName, Object object){
        Serenity.getCurrentSession().put(objectName, object);
    }
}
