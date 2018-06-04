<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.taglib.search.ResultRow" %>
<%@ page import="guestbook.model.Entry" %>
<%
    ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    Entry img=(Entry)rslt.getObject();
    String prk=String.valueOf(img.getPrimaryKey());
%>

<liferay-ui:icon-menu>

    <portlet:actionURL name="editEntry" var="editURL">
        <portlet:param name="key" value="<%=prk%>" />
    </portlet:actionURL>

    <liferay-ui:icon image="edit" message="Edit" url="<%=editURL%>" />

    <portlet:actionURL name="removeEntry" var="deleteURL">
        <portlet:param name="key" value="<%= prk %>" />
    </portlet:actionURL>

    <liferay-ui:icon image="delete" message="Delete" url="<%=deleteURL%>" />

</liferay-ui:icon-menu>