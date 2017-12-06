package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Models.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Sign Up</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/signUpStyle.css\">\n");
      out.write("        <script src=\"../js/jquery-3.1.1.min.js\"></script>\n");
      out.write("        <script src=\"../js/signupJS.js\"></script>\n");
      out.write("        <script src='https://www.google.com/recaptcha/api.js'></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            HttpSession currentSession=request.getSession(true);
            User user=new User();
            if(currentSession.getAttribute("User")!=null)
            {
                user=(User)currentSession.getAttribute("User");
            }
            else
            {
                response.sendRedirect("Home.jsp");
            }
        
      out.write("\n");
      out.write("        <div id=\"signUp\">\n");
      out.write("            <form name=\"form-signUp\" id=\"formSignup\" action=\"UserController?action=addNewUser\" method=\"post\">\n");
      out.write("                <div class=\"message\">Sign Up</div>\n");
      out.write("                <br>\n");
      out.write("                <span id=\"userIcon\"></span>\n");
      out.write("                <input id=\"user\" placeholder=\"Username *\" name=\"name\" type=\"text\" required pattern=\"^[a-zA-Z].{3,}$\" title=\"name has at least 3 lettes & name contains only letters\">\n");
      out.write("                <div id=\"userWarn\"></div>\n");
      out.write("                                \n");
      out.write("                <span id=\"lock\"></span>\n");
      out.write("                <input id=\"pass\" placeholder=\"Password *\" name=\"password\" type=\"password\" pattern=\".{4,}\" required title=\"password must be atleast 4 symbols\">\n");
      out.write("                \n");
      out.write("                <span id=\"lock\"></span>\n");
      out.write("                <input id=\"cPass\" placeholder=\"confirm Password *\" type=\"password\"  pattern=\".{4,}\" required title=\"password must be atleast 4 symbols\">\n");
      out.write("                \n");
      out.write("                <div id=\"passWarn\"></div>\n");
      out.write("                \n");
      out.write("                <span id=\"phone\"></span>\n");
      out.write("                <input id=\"phoneNumber\" placeholder=\"PhoneNumber\" name=\"phone\" type=\"text\" pattern=\"^[0-9]+\" title=\"phone number\">\n");
      out.write("                <br>\n");
      out.write("                <center><div\n");
      out.write("                    class=\"g-recaptcha\"\n");
      out.write("                    data-sitekey=\"6LdRWTkUAAAAAMK20VualcTI0UHCU20PMOYy62e0\" \n");
      out.write("                    data-callback=\"validateCaptcha\">\n");
      out.write("                    </div>\n");
      out.write("                </center>\n");
      out.write("                \n");
      out.write("                <input value=\"Sign Up\" type=\"submit\" id=\"signUpButton\">\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
