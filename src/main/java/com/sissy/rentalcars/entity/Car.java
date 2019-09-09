package com.sissy.rentalcars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Sissy S
 * Pojo for Car
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {
	
	private String make;
	private String model;
	private String vin;
	private MetaData metadata;
	private PerDayRent perdayrent;
	private Metrics metrics;
	
   
	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the vin
	 */
	public String getVin() {
		return vin;
	}
	/**
	 * @param vin the vin to set
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}
	/**
	 * @return the metadata
	 */
	public MetaData getMetadata() {
		return metadata;
	}
	/**
	 * @param metadata the metadata to set
	 */
	public void setMetadata(MetaData metadata) {
		this.metadata = metadata;
	}
	/**
	 * @return the perdayrent
	 */
	public PerDayRent getPerdayrent() {
		return perdayrent;
	}
	/**
	 * @param perdayrent the perdayrent to set
	 */
	public void setPerdayrent(PerDayRent perdayrent) {
		this.perdayrent = perdayrent;
	}
	/**
	 * @return the metrices
	 */
	public Metrics getMetrics() {
		return metrics;
	}
	/**
	 * @param metrices the metrices to set
	 */
	public void setMetrics(Metrics metrics) {
		this.metrics= metrics;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		 StringBuilder sb = new StringBuilder();
		 
		    sb.append("{\n"); 
		    
		    sb.append("    make: ").append(toIndentedString(make)).append("\n");
		    sb.append("    model: ").append(toIndentedString(model)).append("\n");
		    sb.append("    vin: ").append(toIndentedString(vin)).append("\n");
		    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
		    sb.append("    perdayrent: ").append(toIndentedString(perdayrent)).append("\n");
		    sb.append("    metrices: ").append(toIndentedString(metrics)).append("\n");
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
