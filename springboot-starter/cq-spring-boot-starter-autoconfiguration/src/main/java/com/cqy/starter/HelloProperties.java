package com.cqy.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

//绑定配置文件中所有以cq.hello为开头的配置
@ConfigurationProperties(prefix = "cq.hello")
public class HelloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
