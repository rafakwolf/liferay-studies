<%@ include file="./init.jsp" %>

<portlet:renderURL var="addEntryURL">
    <portlet:param name="mvcPath" value="/new_entry.jsp"/>
</portlet:renderURL>

<portlet:actionURL var="searchUrl" name ="search" />

<aui:form action="<%=searchUrl%>" method="post" >
    <aui:input type="text" label="Search by name" name="name" value="" />
    <aui:button type="submit" value="Search" />
</aui:form>

<jsp:useBean id="entries" class="java.util.ArrayList" scope="request"/>

<liferay-ui:search-container>
    <liferay-ui:search-container-results results="<%= entries %>"/>

    <liferay-ui:search-container-row className="guestbook.model.Entry" modelVar="entry">
        <liferay-ui:search-container-column-text property="message"/>

        <liferay-ui:search-container-column-text property="name"/>

        <liferay-ui:search-container-column-jsp path="/gridButtons.jsp" align="right"/>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>
</liferay-ui:search-container>


<aui:button-row>
    <aui:button value="Add Entry" onClick="<%= addEntryURL %>"/>
</aui:button-row>