package com.sissy.rentalcars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author Sissy S
 * Pojo for metadata
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaData {
	
	private String color;
	private String notes;
	
	
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	@JsonSetter("Color")
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	@JsonSetter("Notes")	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	/**
	 *  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		 StringBuilder sb = new StringBuilder();
		 
		    sb.append("{\n"); 
		    
		    sb.append("    Color: ").append(toIndentedString(color)).append("\n");
		    sb.append("    Notes: ").append(toIndentedString(notes)).append("\n");
		    
		    sb.append("}\n");
		    
		    return sb.toString();
	}
	
	  /** 
	   * Convert the given object to string with each line indented by 4 spaces (except the first line).
	   * @param o
	   * @return
	   */
	  private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }

}
