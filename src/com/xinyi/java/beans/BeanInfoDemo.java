package com.xinyi.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @author guxinxin
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);

        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    //System.out.println(propertyDescriptor);
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    String propertyDescriptorName = propertyDescriptor.getName();
                    if ("age".equals(propertyDescriptorName)){
                        // String --> Integer
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                    }
                });
    }
    static class StringToIntegerPropertyEditor extends PropertyEditorSupport{
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
