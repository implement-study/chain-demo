package tech.insight.chain;


import tech.insight.chain.annotation.Length;
import tech.insight.chain.annotation.Max;
import tech.insight.chain.annotation.Min;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class User {

    @Length(3)
    private final String name;

    @Max(17)
    @Min(20)
    private final Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
