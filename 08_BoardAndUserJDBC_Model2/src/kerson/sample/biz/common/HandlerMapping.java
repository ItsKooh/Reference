package kerson.sample.biz.common;

import java.util.HashMap;
import java.util.Map;

import kerson.sample.view.board.DeleteBoardController;
import kerson.sample.view.board.GetBoardController;
import kerson.sample.view.board.GetBoardListController;
import kerson.sample.view.board.InsertBoardController;
import kerson.sample.view.board.UpdateBoardController;
import kerson.sample.view.user.LoginController;

import org.springframework.web.servlet.mvc.Controller;

public class HandlerMapping {

	private Map<String, Controller> mapping = new HashMap<String, Controller>();
	
	public HandlerMapping() {
		mapping.put("/getBoardList.do", new GetBoardListController());   
		mapping.put("/getBoard.do"	  , new GetBoardController());
		mapping.put("/insertBoard.do" , new InsertBoardController());
		mapping.put("/updateBoard.do" , new UpdateBoardController());
		mapping.put("/deleteBoard.do" , new DeleteBoardController());
		mapping.put("/login.do"		  , new LoginController());  
	}

	
	public Controller getController(String path) { 
		return mapping.get(path);
	}
}
