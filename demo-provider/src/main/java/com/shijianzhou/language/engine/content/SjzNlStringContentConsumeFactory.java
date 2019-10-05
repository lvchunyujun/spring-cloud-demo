package com.shijianzhou.language.engine.content;

public class SjzNlStringContentConsumeFactory implements SjzNlContentConsumeFactory {

    @Override
    public SjzNlContentConsume getContentConsume() {
        return new SjzNlStringContentConsume();
    }
}
