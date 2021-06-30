package com.dtdhehe.system.controller;

import com.dtdhehe.common.data.JsonResult;
import com.dtdhehe.common.exception.ParamException;
import com.dtdhehe.common.exception.ServiceException;
import com.dtdhehe.system.data.vo.UserVO;
import com.dtdhehe.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Xie_东
 * @version 1.0
 * @date 2021/2/24 20:40
 * @description
 **/
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("新增用户")
    @PostMapping
    public JsonResult<UserVO> saveUser(@RequestBody UserVO userVO){
        if (StringUtils.isEmpty(userVO.getLoginName()) || StringUtils.isEmpty(userVO.getPassword())){
            throw new ParamException("用户名或密码不能为空!");
        }
        return JsonResult.success(userService.saveUser(userVO).orElseThrow(() -> new ServiceException("用户保存失败")));
    }

}
