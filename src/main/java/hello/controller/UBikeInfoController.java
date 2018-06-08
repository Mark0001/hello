package hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.cache.UbikeServiceCacheFactory;
import hello.cache.UbikeStationCacheFactory;
import hello.dto.AjaxDTO;
import hello.dto.UbikeInfoDTO;
import hello.dto.UbikeStationInfoDTO;

@Controller
@RequestMapping("/ubike")
public class UBikeInfoController {

    @Autowired
    UbikeStationCacheFactory stationCacheFactory;

    @Autowired
    UbikeServiceCacheFactory serviceCacheFactory;

    @RequestMapping("/stationInfo")
    @ResponseBody
    public AjaxDTO<List<UbikeStationInfoDTO>> stationInfo() {
        AjaxDTO<List<UbikeStationInfoDTO>> dto = new AjaxDTO<List<UbikeStationInfoDTO>>();
        try {
            dto.setStatus(true);
            dto.setMessage("查詢成功");
            List<UbikeStationInfoDTO> data = stationCacheFactory.getFromCache();
            dto.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            dto.setStatus(false);
            dto.setMessage("查詢失敗");
        }
        return dto;
    }

    @RequestMapping("/serviceInfo")
    @ResponseBody
    public AjaxDTO<UbikeInfoDTO> serviceInfo(String city, String stationId) {
        AjaxDTO<UbikeInfoDTO> dto = new AjaxDTO<UbikeInfoDTO>();
        try {
            dto.setStatus(true);
            dto.setMessage("查詢成功");
            UbikeInfoDTO data = serviceCacheFactory.getFromCache(city, stationId);
            dto.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            dto.setStatus(false);
            dto.setMessage("查詢失敗");
        }
        return dto;
    }

}
