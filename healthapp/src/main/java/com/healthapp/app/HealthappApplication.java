package com.healthapp.app;

import java.io.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
@RestController
public class HealthappApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthappApplication.class, args);
	}
@RequestMapping(value="/upload",method=RequestMethod.POST,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
public ResponseEntity<Object> uploadFile(@RequestParam("file")MultipartFile file) throws IOException{
	File convertFile =new File("C:\\Program Files\\File\\"+file.getOriginalFilename());
	convertFile.createNewFile();
	FileOutputStream fout=new FileOutputStream(convertFile);
	fout.write(file.getBytes());
	fout.close();
	return new ResponseEntity<>("File Uploaded Successfully",HttpStatus.OK);
}
}
