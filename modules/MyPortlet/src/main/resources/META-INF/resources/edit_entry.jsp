<%@ include file="init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>

<jsp:useBean id="edit" type="guestbook.model.Entry" scope="request"/>
<jsp:useBean id="guestbooks" class="java.util.ArrayList" scope="request"/>

<portlet:actionURL name="updateEntry" var="updateEntryURL"/>

<aui:form action="<%=updateEntryURL%>" method="post">

    <aui:input name="key" value="<%=edit.getPrimaryKey() %>" type="hidden"/>

    <aui:select name="guestbookId" id="guestbookId">
        <c:forEach items="${guestbooks}" var="guestbook">
            <option value="${guestbook.guestbookId}"<c:if test="${guestbook.guestbookId == guestbookId}"> selected="selected"</c:if>>
                    ${guestbook.name}
            </option>
        </c:forEach>
    </aui:select>

    <aui:input name="name" value="<%=edit.getName()%>"/>
    <aui:input name="message" value="<%=edit.getMessage()%>"/>
    <aui:input name="email" value="<%=edit.getEmail()%>"/>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button type="cancel" onClick="<%= viewURL %>"/>
    </aui:button-row>

</aui:form>