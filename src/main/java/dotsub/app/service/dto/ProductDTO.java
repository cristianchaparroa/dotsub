package dotsub.app.service.dto;

public class ProductDTO {

  private int id;
  private String description;
  private String title;
  private ImageDetailsDTO imageDetails;

  public ProductDTO() {}

	/**
	* Returns value of id
	* @return
	*/
	public int getId() {
		return id;
	}

	/**
	* Sets new value of id
	* @param
	*/
	public void setId(int id) {
		this.id = id;
	}

	/**
	* Returns value of description
	* @return
	*/
	public String getDescription() {
		return description;
	}

	/**
	* Sets new value of description
	* @param
	*/
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	* Returns value of title
	* @return
	*/
	public String getTitle() {
		return title;
	}

	/**
	* Sets new value of title
	* @param
	*/
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	* Returns value of imageDetails
	* @return
	*/
	public ImageDetailsDTO getImageDetails() {
		return imageDetails;
	}

	/**
	* Sets new value of imageDetails
	* @param
	*/
	public void setImageDetails(ImageDetailsDTO imageDetails) {
		this.imageDetails = imageDetails;
	}
}
