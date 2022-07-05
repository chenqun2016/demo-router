package com.chenchen.router.processor;

import com.chenchen.router.annotations.Destination;
import com.google.auto.service.AutoService;

import java.io.Writer;
import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

/**
 * 自动注册处理器
 */
@AutoService(Processor.class)
//支持的 Java 版本号到 1.8
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class DestinationProcessor extends AbstractProcessor {

    private static final String TAG = "DestinationProcessor";

    /**
     * 告诉编译器，当前处理器支持的注解类型
     * @return
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(Destination.class.getCanonicalName());
    }
    /**
     * 编译器找到我们关心的注解后，会回调这个方法
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
        // 避免多次调用 process
        if (roundEnvironment.processingOver()) {
            return false;
        }
        System.out.println(TAG + " >>> process start ...");

        // 获取所有标记了 @Destination 注解的 类的信息
        Set<? extends Element> allDestinationElements = roundEnvironment.getElementsAnnotatedWith(Destination.class);
        System.out.println(TAG + " >>> all Destination elements count = " + allDestinationElements.size());

        // 当未收集到 @Destination 注解的时候，跳过后续流程
        if(allDestinationElements.size() < 1){
            return false;
        }

        // 将要自动生成的类的类名
        String className = "RouterMapping_" + System.currentTimeMillis();
        // 开始拼接自动生成的类
        StringBuilder builder = new StringBuilder();
        builder.append("package com.example.router.mapping;\n\n");
        builder.append("import java.util.HashMap;\n");
        builder.append("import java.util.Map;\n\n");
        builder.append("public class ").append(className).append(" {\n\n");
        builder.append("    public static Map<String, String> get() {\n");
        builder.append("        Map<String, String> mapping = new HashMap<>();\n");

        // 遍历所有 @Destination 注解信息，挨个获取详细信息
        for(Element element :allDestinationElements){
            final TypeElement typeElement = (TypeElement) element;
            // 尝试在当前类上，获取 @Destination 的信息
            final Destination destination = typeElement.getAnnotation(Destination.class);
            if(null == destination) continue;

            final String url = destination.url();
            final String description = destination.destination();
            final String realPath = typeElement.getQualifiedName().toString();

            System.out.println(TAG + " >>> url = " + url);
            System.out.println(TAG + " >>> description = " + description);
            System.out.println(TAG + " >>> realPath = " + realPath);

            builder.append("        ")
                    .append("mapping.put(")
                    .append("\"" + url + "\"")
                    .append(", ")
                    .append("\"" + realPath + "\"")
                    .append(");\n");
        }
        builder.append("        return mapping;\n");
        builder.append("    }\n");
        builder.append("}\n");

        String mappingFullClassName = "com.example.router.mapping." + className;
        System.out.println(TAG + " >>> mappingFullClassName = " + mappingFullClassName);
        System.out.println(TAG + " >>> class content = \n\n" + builder);

        // 写入自动生成的类到本地文件中
        try {
            JavaFileObject source = processingEnv.getFiler().createSourceFile(mappingFullClassName);
            Writer writer = source.openWriter();
            writer.write(builder.toString());
            writer.flush();
            writer.close();
        }catch (Exception ex) {
            throw new RuntimeException("Error while create file", ex);
        }

        System.out.println(TAG + " >>> process finish.");
        return false;
    }
}
