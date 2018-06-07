package hello.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.cache.CacheFactory;
import hello.dto.AjaxDTO;
import hello.dto.UbikeInfoDTO;

@Controller
@RequestMapping("/ubike")
public class UBikeInfoController {

	@Autowired
	CacheFactory cacheFactory;

	@RequestMapping("/info")
	@ResponseBody
	public AjaxDTO<List<UbikeInfoDTO>> toMain() {
	    AjaxDTO<List<UbikeInfoDTO>> dto = new AjaxDTO<List<UbikeInfoDTO>>();
	    List<UbikeInfoDTO> data =  cacheFactory.getFromCache();
	    dto.setData(data);
	    return dto;
		
	}

}
