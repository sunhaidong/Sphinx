package com.sphinx.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sphinx.common.annotation.Log;
import com.sphinx.common.base.AdminBaseController;
import com.sphinx.common.utils.Result;
import com.sphinx.sys.domain.RoleDO;
import com.sphinx.sys.service.RoleService;

import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * </pre>
 * 
 * <small> 2018年3月23日 | Aron</small>
 */
@RequestMapping("/sys/role")
@Controller
public class RoleController extends AdminBaseController {
    String prefix = "sys/role";
    @Autowired
    RoleService roleService;
    
    @RequiresPermissions("sys:role:role")
    @GetMapping()
    String role() {
        return prefix + "/role";
    }
    
    @RequiresPermissions("sys:role:role")
    @GetMapping("/list")
    @ResponseBody()
    List<RoleDO> list() {
        List<RoleDO> roles = roleService.findAll();
        return roles;
    }

    @RequiresPermissions("sys:role:add")
    @GetMapping("/add")
    String add() {
        return prefix + "/add";
    }

    @RequiresPermissions("sys:role:edit")
    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        RoleDO roleDO = roleService.selectById(id);
        model.addAttribute("role", roleDO);
        return prefix + "/edit";
    }

    @Log("保存角色")
    @RequiresPermissions("sys:role:add")
    @PostMapping("/save")
    @ResponseBody()
    Result<String> save(RoleDO role) {
        roleService.insert(role);
        return Result.ok();
    }

    @Log("更新角色")
    @RequiresPermissions("sys:role:edit")
    @PostMapping("/update")
    @ResponseBody()
    Result<String> update(RoleDO role) {
        roleService.updateById(role);
        return Result.ok();
    }
    
    @Log("删除角色")
    @RequiresPermissions("sys:role:remove")
    @PostMapping("/remove")
    @ResponseBody()
    Result<String> save(Long id) {
        roleService.deleteById(id);
        return Result.ok();
    }
    
    @RequiresPermissions("sys:role:batchRemove")
    @Log("批量删除角色")
    @PostMapping("/batchRemove")
    @ResponseBody
    Result<String> batchRemove(@RequestParam("ids[]") Long[] ids) {
        roleService.deleteBatchIds(Arrays.asList(ids));
        return Result.ok();
    }
}
