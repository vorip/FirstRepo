package com.rt.travel;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
	
	@Autowired
	ChatInterface chat;
	@Autowired
	ChatHtmlSetter html;
	
	@RequestMapping("main")
	public void main(Model model,HttpSession session) {
		model.addAttribute("getChat",html.getChat((String)session.getAttribute("name")));
	}
	@RequestMapping("addContent")
	public String addContent(ChatContentDTO chatContentDTO,Model model) {
		model.addAttribute("result",chat.addContent(chatContentDTO));
		return "ajax/ajaxResult";
	}
	
}
