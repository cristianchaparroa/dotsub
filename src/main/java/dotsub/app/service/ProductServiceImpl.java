package dotsub.app.service;

import dotsub.app.service.dto.ImageDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dotsub.app.service.dto.ProductDTO;


@Service
public class ProductServiceImpl implements ProductService {

  private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

  @Autowired
  private FileStorageService fileStorageService;

  public ProductDTO create(String title, String description,MultipartFile file) {

    ProductDTO product = new ProductDTO();
    try {
      ImageDetailsDTO details = this.fileStorageService.storeFile(file);

      if (details == null) {
        logger.error("The  image datails is null after store the file");
      }
      logger.debug(String.format("Details:%s ",details.getPathFile()));
      product.setImageDetails(details);
      product.setTitle(title);
      product.setDescription(description);
      // TODO: persist the product here
      return product;
    } catch(Exception ex) {
      logger.error(ex.getMessage());
      ex.printStackTrace();
    }

    return product;
  }
}
