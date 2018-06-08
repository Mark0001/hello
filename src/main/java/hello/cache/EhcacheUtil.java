package hello.cache;

import org.springframework.stereotype.Component;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@Component
public class EhcacheUtil {

    public enum CacheGroup {
        cache120Sec
    }

    private CacheManager cacheManager;

    public EhcacheUtil() {
        this.cacheManager = CacheManager.newInstance();
    }

    public <T> void addElement(CacheGroup cacheGroup, String cahceKey, Object obj) {
        Cache cache = this.cacheManager.getCache(cacheGroup.name());
        Element element = new Element(cahceKey, obj);
        cache.put(element);
    }

    public <T> T getElement(CacheGroup cacheGroup, String cahceKey) {
        Cache cache = this.cacheManager.getCache(cacheGroup.name());
        Element element = cache.get(cahceKey);
        return element == null ? null : (T) element.getObjectValue();
    }

}
