package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Base64;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.Blob;
import Models.*;

public final class advertisement_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    ");
 Advertisement ad = (Advertisement)request.getAttribute("Advertisement"); 
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>");
      out.print(ad.getTitle());
      out.write("</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <iframe id=\"map\" src=\"https://www.google.com/maps/embed/v1/place?origin=");
      out.print(ad.getLatitude() );
      out.write(',');
      out.write(' ');
      out.print(ad.getLongitude() );
      out.write("&key=AIzaSyDknmD-bIczC5pP5WPolW9zsx8xA8Ty6Cw\"></iframe>\n");
      out.write("        <br/>\n");
      out.write("        ");
      out.print(ad.getTitle());
      out.write("\n");
      out.write("        <br/>\n");
      out.write("        ");
      out.print(ad.getAdType());
      out.write("\n");
      out.write("        <br/>\n");
      out.write("        ");
      out.print(ad.getDescription());
      out.write("\n");
      out.write("        <br/>\n");
      out.write("        Size: ");
      out.print(ad.getBuildingSize());
      out.write("\n");
      out.write("        <br/>\n");
      out.write("        Floor: ");
      out.print(ad.getBuildingFloor());
      out.write("\n");
      out.write("        <br/>\n");
      out.write("        Type: ");
      out.print(ad.getType().getName());
      out.write("\n");
      out.write("        <br/>\n");
      out.write("        Status: ");
      out.print(ad.getStatus().getName());
      out.write("\n");
      out.write("        <br/>\n");
      out.write("        ");
 
          for(Blob image : ad.getPhotos()){
            byte[] imgData = image.getBytes(1, (int)image.length());
            String code = Base64.getEncoder().encodeToString(imgData); 
        
      out.write("\n");
      out.write("            <img src=\"data:image/jpg;base64,");
      out.print(code);
      out.write("\" style=\"width:50px;height:50px\"/>\n");
      out.write("        ");
}
      out.write("\n");
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
