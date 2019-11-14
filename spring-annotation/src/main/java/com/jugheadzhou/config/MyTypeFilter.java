package com.jugheadzhou.config;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 自定义类型拦截类
 */
public class MyTypeFilter implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        String className = annotationMetadata.getClassName();
        System.out.println(className);
        //自定义规则：只匹配类名包含UserDao的类
        if (className.contains("UserDao")){
            return true;
        }
        return false;
    }
}
