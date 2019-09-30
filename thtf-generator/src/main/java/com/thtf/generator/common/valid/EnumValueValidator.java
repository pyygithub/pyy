package com.thtf.generator.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * ========================
 * 自定义验证
 * Author：pyy
 * Date：2019/9/24 17:34
 * Version: v1.0
 * ========================
 */
public class EnumValueValidator implements ConstraintValidator< EnumValue, Object> {
    private String[] strValues;
    private int[] intValues;

    @Override
    public void initialize(EnumValue constraintAnnotation) {
        strValues = constraintAnnotation.strValues();
        intValues = constraintAnnotation.intValues();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context ) {
        if(value instanceof String) {
            for (String s:strValues) {
                if(s.equals(value)){
                    return true;
                }
            }
        }else if(value instanceof Integer){
            for (Integer s:intValues) {
                if(s==value){
                    return true;
                }
            }
        }
        return false;

    }
}
