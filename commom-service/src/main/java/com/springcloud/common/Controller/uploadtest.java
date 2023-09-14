package com.springcloud.common.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class uploadtest {
	@PostMapping("/upload")
	public String handFileLoad(@RequestParam("file") MultipartFile file)
	{
		if(!file.isEmpty())
		{
			String filename = file.getOriginalFilename();
			System.out.println(filename);
			try {
				byte[] fileBytes = file.getBytes();
				return "success!";
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}
		return "error";
	}

}
