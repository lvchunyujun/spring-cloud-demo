package com.shijianzhou.language.engine.content;

import com.hexiaofei.provider0.common.SpringContextUtil;
import org.springframework.context.annotation.Bean;

public class SjzNlMapStringContentConsumeFactory implements SjzNlContentConsumeFactory {

    @Bean
    public SjzNlContentConsume getContentConsume() {
        return SpringContextUtil.getBean("sjzNlMapStringContentConsume");
    }
 
}
