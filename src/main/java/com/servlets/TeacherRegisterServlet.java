package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TeacherDao;
import com.model.Teacher;

@WebServlet("/teacherregister")
public class TeacherRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");

       
        Teacher teacher = new Teacher(name, password, email);

      
        boolean success = TeacherDao.insertTeacher(teacher);

        if (success) {
           
            request.setAttribute("status", "success");
            request.getRequestDispatcher("teacherregister.jsp").forward(request, response);
        } else {
            
            request.setAttribute("ermsg", "Registration failed");
            request.getRequestDispatcher("teacherregister.jsp").forward(request, response);
        }
    }
}

