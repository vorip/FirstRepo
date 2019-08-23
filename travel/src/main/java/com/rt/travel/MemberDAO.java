package com.rt.travel;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public List<FriendDTO> friendList(String name){
		return mybatis.selectList("memberDAO.friendList",name);
	}
	public void addFriend(FriendDTO friendDTO) {
		mybatis.insert("memberDAO.addFriend",friendDTO);
	}
	public void deleteFriend(FriendDTO friendDTO) {
		mybatis.delete("memberDAO.deleteFriend",friendDTO);
	}
}
