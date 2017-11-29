package com.mvcsample.controllers;

import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MyDemoController2 {

	@RequestMapping(value="/myForm")
	public String myForm( ) {
		
		return "myForm";
		
	}
	
	@RequestMapping(value="/handleForm")
	public String handleForm(@RequestParam("file") MultipartFile file) {
		
		try {
			if(!file.isEmpty()) {
				byte[] bytes = file.getBytes();
				FileOutputStream fos = new FileOutputStream("C:\\Users\\631021\\Documents\\myFile.jpg");
				fos.write(bytes);
				fos.close();
				System.out.println("File saved successfully");
			} else {
				System.out.println("No file avilable to save.");
			}
			
		}
		catch(Exception e) {
			System.out.println("Erro saving file");
		}
		return "operationComplete";
		
	}
	
}
