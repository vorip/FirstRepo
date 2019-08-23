package com.rt.travel;

import org.springframework.beans.factory.annotation.Autowired;

public class ChatService implements ChatInterface{
	
	@Autowired
	ChatDAO chatDAO;
	@Autowired
	ChatHtmlSetter html;

	@Override
	public String addContent(ChatContentDTO chatContentDTO) {
		chatDAO.addContent(chatContentDTO);
		return html.addContentHtml(chatContentDTO);
	}

	@Override
	public String createChatRoom(ChatRoomDTO chatRoomDTO) {
		chatDAO.createRoom(chatRoomDTO);
		return "";
	}
	

}
