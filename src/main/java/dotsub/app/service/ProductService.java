package dotsub.app.service;

import dotsub.app.service.dto.ProductDTO;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

  /**
   * It creates a new product with the name and image relate to it.
   */
  public ProductDTO create(String title, String description, MultipartFile file);
}
