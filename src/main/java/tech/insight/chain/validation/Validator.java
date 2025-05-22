package tech.insight.chain.validation;

import tech.insight.chain.annotation.Length;
import tech.insight.chain.annotation.Max;
import tech.insight.chain.annotation.Min;

import java.lang.reflect.Field;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class Validator {


    private ValidatorChain buildValidateChain(Field field) {
        ValidatorChain chain = new ValidatorChain();
        Max max = field.getAnnotation(Max.class);
        if (max != null) {
            chain.addLastHandler(new MaxValidatorHandler(max.value()));
        }
        Min min = field.getAnnotation(Min.class);
        if (min != null) {
            chain.addLastHandler(new MinValidatorHandler(min.value()));
        }
        Length length = field.getAnnotation(Length.class);
        if (length != null) {
            chain.addLastHandler(new LengthValidatorHandler(length.value()));
        }
        return chain;
    }

    public void validate(Object bean) throws Exception {
        Class<?> beanClass = bean.getClass();
        for (Field field : beanClass.getDeclaredFields()) {
            field.setAccessible(true);
            ValidatorChain chain = buildValidateChain(field);
            chain.validate(field.get(bean));
        }
    }


}
