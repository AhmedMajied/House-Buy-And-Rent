package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Models.*;
import java.util.Vector;

public final class AllAds_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/allAdsStyle.css\">\n");
      out.write("        <script src=\"../js/jquery-3.1.1.min.js\"></script>\n");
      out.write("        <script src=\"../js/allAdsJS.js\"></script>\n");
      out.write("        <title>All Ads</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

            Vector<Advertisement> AllAds = (Vector<Advertisement>) request.getAttribute("AllAds");
            int averageRate;
            int userRate = 0;
            String rateStatus = "new";
            
            //int currentuserID = ((User)session.getAttribute("User")).getID();
            
            for(int i=0;i<AllAds.size();i++){
                averageRate = 0;
                for(int rateIndex=0;rateIndex<AllAds.get(i).getRatings().size();rateIndex++){
                    averageRate += AllAds.get(i).getRatings().get(rateIndex).getValue();
                    /*if(currentUserID == AllAds.get(i).getRatings().get(rateIndex).getUserID()){
                        userRate = AllAds.get(i).getRatings().get(rateIndex).getValue();
                        rateStatus = "existing";
                    }*/
                }
                averageRate /= AllAds.get(i).getRatings().size();
                
      out.write("\n");
      out.write("                <label>\n");
      out.write("                    <b>");
      out.print( AllAds.get(i).getTitle());
      out.write("</b> ");
      out.print( AllAds.get(i).getAdType());
      out.write("\n");
      out.write("                    <b>Advertised By</b> userName \n");
      out.write("                    <!-- Users Ratings-->\n");
      out.write("                    <span class=\"heading\"> Users Ratings : </span>\n");
      out.write("                    <span class=\"fa fa-star\" id=\"");
      out.print( "star1"+"0"+AllAds.get(i).getID());
      out.write("\"></span>\n");
      out.write("                    <span class=\"fa fa-star\" id=\"");
      out.print( "star2"+"0"+AllAds.get(i).getID());
      out.write("\"></span>\n");
      out.write("                    <span class=\"fa fa-star\" id=\"");
      out.print( "star3"+"0"+AllAds.get(i).getID());
      out.write("\"></span>\n");
      out.write("                    <span class=\"fa fa-star\" id=\"");
      out.print( "star4"+"0"+AllAds.get(i).getID());
      out.write("\"></span>\n");
      out.write("                    <span class=\"fa fa-star\" id=\"");
      out.print( "star5"+"0"+AllAds.get(i).getID());
      out.write("\"></span>\n");
      out.write("                    <script>fillStaticStars(");
      out.print( averageRate);
      out.write(',');
      out.print( AllAds.get(i).getID());
      out.write(");</script>\n");
      out.write("                </label><br>\n");
      out.write("                <p>");
      out.print( AllAds.get(i).getDescription() );
      out.write("</p>\n");
      out.write("                <b>Size :</b> ");
      out.print( AllAds.get(i).getBuildingSize());
      out.write("<br>\n");
      out.write("                <b>Status :</b> ");
      out.print( AllAds.get(i).getStatus().getName());
      out.write("<br>\n");
      out.write("                <b>Type :</b> ");
      out.print( AllAds.get(i).getType().getName());
      out.write("<br>\n");
      out.write("                <button>Comments</button>\n");
      out.write("                <Button>View Photos</Button>\n");
      out.write("                \n");
      out.write("                <!-- User Rating -->\n");
      out.write("                <div>\n");
      out.write("                    <span class=\"heading\"> Your Rating : </span>\n");
      out.write("                    <span class=\"fa fa-star\" id=\"");
      out.print( "star1"+AllAds.get(i).getID());
      out.write("\" onclick=\"fillStars(1,");
      out.print( AllAds.get(i).getID());
      out.write(")\" onmouseover=\"shadeStars(1,");
      out.print( AllAds.get(i).getID());
      out.write(")\" onmouseout=\"unShadeStars(1,");
      out.print( AllAds.get(i).getID());
      out.write(")\"></span>\n");
      out.write("                    <span class=\"fa fa-star\" id=\"");
      out.print( "star2"+AllAds.get(i).getID());
      out.write("\" onclick=\"fillStars(2,");
      out.print( AllAds.get(i).getID());
      out.write(")\" onmouseover=\"shadeStars(2,");
      out.print( AllAds.get(i).getID());
      out.write(")\" onmouseout=\"unShadeStars(2,");
      out.print( AllAds.get(i).getID());
      out.write(")\"></span>\n");
      out.write("                    <span class=\"fa fa-star\" id=\"");
      out.print( "star3"+AllAds.get(i).getID());
      out.write("\" onclick=\"fillStars(3,");
      out.print( AllAds.get(i).getID());
      out.write(")\" onmouseover=\"shadeStars(3,");
      out.print( AllAds.get(i).getID());
      out.write(")\" onmouseout=\"unShadeStars(3,");
      out.print( AllAds.get(i).getID());
      out.write(")\"></span>\n");
      out.write("                    <span class=\"fa fa-star\" id=\"");
      out.print( "star4"+AllAds.get(i).getID());
      out.write("\" onclick=\"fillStars(4,");
      out.print( AllAds.get(i).getID());
      out.write(")\" onmouseover=\"shadeStars(4,");
      out.print( AllAds.get(i).getID());
      out.write(")\" onmouseout=\"unShadeStars(4,");
      out.print( AllAds.get(i).getID());
      out.write(")\"></span>\n");
      out.write("                    <span class=\"fa fa-star\" id=\"");
      out.print( "star5"+AllAds.get(i).getID());
      out.write("\" onclick=\"fillStars(5,");
      out.print( AllAds.get(i).getID());
      out.write(")\" onmouseover=\"shadeStars(5,");
      out.print( AllAds.get(i).getID());
      out.write(")\" onmouseout=\"unShadeStars(5,");
      out.print( AllAds.get(i).getID());
      out.write(")\"></span>\n");
      out.write("                </div>\n");
      out.write("                <hr>\n");
      out.write("                ");

            }
        
      out.write("                \n");
      out.write("        <script>saveUserRate(1,1,\"new\");</script>\n");
      out.write("    </body>\n");
      out.write("    \n");
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
