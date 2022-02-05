package com.simplilearn.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.dao.ClassRoomDao;
import com.simplilearn.entity.ClassRoom;

public class ClassRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassRoomDao classRoomDao;

	public ClassRoomServlet() {
		super();
	}

	public void init() {
		classRoomDao = new ClassRoomDao();
	}

	private ClassRoom getClassRoom(HttpServletRequest request, HttpServletResponse response) {
		String classRoomId = request.getParameter("id");
		ClassRoom classRoom = classRoomDao.getClassRoom(Integer.parseInt(classRoomId));
		return classRoom;
	}

	private List<ClassRoom> getClassRooms(HttpServletRequest request, HttpServletResponse response) {
		List<ClassRoom> classRooms = classRoomDao.getAllClassRooms();
		try {
			HttpSession session = request.getSession();
			session.setAttribute("classRooms", classRooms);
			RequestDispatcher dispatcher = request.getRequestDispatcher("pages/list-classRooms.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classRooms;
	}

	private ClassRoom createClassRoom(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("classRoomName");

		ClassRoom classRoomModel = new ClassRoom(name);
		ClassRoom newClassRoom = classRoomDao.saveClassRoom(classRoomModel);
		getClassRooms(request, response);
		return newClassRoom;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch (action) {

			case "new":
				createClassRoom(request, response);
				break;

			case "list":
				getClassRooms(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
