package gt.edu.umg.desaweb.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "config")
public class ConfigProperty {

	private boolean showException;
	private String jwtSecret;
	private int jwtExpiration;
	private String seed;

	public boolean isShowExecption() {
		return showException;
	}

	public void setShowExecption(boolean showExecption) {
		this.showException = showExecption;
	}

	public boolean isShowException() {
		return showException;
	}

	public void setShowException(boolean showException) {
		this.showException = showException;
	}

	public String getJwtSecret() {
		return jwtSecret;
	}

	public void setJwtSecret(String jwtSecret) {
		this.jwtSecret = jwtSecret;
	}

	public int getJwtExpiration() {
		return jwtExpiration;
	}

	public void setJwtExpiration(int jwtExpiration) {
		this.jwtExpiration = jwtExpiration;
	}

	public String getSeed() {
		return seed;
	}

	public void setSeed(String seed) {
		this.seed = seed;
	}

}
