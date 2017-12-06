package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Models.User;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/headerStyle.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/profileStyle.css\">\n");
      out.write("        <script src=\"../js/jquery-3.1.1.min.js\"></script>\n");
      out.write("        <script src=\"../js/profileJs.js\"></script>\n");
      out.write("\n");
      out.write("        <title>User Profile</title>\n");
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
      out.write("        <header>\n");
      out.write("            <div id=\"navBar\">\n");
      out.write("                <a id=\"active\" href =\"Home.jsp\">Home</a>\n");
      out.write("                <a href=\"#\">My Advertisments</a>\n");
      out.write("                <a href=\"#\">About</a>\n");
      out.write("                <span id=\"search\"></span>\n");
      out.write("                <input type=\"text\"name=\"search\"id=\"searchText\" placeholder=\"search field\"/>\n");
      out.write("                <a href=\"#\"id=\"notification\"></a>\n");
      out.write("                <a href=\"#\"id=\"userName\">");
      out.print(user.getUsername());
      out.write("</a>\n");
      out.write("                <a href=\"profile.jsp\">MyProfile</a>\n");
      out.write("                <a href=\"../index.html\">LogOut</a>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <section>\n");
      out.write("            <br><br>\n");
      out.write("            <form action=\"/IA_Project/UserController?action=addPhoto\" method=\"POST\" enctype=\"mulipart/form-data\">\n");
      out.write("                ");
 if (user.getPicture()!=null)
                {
                    
                  String url = "data:image/png;base64," + Base64.encode(user.getPicture().getBytes(1,(int)user.getPicture().length())); 
      out.write("\n");
      out.write("                  <img src=\"");
      out.print(url);
      out.write("\"name=\"image\"id=\"userImage\">\n");
      out.write("                ");
} else{
      out.write("\n");
      out.write("                <img src=\"../images/userImage.png\" name=\"image\" id=\"userImage\">\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                <input type=\"file\" accept=\"image/*\" id=\"addPhoto\" name=\"photo\" onchange=\"loadFile(event)\">\n");
      out.write("                <input type=\"submit\" value=\"Save Photo\"id=\"savePhoto\">\n");
      out.write("            </form>\n");
      out.write("                \n");
      out.write("            ");
 if (user.getPicture()!=null)
            {
      out.write("\n");
      out.write("            <form action=\"/UserController?action=deletePhoto\"id=\"deleteImage\">\n");
      out.write("              <input type=\"submit\"value=\"Delete Image\"id=\"deletephoto\">\n");
      out.write("            </form>\n");
      out.write("              ");
}
      out.write("\n");
      out.write("              \n");
      out.write("                <br><br>\n");
      out.write("                <label id=\"userName\">");
      out.print(user.getUsername());
      out.write("</label>\n");
      out.write("                <br><br>\n");
      out.write("              \n");
      out.write("              <button id=\"addPhone\" onclick=\"displayPhone();\">Add/Change Phone</button>\n");
      out.write("              <fieldset id=\"Phone\">\n");
      out.write("                  <form action=\"/IA_Project/UserController?action=addPhone\" method=\"post\">\n");
      out.write("                        <span id=\"phone\"></span>\n");
      out.write("                        <input type=\"text\" pattern=\"^[0-9]+\" placeholder=\"Add Your Phone\" name=\"phoneNumber\" id=\"phoneNumber\">\n");
      out.write("                        <br><br>\n");
      out.write("                        <input type=\"submit\" id=\"submit\" value=\"add phone Number\"/> \n");
      out.write("                    </form>\n");
      out.write("              </fieldset>              \n");
      out.write("                ");
if(user.getPhone()!=null){
      out.write("\n");
      out.write("                <form id=\"deletePhone\" action=\"/IA_Project/UserController?action=deletePhone\" method=\"post\">\n");
      out.write("                    <br>\n");
      out.write("                    <input type=\"submit\" id=\"submit1\" value=\"Delete Phone\"/> \n");
      out.write("                </form>\n");
      out.write("              <br>\n");
      out.write("              ");
}
      out.write("\n");
      out.write("              \n");
      out.write("               <button id=\"changePassword\" onclick=\"displayFields();\">ChangePassword</button>\n");
      out.write("                <fieldset id=\"password\">\n");
      out.write("                    <form action=\"/IA_Project/UserController?action=changePassword\" method=\"post\"id=\"passwordForm\">\n");
      out.write("                          <span id='iPass'></span>\n");
      out.write("                          <input type=\"password\" required placeholder='old Password'name=\"oldPassword\" id=\"oPassword\"><br><br>\n");
      out.write("                          <span id='iPass'></span>\n");
      out.write("                          <input type=\"password\" required placeholder='new Password'name=\"newPassword\" id=\"nPassword\"><br><br>\n");
      out.write("                          <div id=\"valid\"></div>\n");
      out.write("                          <input type=\"submit\" id=\"submit\" value=\"change Password\"/> \n");
      out.write("                      </form>\n");
      out.write("                 </fieldset> \n");
      out.write("              \n");
      out.write("        </section>\n");
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
