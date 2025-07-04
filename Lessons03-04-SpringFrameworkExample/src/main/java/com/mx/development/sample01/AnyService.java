package com.mx.development.sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author josesaidolanogarcia
 */
@Component
public class AnyService {

    @Autowired
    @FormatterType("Bar")
    private Formatter formatter;
    //Formatter bar = new BarFormatter();

    public String doSomething() {
        return formatter.format();
    }

}
