/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.config;

import java.util.Properties;

import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionShortcut;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.gemfire.GemfireTemplate;
import org.springframework.data.gemfire.LocalRegionFactoryBean;

/**
 * @author Infosys Ltd.
 *
 */
@Configuration
public class GemFireConfig {
	


	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(GemFireConfig.class);
	protected static final String DEFAULT_MANAGER_PORT = "1099";

	/** The region name. */
	@Value("${gemfire.regionname}")
	private String regionName;

	/**
	 * Instantiates a new data gem fire caching config.
	 */
	GemFireConfig() {
		super();
	}

	@Bean
	Properties gemfireProperties() {
		Properties gemfireProperties = new Properties();
		gemfireProperties.setProperty("name", GemFireConfig.class.getSimpleName());
		gemfireProperties.setProperty("log-level", "DEBUG");
		return gemfireProperties;
	}
	
	@Bean
	@Primary
	ReflectionBasedAutoSerializer reflectionBasedAutoSerializer() {

		return new ReflectionBasedAutoSerializer("com.myRetail.productservice.entity.*");

	}
	
	@Bean
	CacheFactory gemFireCacheFactory(ReflectionBasedAutoSerializer reflectionBasedAutoSerializer){
		CacheFactory gemFireCacheFactory = new CacheFactory();
		gemFireCacheFactory.setPdxReadSerialized(true);
		gemFireCacheFactory.setPdxSerializer(reflectionBasedAutoSerializer);
		return gemFireCacheFactory;
	}

	/**
	 * Gemfire cache.
	 *
	 * @param gemfireProperties
	 *            the gemfire properties
	 * @param gemFirehost
	 *            the gem firehost
	 * @param gemfirePort
	 *            the gemfire port
	 * @return the client cache
	 */
	@Bean
	@Primary
	GemFireCache gemfireCache(CacheFactory gemFireCacheFactory, @Qualifier("gemfireProperties") Properties gemfireProperties) {
		
		GemFireCache gemfireCache = gemFireCacheFactory
				//.set("log-level", "INFO")
			    .create();

		return gemfireCache;
	}

	@Bean
	@Primary
	LocalRegionFactoryBean<String,Object> gemFireRegionBean(GemFireCache gemfireCache){

		LocalRegionFactoryBean<String, Object> gemFireRegionBean = new LocalRegionFactoryBean<>();
		gemFireRegionBean.setCache(gemfireCache);
		gemFireRegionBean.setClose(true);
		gemFireRegionBean.setPersistent(false);
		gemFireRegionBean.setRegionName(regionName);
		gemFireRegionBean.setShortcut(RegionShortcut.LOCAL);
		return gemFireRegionBean;
	}

	@Bean
	@Primary
	Region<String, Object> gemFireRegion(
			LocalRegionFactoryBean<String, Object> gemFireRegionBean) {

		Region<String, Object> region = null;
		try {
			region = gemFireRegionBean.getObject();
		} catch (Exception exception) {
			log.error("Exception occured when lookup region", exception);
		}

		return region;
	}

	@Bean(name="gemFireTemplate")
	public GemfireTemplate localRegionTemplate(
			Region<String, Object> gemFireRegion) {
		return new GemfireTemplate(gemFireRegion);
	}

	/**
	 * Gets the region name.
	 *
	 * @return the region name
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * Sets the region name.
	 *
	 * @param regionName
	 *            the new region name
	 */
	public void setRegionName(final String regionName) {
		this.regionName = regionName;
	}


}
