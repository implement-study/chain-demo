package tech.insight.chain.validation;

import tech.insight.chain.exception.ValidatorException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class ValidatorContext {

    private final List<String> errorMessageList = new ArrayList<>();

    private boolean stop = false;

    private int index = 0;

    private Object value;

    private Map<String, Object> data = new HashMap<>();

    public ValidatorContext(Object value) {
        this.value = value;
    }

    public void appendError(String message) {
        errorMessageList.add(message);
    }

    public void stopChain() {
        this.stop = true;
    }

    public void doNext(Object value) {
        index++;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public int currentIndex() {
        return index;
    }

    public boolean shouldStop() {
        return this.stop;
    }

    public void put(String key, Object value) {
        this.data.put(key, value);
    }

    public Object get(String key) {
        return this.data.get(key);
    }

    public void throwExceptionIfNecessary() throws ValidatorException {
        if (errorMessageList.isEmpty()) {
            return;
        }
        throw new ValidatorException(errorMessageList.toString());
    }
}
