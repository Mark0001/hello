package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hello.cache.CacheFactory;

@Controller
@RequestMapping("/")
@PropertySource("classpath:googleMapApiKey.properties")
public class MainController {

	@Value("${mykey}")
	private String googleMapApiKey;

	// @Autowired
	// EhcacheUtil cacheUtil;
	@Autowired
	CacheFactory cacheFactory;

	@RequestMapping(method = RequestMethod.GET)
	public String toMain(Model model) {
		System.out.println(googleMapApiKey);
		model.addAttribute("googleMapApiKey", googleMapApiKey);

		return "home";
	}

}
