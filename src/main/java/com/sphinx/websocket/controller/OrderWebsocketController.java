package com.sphinx.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sphinx.common.base.AdminBaseController;

@Controller
@RequestMapping("/demo/socket")
public class OrderWebsocketController extends AdminBaseController{
   @Autowired
    private SimpMessagingTemplate simpleTemplete;
	@RequestMapping("/order")
	public String GetOrderWebsocket() {
		return "/demo/socket/OrderSocket";
	}
	@ResponseBody
	@RequestMapping("/send")
	public void SendMessage() {
		this.simpleTemplete.convertAndSend("/topic/greeting", "server");
	}
}
