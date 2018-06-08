package dotsub.app.controller;

import dotsub.app.service.dto.ImageDetailsDTO;
import dotsub.app.service.FileStorageService;
import dotsub.app.service.dto.ProductDTO;
import dotsub.app.service.ProductService;
import org.junit.Test;
import org.junit.Ignore;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.junit.Before;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import org.mockito.Mockito;


@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductControllerTest   {

  @InjectMocks
  private ProductController productController;

  private MockMvc mockMvc;

  @Before
  public void setup() {

        // Process mock annotations
        MockitoAnnotations.initMocks(this);

        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
  }

  // TODO:
  @Ignore("Not ready yet, This test will fails until mock all  intermediate services and responses")
  @Test
  public void testCreateProduct()   throws Exception {
      ProductService productService = Mockito.mock(ProductService.class);
      FileStorageService fileStorageService = Mockito.mock(FileStorageService.class);

      String productFileName = "macbookpro.png";
      String title = "IPhone perita";
      String description = "This is a perita imitation!.";

      ImageDetailsDTO detailsResult = new ImageDetailsDTO();
      ProductDTO productResult = new ProductDTO();

      MockMultipartFile file = new MockMultipartFile("image", productFileName, MediaType.IMAGE_PNG_VALUE, "image".getBytes());

      Mockito.when(fileStorageService.storeFile(file)).thenReturn(detailsResult);
      Mockito.when(productService.create(title, description, file)).thenReturn(productResult);

      mockMvc.perform(
          fileUpload("/api/product")
            .file(file)
            .param("title", title)
            .param("description", description)
      ).andDo(print())
       .andExpect(status().isCreated())
       .andExpect(jsonPath("title").value(title));

  }
}
