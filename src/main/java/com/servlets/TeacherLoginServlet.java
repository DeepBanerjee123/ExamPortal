package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TeacherDao;
import com.model.Teacher;

@WebServlet("/teacherlogin")
public class TeacherLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        Teacher authenticatedTeacher = TeacherDao.authenticateTeacher(email, password);

        if (authenticatedTeacher != null) {
    
            HttpSession session = request.getSession();
            session.setAttribute("teacherName", authenticatedTeacher.getTeacherName());
            session.setAttribute("teacherId", authenticatedTeacher.getTeacherId());

            response.sendRedirect("teacherDashboard.jsp");
        }
         else {
            
            request.setAttribute("status", "failed");
            request.getRequestDispatcher("teacherlogin.jsp").forward(request, response);
        }
    }
}

