package com.bi.biproxyapi.config.property;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("biproxy")
public class BiproxyProperty {
		
	private String port;
	
	private String [] origins;
	

	/**
	 * @return the origins
	 */
	public String[] getOrigins() {
		return origins;
	}

	/**
	 * @param origins the origins to set
	 */
	public void setOrigins(String[] origins) {
		this.origins = origins;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	

	
	
	
	

}
