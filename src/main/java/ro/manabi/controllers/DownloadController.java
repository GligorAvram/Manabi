package ro.manabi.controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownloadController {
	
	private final String dirPath = "/var/lib/tomcat9/files/";
	
	@RequestMapping("/files/kanjidmg")
	public void kanjidmgPack(HttpServletResponse response) throws IOException {
		File file = new File(dirPath + "kanjidmg.apkg");
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename="+ file.getName();
		
		response.setHeader(headerKey, headerValue);
		
		ServletOutputStream outputStream = response.getOutputStream();
		
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		
		byte[] buffer = new byte[8192]; //8kb buffer
		int bytesRead = -1;
		
		while((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outputStream.close();
	}
	
	@RequestMapping("/files/kana")
	public void kanaPack(HttpServletResponse response) throws IOException {
		File file = new File(dirPath + "kana.apkg");
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename="+ file.getName();
		
		response.setHeader(headerKey, headerValue);
		
		ServletOutputStream outputStream = response.getOutputStream();
		
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		
		byte[] buffer = new byte[8192]; //8kb buffer
		int bytesRead = -1;
		
		while((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outputStream.close();
	}
	
	
	@RequestMapping("/files/inceput")
	public void starterPack(HttpServletResponse response) throws IOException {
		File file = new File(dirPath + "inceput.apkg");
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename="+ file.getName();
		
		response.setHeader(headerKey, headerValue);
		
		ServletOutputStream outputStream = response.getOutputStream();
		
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		
		byte[] buffer = new byte[8192]; //8kb buffer
		int bytesRead = -1;
		
		while((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outputStream.close();
	}
	
	@RequestMapping("/files/rtk")
	public void rtkKanji(HttpServletResponse response) throws IOException {
		File file = new File(dirPath + "rtk.apkg");
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename="+ file.getName();
		
		response.setHeader(headerKey, headerValue);
		
		ServletOutputStream outputStream = response.getOutputStream();
		
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		
		byte[] buffer = new byte[8192]; //8kb buffer
		int bytesRead = -1;
		
		while((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outputStream.close();
	}
}

