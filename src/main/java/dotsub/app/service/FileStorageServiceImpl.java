package dotsub.app.service;

import dotsub.app.util.DateUtils;
import dotsub.app.service.dto.ImageDetailsDTO;
import java.nio.file.attribute.BasicFileAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.io.IOException;
import org.springframework.util.StringUtils;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileStorageServiceImpl implements FileStorageService  {

  private Logger logger = LoggerFactory.getLogger(FileStorageServiceImpl.class);

  private Path fileStorageLocation;

  // TODO: setup this path from parameters
  public final static  String STORAGE_LOCATION = "/tmp/dutstub/products/files";


  public  Path initFileStoreLocation() {
    return Paths.get(STORAGE_LOCATION).toAbsolutePath().normalize();
  }

  @Override
  public Path getTargetLocation(MultipartFile file) {
    this.fileStorageLocation = this.initFileStoreLocation();
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    this.logger.debug(String.format("The filename is :%s", fileName));
    Path targetLocation = this.fileStorageLocation.resolve(fileName);
    return targetLocation;
  }

  public void createFile(MultipartFile file) throws Exception  {
    Path targetLocation     = this.getTargetLocation(file);
    Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
  }

  @Override
  public ImageDetailsDTO storeFile(MultipartFile file)  throws Exception {
      try {
        this.logger.debug(String.format("storing file with name:%s",file.getOriginalFilename()));
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        this.createFile(file);

        ImageDetailsDTO details = this.parseMetaData(file);
        details.setPathFile(STORAGE_LOCATION);
        details.setFileName(fileName);
        return details;

      } catch(IOException ex) {
        logger.error(ex.getMessage());
        return new ImageDetailsDTO();
      }
  }

  @Override
  public BasicFileAttributes getMetaData(MultipartFile mpFile)  throws Exception {
    logger.debug("extract meta data");
    Path file = this.getTargetLocation(mpFile);

    if (file == null) {
      logger.debug("It's not posible retrieve the target location");
      return null;
    }
    return Files.readAttributes(file, BasicFileAttributes.class);
  }

  @Override
  public ImageDetailsDTO parseMetaData(MultipartFile file) throws Exception  {
    ImageDetailsDTO details = new ImageDetailsDTO();
    BasicFileAttributes atts =this.getMetaData(file);

    logger.debug("creationTime: " + atts.creationTime());
    logger.debug("lastAccessTime: " + atts.lastAccessTime());
    logger.debug("lastModifiedTime: " + atts.lastModifiedTime());

    details.setCreationTime(DateUtils.parseFileTime(atts.creationTime(), DateUtils.FORMAT_MM_DD_YYYY_HH_MM_SS));
    details.setLastAccessTime(DateUtils.parseFileTime(atts.lastAccessTime(), DateUtils.FORMAT_MM_DD_YYYY_HH_MM_SS));
    details.setLastModifiedTime(DateUtils.parseFileTime(atts.lastModifiedTime(), DateUtils.FORMAT_MM_DD_YYYY_HH_MM_SS));
    return details;
  }
}
