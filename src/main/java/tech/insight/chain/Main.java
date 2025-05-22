package tech.insight.chain;

import tech.insight.chain.validation.Validator;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class Main {
    public static void main(String[] args) throws Exception {
        User user = new User("tom", 18);
        Validator validator = new Validator();
        validator.validate(user);
    }
}
