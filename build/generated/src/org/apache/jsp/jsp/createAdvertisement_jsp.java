package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import Models.*;

public final class createAdvertisement_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("\t\t<title>Create Advertisement</title>\n");
      out.write("                <link rel=\"stylesheet\" href=\"../css/createAdvertisement.css\"/>\n");
      out.write("                <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDknmD-bIczC5pP5WPolW9zsx8xA8Ty6Cw\"></script>\n");
      out.write("                <script src=\"../js/jquery-3.1.1.min.js\"></script>\n");
      out.write("                <script src=\"../js/Map.js\"></script>\n");
      out.write("\t</head>\n");
      out.write("<body>\n");
      out.write("\t<form action=\"AdvertisementController?action=addAdvertisement\" method=\"POST\">\n");
      out.write("\t\t<label>Title</label>\n");
      out.write("\t\t<input type=\"text\" name=\"Title\" />\n");
      out.write("                <br/>\n");
      out.write("                <label>Advertisement Type</label>\n");
      out.write("                <select name=\"AdType\">\n");
      out.write("                    <option value=\"Rent\" >Rent</option>\n");
      out.write("                    <option value=\"Sale\" >Sale</option>\n");
      out.write("                </select>\n");
      out.write("                <br/>\n");
      out.write("\t\t<label>Size</label>\n");
      out.write("\t\t<input type=\"number\" name=\"Size\" />\n");
      out.write("                 <br/>\n");
      out.write("\n");
      out.write("\t\t<label>Floor</label>\n");
      out.write("\t\t<input type=\"number\" name=\"Floor\" />\n");
      out.write("\t\t<br/>\n");
      out.write("\t\t<label>Building Status</label>\n");
      out.write("\t\t<select name=\"Status\">\n");
      out.write("\t\t\t");

				Vector<BuildingStatus> statuses = (Vector)request.getAttribute("Statuses");
				for(BuildingStatus status : statuses){
			
      out.write("\n");
      out.write("\t\t\t<option value=\"");
      out.print(status.getID());
      out.write('"');
      out.write('>');
      out.print(status.getName() );
      out.write("</option>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t");
	}
			
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t</select>\n");
      out.write("\t\t<br/>\n");
      out.write("\t\t\n");
      out.write("\t\t<label>Building Type</label>\n");
      out.write("\t\t<select name=\"Type\">\n");
      out.write("\t\t\t");

				Vector<BuildingType> types = (Vector)request.getAttribute("Types");
				for(BuildingType type : types){
			
      out.write("\n");
      out.write("\t\t\t<option value=\"");
      out.print(type.getID());
      out.write('"');
      out.write('>');
      out.print(type.getName() );
      out.write("</option>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t");
	}
			
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t</select>\n");
      out.write("\t\t<br/>\n");
      out.write("\t\t<label>Description</label>\n");
      out.write("                <br/>\n");
      out.write("\t\t<textarea name=\"Description\"></textarea>\n");
      out.write("                <br/>\n");
      out.write("                <label>Location</label>\n");
      out.write("                <br/>\n");
      out.write("                <div class=\"adMap\">\n");
      out.write("                    <div class=\"map\" style=\"width:500px;height:200px;\">\n");
      out.write("                    </div>\n");
      out.write("                <input type=\"hidden\" name=\"Latitude\"   class=\"locationLat\"/>\n");
      out.write("\t\t<input type=\"hidden\" name=\"Longitude\"  class=\"locationLng\"/>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\t\t<br/>\n");
      out.write("                <input type=\"submit\" value=\"Add\"/>\n");
      out.write("\t</form>\n");
      out.write("                        \n");
      out.write("</body>\n");
      out.write("</html>");
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
