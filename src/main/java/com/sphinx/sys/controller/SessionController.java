package com.sphinx.sys.controller;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sphinx.common.annotation.Log;
import com.sphinx.common.utils.Result;
import com.sphinx.sys.domain.UserOnline;
import com.sphinx.sys.service.SessionService;

import java.util.Collection;
import java.util.List;

/**
 * <pre>
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 */
@RequestMapping("/sys/online")
@Controller
public class SessionController {
	@Autowired
	SessionService sessionService;
	
	@GetMapping()
	public String online() {
		return "sys/online/online";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public List<UserOnline> list(@RequestParam(required=false) String name) {
		return sessionService.list(name);
	}
	
	@Log("强踢用户下线")
	@ResponseBody
	@RequestMapping("/forceLogout/{sessionId}")
	public Result<String> forceLogout(@PathVariable("sessionId") String sessionId, RedirectAttributes redirectAttributes) {
		try {
			sessionService.forceLogout(sessionId);
			return Result.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return Result.fail();
		}
	}
	
	@ResponseBody
	@RequestMapping("/sessionList")
	public Collection<Session> sessionList() {
		return sessionService.sessionList();
	}
}
