package com.test.telefonica.config;

import com.test.telefonica.entities.CustomerEntity;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import java.time.Duration;

@Configuration
@EnableCaching
public class EhCacheConfig {

//    @Bean
//    public CacheManager EhcacheManager() {
//
//        CacheConfiguration<String, CustomerEntity> cacheConfig = CacheConfigurationBuilder
//                .newCacheConfigurationBuilder(String.class,
//                        CustomerEntity.class,
//                        ResourcePoolsBuilder.newResourcePoolsBuilder()
//                                .offheap(10, MemoryUnit.MB)
//                                .build())
//                .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(10)))
//                .build();
//
//        CachingProvider cachingProvider = Caching.getCachingProvider();
//        CacheManager cacheManager = cachingProvider.getCacheManager();
//
//        javax.cache.configuration.Configuration<String, CustomerEntity> configuration = Eh107Configuration.fromEhcacheCacheConfiguration(cacheConfig);
//        cacheManager.createCache("cacheStore", configuration);
//        return cacheManager;
//    }
}
