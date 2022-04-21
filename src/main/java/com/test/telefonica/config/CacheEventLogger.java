package com.test.telefonica.config;

import lombok.extern.log4j.Log4j2;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

@Log4j2
public class CacheEventLogger implements CacheEventListener<Object, Object> {

    @Override
    public void onEvent(
            CacheEvent<? extends Object, ? extends Object> cacheEvent) {
        log.info("New EhCache event: {}, old: {}, new: {}", cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
    }
}