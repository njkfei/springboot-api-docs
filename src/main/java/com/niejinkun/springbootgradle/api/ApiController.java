package com.niejinkun.springbootgradle.api;

import com.niejinkun.springbootgradle.model.Greeting;
import com.niejinkun.springbootgradle.model.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by niejinping on 2016/8/25.
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    @RequestMapping(value = "user/{name}/{password}",method= RequestMethod.GET,produces = "application/json")
    @ApiOperation(value="测试-user", notes="获取用户名",response = User.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "返回结果正常", response = User.class),
        @ApiResponse(code = 201, message = "返回结果异常", response = User.class) })
    public User user(  @ApiParam(required=true, name="name", value="姓名") @PathVariable("name")String name,
                       @ApiParam(required=true, name="password", value="密码") @PathVariable("password")String password
    ){
        return new User(1,name,password);
    }

    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping(value = "/ignore")
    public String ignore() {

        return "ignore";
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @RequestMapping(value="/greeting",method=RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
