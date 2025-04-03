package com.kh.start.file.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileService {

	private final Path fileLocation;
	
	public FileService() {
		this.fileLocation = Paths.get("uploads").toAbsolutePath().normalize();
	}
	
	public String store(MultipartFile file) {
		
		// 이름 바꾸는 메소드 호출~~~ (생략)
		
		String originalFileName =
				file.getOriginalFilename();
		
		Path targetLocation = this.fileLocation.resolve(originalFileName);
		log.info("저장경로쓰 : {}", targetLocation);
		try {
			Files.copy(file.getInputStream(), 
					targetLocation, 
					StandardCopyOption.REPLACE_EXISTING);
			
			return "http://localhost/uploads/" + originalFileName;
		} catch(IOException e) {
			throw new RuntimeException("이상요상 파일이예용");
		}
		
	}
}
