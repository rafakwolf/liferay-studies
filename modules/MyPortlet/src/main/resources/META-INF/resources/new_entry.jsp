<%@ include file="init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="addEntry" var="addEntryURL"/>

<jsp:useBean id="guestbooks" class="java.util.ArrayList" scope="request"/>

<aui:form action="<%= addEntryURL %>" name="<portlet:namespace />fm" method="POST">
    <aui:fieldset>

        <aui:select name="guestbookId" id="guestbookId">
            <c:forEach items="${guestbooks}" var="guestbook">
                <option value="${guestbook.guestbookId}"<c:if test="${guestbook.guestbookId == guesbookId}"> selected="selected"</c:if>>
                        ${guestbook.name}
                </option>
            </c:forEach>
        </aui:select>

        <aui:input name="name"/>
        <aui:input name="message"/>
        <aui:input name="email"/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button type="cancel" onClick="<%= viewURL %>"/>
    </aui:button-row>
</aui:form>