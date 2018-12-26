package com.lantianxiang.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Create by Lantianxiang
 * Description: TODO
 * Create Date: 2018/12/25
 * Create Time: 16:36
 **/
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {
    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(o);
        return true;
    }
}
