package com.sphinx.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sphinx.common.base.AdminBaseController;

@Controller
public class WebsocketController {

	@MessageMapping("/hello")
	@SendTo("/topic/greeting")
	public String Greeting(String msg) {
		return "hi,sun "+msg;
	}
}
