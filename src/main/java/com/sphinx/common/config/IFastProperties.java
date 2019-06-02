package com.sphinx.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * </pre>
 * 
 * <small> 2018年4月6日 | Aron</small>
 */
@Component
@ConfigurationProperties(prefix = "sphinx")
@Data
public class IFastProperties {
    /**
     * 项目名，末尾不带 "/"
     */
    private String projectName;
    /**
     * 项目根目录，末尾带 "/"
     */
    private String projectRootURL;

    /**
     * 演示模式
     */
    private boolean demoMode;
    /**
     * 调试模式
     */
    private boolean devMode;
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectRootURL() {
		return projectRootURL;
	}
	public void setProjectRootURL(String projectRootURL) {
		this.projectRootURL = projectRootURL;
	}
	public boolean isDemoMode() {
		return demoMode;
	}
	public void setDemoMode(boolean demoMode) {
		this.demoMode = demoMode;
	}
	public boolean isDevMode() {
		return devMode;
	}
	public void setDevMode(boolean devMode) {
		this.devMode = devMode;
	}
    
    

}
