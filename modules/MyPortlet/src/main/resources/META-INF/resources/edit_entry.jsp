<%@ include file="init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>

<jsp:useBean id="edit" type="guestbook.model.Entry" scope="request" />

<portlet:actionURL name="updateEntry" var="updateEntryURL"/>

<aui:form action="<%=updateEntryURL%>" method="post">

    <aui:input name= "key" value="<%=edit.getPrimaryKey() %>" type="hidden" />

    <aui:input name="name" value="<%=edit.getName()%>" />
    <aui:input name="message" value="<%=edit.getMessage()%>" />

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button type="cancel" onClick="<%= viewURL %>"/>
    </aui:button-row>

</aui:form>