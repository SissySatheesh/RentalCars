package com.sissy.rentalcars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Sissy S
 * pojo for metrics
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metrics {
	
	private float yoymaintenancecost;
	private float depreciation;
	private RentalCount rentalcount;
	
	
	/**
	 * @return the yoymaintenancecost
	 */
	public float getYoymaintenancecost() {
		return yoymaintenancecost;
	}
	/**
	 * @param yoymaintenancecost the yoymaintenancecost to set
	 */
	public void setYoymaintenancecost(float yoymaintenancecost) {
		this.yoymaintenancecost = yoymaintenancecost;
	}
	/**
	 * @return the depreciation
	 */
	public float getDepreciation() {
		return depreciation;
	}
	/**
	 * @param depreciation the depreciation to set
	 */
	public void setDepreciation(float depreciation) {
		this.depreciation = depreciation;
	}
	/**
	 * @return the rentalcount
	 */
	public RentalCount getRentalcount() {
		return rentalcount;
	}
	/**
	 * @param rentalcount the rentalcount to set
	 */
	public void setRentalcount(RentalCount rentalcount) {
		this.rentalcount = rentalcount;
	}
	
	/**
	 *  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		 StringBuilder sb = new StringBuilder();
		 
		    sb.append("{\n"); 
		    
		    sb.append("    yoymaintenancecost: ").append(toIndentedString(yoymaintenancecost)).append("\n");
		    sb.append("    depreciation: ").append(toIndentedString(depreciation)).append("\n");
		    sb.append("    rentalcount: ").append(toIndentedString(rentalcount)).append("\n");
		   
		    sb.append("}\n");
		    
		    return sb.toString();
	}
	
	  /**
	   *  Convert the given object to string with each line indented by 4 spaces (except the first line).
	   */
	  private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }
    
}
