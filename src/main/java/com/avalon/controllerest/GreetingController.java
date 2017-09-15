package com.avalon.controllerest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.avalon.entity.Sreeting;

/**
 * 
 * @类名: GreetingController
 * @功能描述:请求处理类
 * @类创建人: Evan
 * @类创建时间： 2016-8-17 上午10:25:30
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Sreeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Sreeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    
}
