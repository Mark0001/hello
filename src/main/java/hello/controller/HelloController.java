package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class HelloController {

	@RequestMapping("hello")
	public String toMain(Model model) {

		model.addAttribute("message", "你好");
		return "hello";
	}

}
