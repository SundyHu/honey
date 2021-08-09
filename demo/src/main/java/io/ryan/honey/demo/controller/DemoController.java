package io.ryan.honey.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoController
 *
 * @author hkc
 * @version 1.0.0
 * @date 2021-08-09 10:34
 */
@RestController
@RequestMapping(value = "/demo")
@Slf4j
@Api(tags = "示例")
public class DemoController {

    @ApiOperation(value = "示例Demo")
    @GetMapping(value = "/demo")
    public String demo() {

        return "OK";
    }
}
