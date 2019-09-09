package com.sissy.rentalcars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author sissy s
 * pojo for perDayRent
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PerDayRent {
  
	private float price;
	private float discount;
	
	
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	@JsonSetter("Price")
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the discount
	 */
	public float getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	@JsonSetter("Discount")
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	/**
	 *  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		 StringBuilder sb = new StringBuilder();
		 
		    sb.append("{\n"); 
		    
		    sb.append("    Price: ").append(toIndentedString(price)).append("\n");
		    sb.append("    Discount: ").append(toIndentedString(discount)).append("\n");
		    
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
