package dotsub.app.service;

import dotsub.app.service.dto.ImageDetailsDTO;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileInputStream;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class FileStorageServiceTest {

    private Logger logger = LoggerFactory.getLogger(FileStorageServiceTest.class);

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @InjectMocks
    private FileStorageService fileStorageService = new FileStorageServiceImpl();

    @Test
    public void getTargetLocationTest() {
        // given
        String productFileName = "macbookpro.png";
        MockMultipartFile file = new MockMultipartFile("image", productFileName, MediaType.IMAGE_PNG_VALUE, "image".getBytes());
        Path target  = fileStorageService.getTargetLocation(file);

        // expected
        String fullPathExpected = String.format("%s/%s", FileStorageServiceImpl.STORAGE_LOCATION, productFileName);
        Assert.assertEquals(fullPathExpected, target.toString());
    }

    @Test
    public void getMetaDataTest()  throws Exception {
        // given
        String productFileName = "macbookpro.png";
        File createdFile = folder.newFile(productFileName);
        MultipartFile file = new MockMultipartFile(productFileName, new FileInputStream(createdFile));

        // Expected
        BasicFileAttributes atts = fileStorageService.getMetaData(file);
        Assert.assertNotNull(atts);
    }

    @Test
    public void parseMetaData() throws Exception  {
      // Given
      String productFileName = "macbookpro.png";
      File mockFile = folder.newFile(productFileName);
      MultipartFile file = new MockMultipartFile(productFileName, new FileInputStream(mockFile));

      // Expected
      ImageDetailsDTO details = fileStorageService.parseMetaData(file);


      if (details == null) {
        Assert.fail("The details are null");
      }

      Assert.assertNotNull(details.getLastAccessTime());
      Assert.assertNotNull(details.getCreationTime());
      Assert.assertNotNull(details.getLastModifiedTime());
    }
}
