package com.sphinx.common.file.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/common/file")
public class FileController {
	@GetMapping()
    String File() {
		return "common/file/file";
    }
	
	@PostMapping("/multiUpload")
	@ResponseBody 
	public String multiUpload(HttpServletRequest request) {
		FileResult result=new FileResult();
	    result.code="0";
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file"); 
		String filePath = "/"; 
		for (int i = 0; i < files.size(); i++) { 
			MultipartFile file = files.get(i);
			if (file.isEmpty())
			{ 
				return "上传第" + (i++) + "个文件失败";
				}
			String fileName = file.getOriginalFilename();
			File dest = new File(filePath + fileName); 
			try {
				if(!dest.exists()) {
					file.transferTo(dest); 
					result.msg="上传成功";
				}
							


			}
			catch (IOException e) { 
		
				return "上传第" + (i++) + "个文件失败"; 
				} 
			} 
	         return JSON.toJSONString(result);
			}

}
