package com.lssl.medical.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * @author : 黑渊白花
 * @ClassName JacksonConfig
 * @date : 2024/9/19 18:34
 * @Description
 */

public class JacksonConfig {
    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        //通过该方法对mapper对象进行设置，所有序列化的对象都将按改规则进行系列化，属性为NULL 不序列化
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }
    //此配置类配置了JSON序列化规则，即当一个对象属性值为null时则不进行序列化。
    //Include.Include.ALWAYS 默认
    //Include.NON_DEFAULT    属性为默认值不序列化
    //nclude.NON_EMPTY       属性为 空（""） 或者为 NULL 都不序列化
    //Include.NON_NULL       属性为NULL 不序列化
}
