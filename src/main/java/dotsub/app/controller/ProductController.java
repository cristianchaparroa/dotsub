package dotsub.app.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import dotsub.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import dotsub.app.service.dto.ProductDTO;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @ResponseBody
    @CrossOrigin(origins = "*") //TODO: improve security required
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/api/product", method = RequestMethod.POST)
    public ProductDTO create(@RequestParam("image") MultipartFile file,
      @RequestParam("title") String title,
      @RequestParam("description") String description) {
          logger.debug(String.format("Title: %s", title));
          logger.debug(String.format("Desc: %s", description));
          logger.debug(String.format("File: %s",file.toString()));
          logger.debug(String.format("ProductService: %s",this.productService.toString()));
          return this.productService.create(title,description, file);
    }

}
