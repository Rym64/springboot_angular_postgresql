package com.stagepfe.cni.services;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.stagepfe.cni.models.UploadFichier;
import com.stagepfe.cni.repository.FileRepository;

@Service
public class FileService {
	 @Autowired
	  private FileRepository fileDBRepository;

	  public UploadFichier store(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    UploadFichier FileDB = new UploadFichier(fileName, file.getContentType(), file.getBytes());

	    return fileDBRepository.save(FileDB);
	  }

	  public UploadFichier getFile(String id) {
	    return fileDBRepository.findById(id).get();
	  }
	  
	  public Stream<UploadFichier> getAllFiles() {
	    return fileDBRepository.findAll().stream();
	  }
}
