<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleCompteProxyid" scope="session" class="fr.uge.sw.banque.CompteProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleCompteProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
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
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
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
%>
<%=getCompte10mtemp %>
<%
}else{
        if(getCompte10mtemp!= null){
        String tempreturnp11 = getCompte10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        int valeurDuSolde13mtemp = sampleCompteProxyid.valeurDuSolde();
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(valeurDuSolde13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
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
        %>
        <%= tempResultreturnp22 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>