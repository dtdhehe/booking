package com.dtdhehe.controller;

import com.dtdhehe.common.data.JsonResult;
import com.dtdhehe.entity.TbUser;
import com.dtdhehe.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/3/26 17:37
 * @description
 **/
@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Resource(name = "customUserDetailService")
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/doLogin")
    public JsonResult<String> login(@RequestBody TbUser user) throws Exception{
        authenticate(user.getLoginName(), user.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(user.getLoginName());
        String token = jwtTokenUtil.generateToken(userDetails);
        return JsonResult.success(token);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
