package tech.insight.chain.validation;

import tech.insight.chain.exception.ValidatorException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class ValidatorChain {

    private final List<ValidatorHandler> handlers = new ArrayList<>();


    public void validate(Object value) throws ValidatorException {
        ValidatorContext context = new ValidatorContext(value);
        while (true) {
            int index = context.currentIndex();
            if (index == handlers.size()) {
                break;
            }
            ValidatorHandler handler = handlers.get(index);
            handler.validate(context.getValue(), context);
            if (index == context.currentIndex()) {
                break;
            }
        }

        context.throwExceptionIfNecessary();
    }

    public void addLastHandler(ValidatorHandler handler) {
        this.handlers.add(handler);
    }


}
