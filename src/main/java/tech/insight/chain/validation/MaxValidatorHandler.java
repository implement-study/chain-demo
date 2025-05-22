package tech.insight.chain.validation;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class MaxValidatorHandler implements ValidatorHandler {

    private final int max;

    public MaxValidatorHandler(int max) {
        this.max = max;
    }


    @Override
    public void validate(Object value, ValidatorContext context) {
        if (value instanceof Integer intValue) {
            if (intValue > max) {
                context.appendError("你的值是" + intValue + "不能大于" + max);
            }
        }
        context.put("name", "shengsheng");
        context.doNext(20);
    }
}
