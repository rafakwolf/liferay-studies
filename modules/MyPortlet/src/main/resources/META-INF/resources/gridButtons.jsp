<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.taglib.search.ResultRow" %>
<%@ page import="guestbook.model.Entry" %>

<%
    ResultRow result = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    Entry entry = (Entry) result.getObject();
    String primaryKey = String.valueOf(entry.getPrimaryKey());
    String deleteConfirm = "javascript:confirmDel()";
%>

<portlet:actionURL name="editEntry" var="editURL">
    <portlet:param name="key" value="<%=primaryKey%>"/>
</portlet:actionURL>

<portlet:actionURL name="removeEntry" var="deleteURL">
    <portlet:param name="key" value="<%= primaryKey %>"/>
</portlet:actionURL>

<liferay-ui:icon-menu>

    <liferay-ui:icon image="edit" message="Edit" url="<%=editURL%>"/>
    <liferay-ui:icon image="delete" message="Delete" url="<%=deleteConfirm%>"/>

</liferay-ui:icon-menu>

<script type="text/javascript">
    function confirmDel() {
        YUI().use(
            'aui-modal',
            (Y) => {
                var modal = new Y.Modal(
                    {
                        bodyContent: 'Are you sure you want to delete this?',
                        centered: true,
                        headerContent: 'Deleting entry',
                        render: '#modal',
                        zIndex: 999,
                    }
                ).render();

                modal.addToolbar(
                    [
                        {
                            label: 'Cancel',
                            on: {
                                click: () => {
                                    modal.hide();
                                }
                            }
                        },
                        {
                            label: 'Delete',
                            on: {
                                click: () => {
                                    window.location.href = '<%=deleteURL%>';
                                    modal.hide();
                                }
                            }
                        }
                    ]
                );

            }
        );
    }
</script>