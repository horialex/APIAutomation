package com.tools.utils;

import net.thucydides.core.annotations.Step;
import org.unitils.reflectionassert.ReflectionAssert;

public class ValidationUtils {

    public static boolean compareObj(Object o, Object w){
        try {
            ReflectionAssert.assertReflectionEquals(o, w);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
