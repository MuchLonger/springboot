package com.cq.springbootactuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @Time: 2019/4/5 22:52
 */
@Component
public class MyAppHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
//        自定义健康状态指示器，只需要实现HealthIndicator接口，MyAppHealthIndicator命名如这个（在浏览器内显示为myApp）
        return Health.down().withDetail("msg","服务异常").build();
    }
}
