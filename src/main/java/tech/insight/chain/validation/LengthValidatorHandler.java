package tech.insight.chain.validation;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class LengthValidatorHandler implements ValidatorHandler {

    private final int length;

    public LengthValidatorHandler(int min) {
        this.length = min;
    }


    @Override
    public void validate(Object value, ValidatorContext context) {
        if (value instanceof String stringValue) {
            if (stringValue.length() != length) {
                context.appendError("你的字符串长度是" + stringValue.length() + "应该是" + length);
            }
        }
    }
}
