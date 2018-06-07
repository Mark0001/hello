package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hello.cache.CacheFactory;

@Controller
@RequestMapping("/main")
public class HelloController {

	// @Autowired
	// EhcacheUtil cacheUtil;
	@Autowired
	CacheFactory cacheFactory;

	@RequestMapping("hello")
	public String toMain(Model model) {

		// String value = cacheUtil.getElement(EhcacheUtil.CacheGroup.cache1, "key");
		String value = cacheFactory.getFromCache();
		model.addAttribute("message", value);
		return "hello";
	}

}
