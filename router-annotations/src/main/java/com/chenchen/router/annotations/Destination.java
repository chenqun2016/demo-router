package com.chenchen.router.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 说明当前注解可以修饰的元素，此处表示可以用于标记在类上面
 */
@Target({ElementType.TYPE})

/**
 * 说明当前注解可以被保留的时间
 * SOURCE： 只会保留在源码里，源码经过编译后，注解信息会被丢弃，不会保留在编译好的class文件里；
 * CLASS： 注解在class文件中可用，但会被JVM丢弃。该类型的注解信息会保留在源码里和class文件里，在执行的时候，不会加载到虚拟机中。这也是默认的生命周期；
 * RUNTIME： 注解信息将在运行期（Java虚拟机加载之后）也保留，因此可以通过反射机制读取注解的信息。
 */
@Retention(RetentionPolicy.CLASS)
public @interface Destination {

    /**
     * 当前页面的URL，不能为空
     * @return 页面的URL
     */
    String url();

    /**
     * 对于当前页面的中文描述
     * @return 例如"个人中心"
     */
    String destination();
}
