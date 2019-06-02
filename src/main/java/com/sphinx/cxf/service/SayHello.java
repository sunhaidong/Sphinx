package com.sphinx.cxf.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface SayHello {
	@WebMethod
  public String sayHello(String user);
}
