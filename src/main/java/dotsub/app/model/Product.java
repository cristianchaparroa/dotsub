package dotsub.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

@Entity
public class Product {

  @Id
  @GeneratedValue
  private int id;

  @Column
  private String description;

  @Column
  private String title;


  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "image_details_id")
  private ImageDetails imageDetails;


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
	public ImageDetails getImageDetails() {
		return imageDetails;
	}

	/**
	* Sets new value of imageDetails
	* @param
	*/
	public void setImageDetails(ImageDetails imageDetails) {
		this.imageDetails = imageDetails;
	}
}
