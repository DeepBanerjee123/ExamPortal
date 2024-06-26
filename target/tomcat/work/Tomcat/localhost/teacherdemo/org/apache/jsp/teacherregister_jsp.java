/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-05-05 11:29:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class teacherregister_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Animated Sign-Up Form</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Poppins:600&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <script src=\"https://kit.fontawesome.com/a81368914c.js\"></script>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <img class=\"wave\" src=\"img/wave.png\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"img\">\r\n");
      out.write("            <img src=\"img/bg.svg\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"login-content\">\r\n");
      out.write("            <form action=\"teacherregister\" method = \"post\">\r\n");
      out.write("                <img src=\"img/avatar.svg\">\r\n");
      out.write("                <h2 class=\"title\" style=\"font-size: 24px;\">Teacher Sign Up</h2>\r\n");
      out.write("                <div class=\"input-div one\">\r\n");
      out.write("                    <div class=\"i\">\r\n");
      out.write("                        <i class=\"fas fa-user\"></i>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"div\">\r\n");
      out.write("                        <h5>Username</h5>\r\n");
      out.write("                        <input type=\"text\" class=\"input\" name=\"name\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"input-div one\">\r\n");
      out.write("                    <div class=\"i\">\r\n");
      out.write("                        <i class=\"fas fa-envelope\"></i> \r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"div\">\r\n");
      out.write("                        <h5>Email</h5> \r\n");
      out.write("                        <input type=\"email\" class=\"input\" name=\"email\"> \r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"input-div pass\">\r\n");
      out.write("                    <div class=\"i\"> \r\n");
      out.write("                        <i class=\"fas fa-lock\"></i>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"div\">\r\n");
      out.write("                        <h5>Password</h5>\r\n");
      out.write("                        <input type=\"password\" class=\"input\" name=\"pass\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <input type=\"submit\" class=\"btn\" value=\"Sign Up\">\r\n");
      out.write("                <a href=\"teacherlogin.jsp\" id=\"forgot_pswd\">Already have an account? Sign In</a><br/>\r\n");
      out.write("               // <h5 style=\"color:red; text-align: center;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ermsg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h5>\r\n");
      out.write("            </form>\r\n");
      out.write("\t\t\t    ");

        			String status = (String) request.getAttribute("status");
    			
      out.write("\r\n");
      out.write("    \t\t\t<input type=\"hidden\" id=\"status\" value=\"");
      out.print( status );
      out.write("\">\r\n");
      out.write("            \r\n");
      out.write("                <script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\r\n");
      out.write("\t\t\t\t    <link rel=\"stylesheet\" href=\"alert/dist/sweetalert.css\">\r\n");
      out.write("\t\t\t\t    \r\n");
      out.write("\t\t\t\t       <script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t\t\t    let status = document.getElementById(\"status\").value;\r\n");
      out.write("\t\t\t\t\t\t    if (status == \"success\") {\r\n");
      out.write("\t\t\t\t\t\t        swal(\"Congrats\", \"Account created\", \"success\").then(() => {\r\n");
      out.write("\t\t\t\t            window.location.href = \"teacherlogin.jsp\";\r\n");
      out.write("\t\t\t\t        });\r\n");
      out.write("\t\t\t\t }\r\n");
      out.write("\t  \t\t</script>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/main.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
