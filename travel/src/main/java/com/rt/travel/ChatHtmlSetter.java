package com.rt.travel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ChatHtmlSetter {
	String contentHtml;
	String menuListHtml;
	String menuTypeHtml;
	List<ChatRoomDTO> list_room;
	String content;
	String contentTime;
	String contentTime2;
	String[] contentTime_;
	
	@Autowired
	ChatDAO chatDAO;
	ChatContentDTO chatContentDTO;
	ChatRoomDTO chatRoomDTO;
	
	public String addContentHtml(ChatContentDTO chatContentDTO) {
//		chatContentDTO = chatDAO.selectRooms(member);
		contentHtml = "<h4>"+chatContentDTO.getMember()+"</h4><br>"
				+ "<span>"+chatContentDTO.getContent()+"</span>"
				+ "<span>"+"  시간"+"</span>";
		
		return contentHtml;
	}
	//chat의 몸체 가져오는 메소드
	public String getChat(String member) {
		
		return "<div id = \"chatDiv\" style = \"position : fixed; right : 30px; bottom : 30px;width : 345px; height : 500px;\">"
				+	"<div id = \"menuDiv\" style = \"padding-top : 35px;padding-left : 10px;padding-right : 10px;border :thin solid black; position : fixed;bottom : 30px; right : 310px; width : 45px; height : 465px;\">"
				+		"<img id = \'friend\' src=\'resources/img/friend.jpg\'>"
				+		"<img id = \'malpung\' src=\'resources/img/malpung.jpg\' style = \'margin-top : 20px;\'>"
				+	"</div>" 
				+	"<div id = \"contentListDiv\" style= \"border :thin solid black; position : fixed;right : 30px;bottom : 30px; width : 280px; height : 500px;\">"
				+		"<div id = \"menuType\" style=\"padding-top : 25px;padding-left : 10px;position : fixed;border :thin solid black; width:270px; height : 65px; right : 30px;\">"
				+			getMenuType("채팅")
				+		"</div>"
				+		"<div id = \"menuContent\" style=\"overflow : auto; position : fixed;border :thin solid black; width:280px; height : 410px; right : 30px;bottom : 30px;\">"
				+			getMenuContent(member)
				+		"</div>"
				+	"</div>" 
				+"</div>";
	}
	//chat의 menucontent가져오는 메소드
	public String getMenuContent(String member) {
		list_room = chatDAO.selectRooms(member);
		int divPositionVal = 335;
		int divHeight = 60;
		menuListHtml = "";
		for(int i=0;i<list_room.size();i++) {
			chatRoomDTO = list_room.get(i);
			chatContentDTO = chatDAO.getContent(chatRoomDTO.getchatRoomNum());
			content = "";
			contentTime = "";
			contentTime2 = "";
			if(chatContentDTO!=null) {
				contentTime_ = chatContentDTO.getContentTime().split(" ");
				contentTime = contentTime_[0];
				contentTime2 = contentTime_[1];
				contentTime_ = contentTime.split("-");
				contentTime = contentTime_[1]+"월"+contentTime_[2]+"일";
				contentTime_ = contentTime2.split(":");
				contentTime2 = contentTime_[0]+"시"+contentTime_[1]+"분";
				content = chatContentDTO.getContent();
			}
				menuListHtml+="<div class = \"rooms\" style=\"width : 263px; height : 60px;\">"
							+	"<div class=\'thumbnail\' style=\'position : absolute;padding : 5px;width : 55px; height : 50px; bottom : "+(divPositionVal-i*divHeight)+"px;\'>"
							+		"<img src=\'resources/img/"+chatRoomDTO.getThumbnail()+"\'>"
							+	"</div>"
							+	"<div class=\'roomName\' style=\'position : absolute;padding : 5px;width : 123px;bottom : "+(divPositionVal-i*divHeight)+"px; height : 50px;margin-left:65px;\'>"
							+		"<span style=\'font-size : 15px; font-weight : bold\'>"+chatRoomDTO.getchatRoomName()+"</span>"
							+		"<span style=\'font-size : 12px; margin-left : 10px;\'>"+chatRoomDTO.getLimitMember()+"</span><br>"
							+		"<span style=\'font-size : 14px; color : #666562;\'>"+content+"</span>"
							+	"</div>"
							+	"<div class=\'time\' style=\'position : absolute;padding : 5px;width : 55px; bottom : "+(divPositionVal-i*divHeight)+"px;height : 50px;margin-left:198px;\'>"
							+		"<span style=\'font-size : 10px; color:#b5b1a7;\'>"+contentTime+"</span><br>"
							+		"<span style=\'font-size : 10px; color:#b5b1a7;\'>"+contentTime2+"</span>"
							+	"</div>"
							+ "</div>";
		}
		return menuListHtml;
	}
	//chat의 menutype가져오는 메소드
	public String getMenuType(String menuType) {
		menuTypeHtml =  "<span style = \'font-size : 21px; font-weight : bold;\'>"+menuType+"</span><br>"
				+ 		"<input id=\'roomSearch\' type = \"text\" >";
		
		return menuTypeHtml;
	}
}
