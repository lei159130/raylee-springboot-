package com.lee1314.raylee.commons.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author leili
 */
@Component
public class SpringContext implements ApplicationContextAware {
    private static final class Singleton {
        private static ApplicationContext context;
    }

    public static ApplicationContext getInstance() {
        return Singleton.context;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Singleton.context = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return getInstance().getBean(clazz);
    }

    public static <T> T getBean(Class<T> clazz, Object... args) {
        return getInstance().getBean(clazz, args);
    }
}
