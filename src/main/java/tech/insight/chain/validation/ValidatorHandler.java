package tech.insight.chain.validation;


/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public interface ValidatorHandler {

    void validate(Object value, ValidatorContext context);
}
