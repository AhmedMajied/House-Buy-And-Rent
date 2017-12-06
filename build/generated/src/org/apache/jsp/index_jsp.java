package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Models.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Log In</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/indexStyle.css\">\n");
      out.write("        <script src=\"js/jquery-3.1.1.min.js\"></script>\n");
      out.write("        <script src=\"js/loginJS.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        ");

            HttpSession currentSession=request.getSession(true);
            if(currentSession.getAttribute("User")!=null)
            {
                response.sendRedirect("jsp/Home.jsp");
            }
        
      out.write("\n");
      out.write("        <div id=\"login\">\n");
      out.write("            <form name=\"form-login\" id=\"formLogin\" action=\"/IA_Project/UserController?action=logIn\" method=\"post\">\n");
      out.write("                <span id=\"userIcon\"></span>\n");
      out.write("                <input id=\"user\" placeholder=\"Username\" name=\"name\" type=\"text\" required />\n");
      out.write("                <span id=\"lock\"></span>\n");
      out.write("                <input id=\"pass\" placeholder=\"Password\"name=\"password\" type=\"password\" required />\n");
      out.write("                <br>\n");
      out.write("                <div id=\"warning\"></div>\n");
      out.write("                <br>\n");
      out.write("                <input value=\"Login\" type=\"submit\" id=\"loginButton\">\n");
      out.write("                \n");
      out.write("                <center>\n");
      out.write("                    <label id=\"account\">do not have an account ?</label>\n");
      out.write("                        <a href=\"signup.html\" id=\"link\">create one</a>\n");
      out.write("                </center>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <!-- for testing-->\n");
      out.write("        <form action=\"AdvertisementController?action=AllAds\" method=\"POST\">\n");
      out.write("            <input type=\"submit\"/>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
