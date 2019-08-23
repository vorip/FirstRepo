package com.rt.travel;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class ChatDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	//채팅방관련 DB처리
	public void createRoom(ChatRoomDTO chatRoomDTO) {
		mybatis.insert("chatDAO.createRoom",chatRoomDTO);
	}
	public void reNameRoom(ChatRoomDTO chatRoomDTO) {
		mybatis.update("chatDAO.reNameRoom", chatRoomDTO);
	}
	public List<ChatRoomDTO> selectRooms(String member) {
		return mybatis.selectList("chatDAO.selectRooms","%" + member + "%");
	}
	public void deleteRoom(int talkRoomNum) {
		mybatis.delete("chatDAO.deleteRoom", talkRoomNum);
	}
	//채팅내용관련 DB처리
	public void addContent(ChatContentDTO chatContentDTO) {
		mybatis.insert("chatDAO.addContent", chatContentDTO);
	}
	public ChatContentDTO getContent(int chatRoomNum) {
		return mybatis.selectOne("chatDAO.getContent",chatRoomNum);
	}
	public List<ChatContentDTO> getContents() {
		return mybatis.selectList("chatDAO.getContents");
	}
	public void deleteContent(String member) {
		mybatis.delete("chatDAO.deleteContent", member);
	}
}
