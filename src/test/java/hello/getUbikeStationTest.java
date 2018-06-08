package hello;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import hello.cache.UbikeStationCacheFactory;
import hello.dto.UbikeStationInfoDTO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-servlet.xml")
public class getUbikeStationTest {
    
    @Autowired
    UbikeStationCacheFactory cacheFactory;
    
    @Test
    public void test() {
        List<UbikeStationInfoDTO> datas = this.cacheFactory.getFromCache();
        for(UbikeStationInfoDTO dto : datas) {
            System.out.println(dto.toString());
        }
    }

}
