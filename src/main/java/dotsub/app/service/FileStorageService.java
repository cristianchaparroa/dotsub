package dotsub.app.service;

import dotsub.app.service.dto.ImageDetailsDTO;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Path;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

  public  Path initFileStoreLocation();

  public Path getTargetLocation(MultipartFile file);

  public ImageDetailsDTO storeFile(MultipartFile file) throws Exception;

  public BasicFileAttributes getMetaData(MultipartFile mpFile)  throws Exception;

  public ImageDetailsDTO parseMetaData(MultipartFile file) throws Exception ;
  
}
