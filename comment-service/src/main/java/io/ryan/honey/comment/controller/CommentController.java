package io.ryan.honey.comment.controller;

import io.ryan.honey.common.core.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CommentController
 *
 * @author hkc
 * @version 1.0.0
 * @date 2021-08-09 15:29
 */
@RestController
@RequestMapping(value = "/comments")
@Slf4j
public class CommentController {

    @GetMapping(value = {"", "/", "/index"})
    public Result<?> index() {

        return Result.ok();
    }
}
