package dotsub.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="image_details")
public class ImageDetails {

  @Column
  private String fileName;

  @Column
  private String pathFile;

  @Column
  private String creationTime;

  @Column
  private String lastAccessTime;

  @Column
  private String lastModifiedTime;

	/**
	* Returns value of fileName
	* @return
	*/
	public String getFileName() {
		return fileName;
	}

	/**
	* Sets new value of fileName
	* @param
	*/
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	* Returns value of pathFile
	* @return
	*/
	public String getPathFile() {
		return pathFile;
	}

	/**
	* Sets new value of pathFile
	* @param
	*/
	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	/**
	* Returns value of creationTime
	* @return
	*/
	public String getCreationTime() {
		return creationTime;
	}

	/**
	* Sets new value of creationTime
	* @param
	*/
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	/**
	* Returns value of lastAccessTime
	* @return
	*/
	public String getLastAccessTime() {
		return lastAccessTime;
	}

	/**
	* Sets new value of lastAccessTime
	* @param
	*/
	public void setLastAccessTime(String lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	/**
	* Returns value of lastModifiedTime
	* @return
	*/
	public String getLastModifiedTime() {
		return lastModifiedTime;
	}

	/**
	* Sets new value of lastModifiedTime
	* @param
	*/
	public void setLastModifiedTime(String lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
}
