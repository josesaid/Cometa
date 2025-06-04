package com.mx.development.sample01;

import org.springframework.stereotype.Component;

@FormatterType("Bar")
@Component
public class BarFormatter implements Formatter {

    @Override
    public String format() {
        return "<b>Bar</b>";
    }

}
