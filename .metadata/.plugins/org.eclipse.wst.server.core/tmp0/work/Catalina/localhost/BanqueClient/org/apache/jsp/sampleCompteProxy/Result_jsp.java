/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-11-30 16:04:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.sampleCompteProxy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Result_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
 request.setCharacterEncoding("UTF-8"); 
      out.write("\n");
      out.write("<HTML>\n");
      out.write("<HEAD>\n");
      out.write("<TITLE>Result</TITLE>\n");
      out.write("</HEAD>\n");
      out.write("<BODY>\n");
      out.write("<H1>Result</H1>\n");
      out.write("\n");
      fr.uge.sw.banque.CompteProxy sampleCompteProxyid = null;
      synchronized (session) {
        sampleCompteProxyid = (fr.uge.sw.banque.CompteProxy) _jspx_page_context.getAttribute("sampleCompteProxyid", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (sampleCompteProxyid == null){
          sampleCompteProxyid = new fr.uge.sw.banque.CompteProxy();
          _jspx_page_context.setAttribute("sampleCompteProxyid", sampleCompteProxyid, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');

if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleCompteProxyid.setEndpoint(request.getParameter("endpoint"));

      out.write('\n');
      out.write('\n');

String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleCompteProxyid.getEndpoint();
if(getEndpoint2mtemp == null){

      out.write('\n');
      out.print(getEndpoint2mtemp );
      out.write('\n');

}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        
      out.write("\n");
      out.write("        ");
      out.print( tempResultreturnp3 );
      out.write("\n");
      out.write("        ");

}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleCompteProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        fr.uge.sw.banque.Compte getCompte10mtemp = sampleCompteProxyid.getCompte();
if(getCompte10mtemp == null){

      out.write('\n');
      out.print(getCompte10mtemp );
      out.write('\n');

}else{
        if(getCompte10mtemp!= null){
        String tempreturnp11 = getCompte10mtemp.toString();
        
      out.write("\n");
      out.write("        ");
      out.print(tempreturnp11);
      out.write("\n");
      out.write("        ");

        }}
break;
case 13:
        gotMethod = true;
        int valeurDuSolde13mtemp = sampleCompteProxyid.valeurDuSolde();
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(valeurDuSolde13mtemp));
        
      out.write("\n");
      out.write("        ");
      out.print( tempResultreturnp14 );
      out.write("\n");
      out.write("        ");

break;
case 16:
        gotMethod = true;
        String depot_1id=  request.getParameter("depot19");
        int depot_1idTemp  = Integer.parseInt(depot_1id);
        sampleCompteProxyid.depotDe(depot_1idTemp);
break;
case 21:
        gotMethod = true;
        String retrait_2id=  request.getParameter("retrait24");
        int retrait_2idTemp  = Integer.parseInt(retrait_2id);
        boolean retraitDe21mtemp = sampleCompteProxyid.retraitDe(retrait_2idTemp);
        String tempResultreturnp22 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(retraitDe21mtemp));
        
      out.write("\n");
      out.write("        ");
      out.print( tempResultreturnp22 );
      out.write("\n");
      out.write("        ");

break;
}
} catch (Exception e) { 

      out.write("\n");
      out.write("Exception: ");
      out.print( org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) );
      out.write("\n");
      out.write("Message: ");
      out.print( org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) );
      out.write('\n');

return;
}
if(!gotMethod){

      out.write("\n");
      out.write("result: N/A\n");

}

      out.write("\n");
      out.write("</BODY>\n");
      out.write("</HTML>");
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
