package com.sphinx.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sphinx.common.annotation.Log;
import com.sphinx.common.base.AdminBaseController;
import com.sphinx.common.domain.Tree;
import com.sphinx.common.type.EnumErrorCode;
import com.sphinx.common.utils.MD5Utils;
import com.sphinx.common.utils.Result;
import com.sphinx.sys.domain.MenuDO;
import com.sphinx.sys.service.MenuService;

import java.util.List;

/**
 * <pre>
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 */
@Controller
public class LoginController extends AdminBaseController {

    @Autowired
    MenuService menuService;
//    @Autowired
//    FileService fileService;

    @GetMapping({ "/", "" })
    String welcome(Model model) {
        return "redirect:/login";
    }

    @GetMapping({ "/index" })
    String index(Model model) {
        List<Tree<MenuDO>> menus = menuService.listMenuTree(getUserId());
        model.addAttribute("menus", menus);
        model.addAttribute("name", getUser().getName());
        model.addAttribute("username", getUser().getUsername());
       // FileDO fileDO = fileService.selectById(getUser().getPicId());
       // model.addAttribute("picUrl", fileDO == null ? "/img/photo_s.jpg" : fileDO.getUrl());
        return "index_v1";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @Log("登录")
    @PostMapping("/login")
    @ResponseBody
    Result<String> ajaxLogin(String username, String password) {
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);//记住我是可选项，但只有会话缓存到redis等持久存储才能真正记住
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return Result.ok();
        } catch ( UnknownAccountException uae ) {
            //username wasn't in the system, show them an error message?
        	  return Result.build(EnumErrorCode.userLoginFail.getCode(),"用户名不存在");
        } catch ( IncorrectCredentialsException ice ) {
            //password didn't match, try again?
        	  return Result.build(EnumErrorCode.userLoginFail.getCode(), "密码不存在");
        } catch ( LockedAccountException lae ) {
            //account for that username is locked - can't login.  Show them a message?
        	  return Result.build(EnumErrorCode.userLoginFail.getCode(), "用户被锁定");
        }catch (AuthenticationException e) {
            return Result.build(EnumErrorCode.userLoginFail.getCode(), EnumErrorCode.userLoginFail.getMsg());
        }
    }
    
    @GetMapping("/main")
    String main() {
        return "main";
    }

    @GetMapping("/403")
    String error403() {
        return "403";
    }

}
