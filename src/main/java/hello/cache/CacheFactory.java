package hello.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CacheFactory {

    @Autowired
    EhcacheUtil cacheUtil;
    
    public <T> T getFromCache() {
       T t = cacheUtil.getElement(EhcacheUtil.CacheGroup.cache1, "key");
       if(t != null) {
           System.out.println("get From cache");
           return t;
       }else {
           System.out.println("not get From cache");
           String value = "你好";
           cacheUtil.addElement(EhcacheUtil.CacheGroup.cache1, "key", value);
           return (T) value;
       }
    }
}
