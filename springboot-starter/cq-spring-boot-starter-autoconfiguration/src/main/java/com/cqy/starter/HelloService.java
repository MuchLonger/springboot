package com.cqy.starter;

public class HelloService {

    private HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHello(String name){
//        这里的前后缀都是可配置的
        return helloProperties.getPrefix()+"-"+name+"-"+helloProperties.getSuffix();
    }

}
