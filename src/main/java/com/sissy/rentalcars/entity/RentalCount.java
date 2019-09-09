package com.sissy.rentalcars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Sissy S
 * Pojo for rentalCount
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalCount {
   
	private int lastweek;
	private int yeartodate;
	
	/**
	 * @return the lastweek
	 */
	public int getLastweek() {
		return lastweek;
	}
	/**
	 * @param lastweek the lastweek to set
	 */
	public void setLastweek(int lastweek) {
		this.lastweek = lastweek;
	}
	/**
	 * @return the yeartodate
	 */
	public int getYeartodate() {
		return yeartodate;
	}
	/**
	 * @param yeartodate the yeartodate to set
	 */
	public void setYeartodate(int yeartodate) {
		this.yeartodate = yeartodate;
	}
	
	/**
	 *  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		 StringBuilder sb = new StringBuilder();
		 
		    sb.append("{\n"); 
		    
		    sb.append("    lastweek: ").append(toIndentedString(lastweek)).append("\n");
		    sb.append("    yeartodate: ").append(toIndentedString(yeartodate)).append("\n");
		    
		    sb.append("}\n");
		    
		    return sb.toString();
	}
	
	  /**
	   *  Convert the given object to string with each line indented by 4 spaces (except the first line).
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
