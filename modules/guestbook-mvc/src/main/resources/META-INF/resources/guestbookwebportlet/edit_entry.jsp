<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ include file="../init.jsp" %>

<%

    long entryId = ParamUtil.getLong(renderRequest, "entryId");

    Entry entry = null;
    if (entryId > 0) {
        try {
            entry = EntryLocalServiceUtil.getEntry(entryId);
        } catch (PortalException e) {
            e.printStackTrace();
        }
    }

    long guestbookId = ParamUtil.getLong(renderRequest, "guestbookId");

%>

<portlet:renderURL var="viewURL">

    <portlet:param name="mvcPath" value="/guestbookwebportlet/view.jsp"/>

</portlet:renderURL>

<portlet:actionURL name="addEntry" var="addEntryURL"/>

<aui:form action="<%= addEntryURL %>" name="<portlet:namespace />fm">

    <aui:model-context bean="<%= entry %>" model="<%= Entry.class %>" />

    <aui:fieldset>

        <aui:input name="name" >
            <aui:validator name="required" />
        </aui:input>

        <aui:input name="email" />
        <aui:input name="message" />

        <aui:input name="entryId" type="hidden" />
        <aui:input name="guestbookId" type="hidden" value='<%= entry == null ? guestbookId : entry.getGuestbookId() %>'/>

    </aui:fieldset>

    <aui:button-row>

        <aui:button type="submit"/>
        <aui:button type="cancel" onClick="<%= viewURL %>"/>

    </aui:button-row>
</aui:form>