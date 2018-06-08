package hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.cache.UbikeStationCacheFactory;
import hello.dto.AjaxDTO;
import hello.dto.UbikeInfoDTO;

@Controller
@RequestMapping("/ubike")
public class UBikeInfoController {

    @Autowired
    UbikeStationCacheFactory cacheFactory;

    @RequestMapping("/info")
    @ResponseBody
    public AjaxDTO<List<UbikeInfoDTO>> toMain() {
        AjaxDTO<List<UbikeInfoDTO>> dto = new AjaxDTO<List<UbikeInfoDTO>>();
        try {
            dto.setStatus(true);
            dto.setMessage("查詢成功");
            List<UbikeInfoDTO> data = cacheFactory.getFromCache();
            dto.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            dto.setStatus(false);
            dto.setMessage("查詢失敗");
        }
        return dto;

    }

}
