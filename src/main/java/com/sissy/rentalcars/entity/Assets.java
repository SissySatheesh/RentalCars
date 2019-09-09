package com.sissy.rentalcars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author Sissy S
 * Pojo for asset
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Assets {
	
	private Car car;
	
	/**
	 * @return the cars
	 */
	public Car getCar() {
		return car;
	}


	/**
	 * @param cars the cars to set
	 */
	@JsonSetter("Car")	
	public void setCar(Car car) {
		this.car = car;
	}


	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		 StringBuilder sb = new StringBuilder();
		 
		    sb.append("[\n"); 
		    sb.append("    Car: ").append(toIndentedString(car)).append("\n");
		    sb.append("]\n");
		
		return sb.toString();
	}

	  /**
	   *  Convert the given object to string with each line indented by 4 spaces (except the first line).
	   * @param any object
	   * @return indented String
	   */
	  private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }


	
	
}
