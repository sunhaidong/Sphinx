package com.sphinx.cxf.service.imp;

import java.util.Date;

import javax.jws.WebService;

import com.sphinx.cxf.service.SayHello;



@WebService(targetNamespace="http://service.ws.sample/" )
public class SayHelloImp  implements SayHello{

	@Override
	public String sayHello(String user) {
		// TODO Auto-generated method stub
		return user+":hello!"+new Date();
	}

}
