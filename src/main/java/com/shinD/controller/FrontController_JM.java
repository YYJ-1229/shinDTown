package com.shinD.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinD.controller.board.BoardCreate;
import com.shinD.controller.board.BoardDelete;
import com.shinD.controller.board.BoardDetail;
import com.shinD.controller.board.BoardDupCheck;
import com.shinD.controller.board.BoardMain;
import com.shinD.controller.board.BoardRead;
import com.shinD.controller.comment.ComCode;
import com.shinD.controller.comment.CommentCheck;
import com.shinD.controller.comment.CommentCreate;
import com.shinD.controller.comment.CommentDelete;
import com.shinD.controller.comment.CommentLikes;
import com.shinD.controller.comment.CommentList;
import com.shinD.controller.comment.DeleteLike;
import com.shinD.controller.plan.CreatePlan;
import com.shinD.controller.plan.DeletePlan;
import com.shinD.controller.plan.DetailPlan;
import com.shinD.controller.plan.ReadPlan;
import com.shinD.controller.post.PostCreate;
import com.shinD.controller.post.PostLike;


@WebServlet("*.jm")
public class FrontController_JM extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		CommonControllerInterface controller = null;
		Map<String, Object> data = new HashMap<>();
		data.put("method", request.getMethod());
		data.put("request", request);
		data.put("response", response);

		System.out.println(path);
		switch (path) {
		// 보드 생성 컨트롤
		case "/board/main.jm":
			controller = new BoardMain();
			break;

			// 보드 생성 컨트롤
		case "/board/create.jm":
			controller = new BoardCreate();
			break;

		// 보드 목록 컨트롤
		case "/board/read.jm":
			controller = new BoardRead();
			break;

		// 보드 삭제 컨트롤
		case "/board/delete.jm":
			controller = new BoardDelete();
			break;

		// 보드 중복 체크
		case "/board/dupcheck.jm":
			controller = new BoardDupCheck();
			break;

		// 보드 디테일
		case "/board/detail.jm":
			controller = new BoardDetail();
			break;

		// 게시글 생성
		case "/post/create.jm":
			controller = new PostCreate();
			break;

		// 게시글 조와요
		case "/post/like.jm":
			controller = new PostLike();
			break;
			
		// 댓글 생성
		case "/comment/create.jm":
			controller = new CommentCreate();
			break;

		// 댓글 생성
		case "/comment/list.jm":
			System.out.println("------------");
			controller = new CommentList();
			break;

		
			
		default:
			break;
		}

		String page = null;
		try {
			page = controller.execute(data);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (page.indexOf("redirect:") >= 0) {
			response.sendRedirect(page.substring(9));
		} else if (page.indexOf("responseBody:") >= 0) {
			response.getWriter().append(page.substring(13));
			System.out.println("여기왓다감");
		} else if (page.indexOf("download") >= 0) {
		} else {
			RequestDispatcher rd;
			rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}

	}

}
