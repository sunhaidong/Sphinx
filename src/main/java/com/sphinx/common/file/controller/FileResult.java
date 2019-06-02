package com.sphinx.common.file.controller;

public class FileResult {
   public String code;
   public String msg;
   public Data data=new Data();
   
   public class Data{
	   public String src;
   }
}
