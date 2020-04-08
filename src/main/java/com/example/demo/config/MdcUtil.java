package com.example.demo.config;

import org.slf4j.MDC;

import java.util.Map;

public class MdcUtil {
    private Map<String, String> contextMap = MDC.getCopyOfContextMap();

    public void set(Object any) {
        MDC.setContextMap(contextMap);
    }
}