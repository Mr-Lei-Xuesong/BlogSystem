package com.demo.utils;

import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;

public class MyBeanUtils {

    public static String[] getNullPropertyNames(Object object) {
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(object);
        PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();
        ArrayList<String> nullPropertyNames = new ArrayList<>();
        for (PropertyDescriptor pd : pds) {
            String propertyName = pd.getName();
            if (beanWrapper.getPropertyValue(propertyName) == null) {
                nullPropertyNames.add(propertyName);
            }
        }
        return nullPropertyNames.toArray(new String[nullPropertyNames.size()]);
    }
}
