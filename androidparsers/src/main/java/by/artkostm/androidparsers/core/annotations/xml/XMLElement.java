package by.artkostm.androidparsers.core.annotations.xml;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface XMLElement {
    public String name();
    public Class<?> type() default Default.class;
    
    public static class Default {}
}
