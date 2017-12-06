package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Models.*;
import java.util.Vector;
import Controllers.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/bootstrap.min.css\">\n");
      out.write("        <script src=\"../js/jquery-3.1.1.min.js\"></script>\n");
      out.write("        <script src=\"../js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/headerStyle.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/homeStyle.css\">\n");
      out.write("        <title>Home</title>\n");
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
                response.sendRedirect("/IA_Project/");
            }
        
      out.write("\n");
      out.write("        ");

            Vector<BuildingStatus> statuses = (Vector<BuildingStatus>)request.getAttribute("Statuses");
            Vector<BuildingType> types = (Vector<BuildingType>)request.getAttribute("Types");
        
      out.write("\n");
      out.write("        \n");
      out.write("       <header>\n");
      out.write("            <div id=\"navBar\">\n");
      out.write("                <a id=\"active\" href =\"Home.jsp\">Home</a>\n");
      out.write("                <a href=\"#\">My Advertisments</a>\n");
      out.write("                <a href=\"#\">About</a>\n");
      out.write("                <span id=\"search\"></span>\n");
      out.write("                <input type=\"text\"name=\"search\"id=\"searchText\" placeholder=\"search field\"/>\n");
      out.write("                <a href=\"#\"id=\"notification\"></a>\n");
      out.write("                <a href=\"#\">");
      out.print(user.getUsername());
      out.write("</a>\n");
      out.write("                <a href=\"profile.jsp\">MyProfile</a>\n");
      out.write("                <a href=\"../index.html\">LogOut</a>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        \n");
      out.write("        <!-- add interest button -->\n");
      out.write("        <button type=\"button\" class=\"btn btn-info btn-lg\" data-toggle=\"modal\" \n");
      out.write("                data-target=\"#InterestModal\">Add Interest</button>\n");
      out.write("\n");
      out.write("        <!-- Interest Modal -->\n");
      out.write("        <div id=\"InterestModal\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("          <div class=\"modal-dialog\">\n");
      out.write("\n");
      out.write("            <!-- Modal content-->\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("              <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                <center><h4 class=\"modal-title\">Add Interest</h4></center>\n");
      out.write("              </div>\n");
      out.write("                <form action=\"../UserController?action=adInterest\" method=\"POST\">\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("\n");
      out.write("                    <center>\n");
      out.write("                      <label>Size</label><br><br>\n");
      out.write("                      <input type=\"number\" name=\"size\" min=\"70\" value=\"70\"/><br><br>\n");
      out.write("\n");
      out.write("                      <label>Status</label><br><br>\n");
      out.write("                      <select name=\"status\" value=\"0\">\n");
      out.write("                          ");

                              for(int i=0;i<statuses.size();i++){
                                  
      out.write("\n");
      out.write("                                  <option value=");
      out.print( i);
      out.write('>');
      out.print( statuses.get(i).getName());
      out.write("</option>\n");
      out.write("                                  ");

                              }
                          
      out.write("\n");
      out.write("                      </select><br><br>\n");
      out.write("\n");
      out.write("                      <label>Type</label><br><br>\n");
      out.write("                      <select name=\"type\" value=\"0\">\n");
      out.write("                          ");
 
                              for(int i=0;i<types.size();i++){
                                  
      out.write("\n");
      out.write("                                  <option value=");
      out.print( i);
      out.write('>');
      out.print( types.get(i).getName());
      out.write("</option>\n");
      out.write("                                  ");

                              }
                          
      out.write("\n");
      out.write("                      </select>\n");
      out.write("                  </center>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <center>\n");
      out.write("                        <input type=\"submit\" class=\"btn btn-default\" value=\"Save\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    </center>\n");
      out.write("                </div>\n");
      out.write("              </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
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
