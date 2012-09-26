package com.flybyu.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.flybyu.web.util.FileStorage;
import com.flybyu.web.util.ResponseError;

@Controller
@RequestMapping("/images")
public class ImageController {
	
	@RequestMapping(value = "/upload", method=RequestMethod.POST)
	@ResponseBody
	public Object upload(@RequestParam() String path, @RequestParam() MultipartFile file)
    {
		System.out.println(path);
		if (!file.isEmpty()) {
			try {
				byte[] bytes;
				bytes = file.getBytes();
				File imageFile = new File(FileStorage.storageFilePath(path + file.getOriginalFilename()));
				if (!imageFile.exists()) {
					if (!imageFile.getParentFile().exists()) {
						imageFile.getParentFile().mkdirs();
					}
					
					imageFile.createNewFile();
				}
				FileOutputStream fos = new FileOutputStream(imageFile);
				fos.write(bytes);
				fos.close();
				return "/images/".concat(path);
			} catch (IOException e) {
				return new ResponseError(ResponseError.ERROR_EXCEPTION, e.getMessage());
			}
		} else {
			return new ResponseError(ResponseError.ERROR_FAILURE, "The file is empty.");
		}
    }
}
