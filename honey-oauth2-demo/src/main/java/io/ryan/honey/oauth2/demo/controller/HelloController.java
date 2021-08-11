package io.ryan.honey.oauth2.demo.controller;

import io.ryan.honey.common.core.result.Result;
import io.ryan.honey.oauth2.demo.model.SysUser;
import io.ryan.honey.oauth2.demo.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * HelloController
 *
 * @author hkc
 * @version 1.0.0
 * @date 2021-08-10 13:53
 */
@Api(tags = "demo")
@RestController
@RequestMapping(value = "/api")
public class HelloController {

    private final SysUserService sysUserService;

    private final PasswordEncoder passwordEncoder;

    public HelloController(SysUserService sysUserService, PasswordEncoder passwordEncoder) {
        this.sysUserService = sysUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @ApiOperation(value = "hello")
    @GetMapping("/hello")
    public Result<?> hello() {

        SysUser sysUser = new SysUser();
        sysUser.setUsername("Ryan");
        sysUser.setMobile("18312833057");
        sysUser.setPassword(passwordEncoder.encode("Hello@World!123"));
        sysUser.setRealityName("Ryan.Hoo");
        sysUser.setCreatedDate(LocalDateTime.now());


        boolean flag = sysUserService.save(sysUser);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}
