<%@ include file="./init.jsp" %>

<p>
    <b><liferay-ui:message key="MyEditor.caption"/>
    </b>

    <liferay-ui:alert
            closeable="true"
            icon="exclamation-full"
            message="Here is our awesome alert example"
            type="success"
    />

    <liferay-ui:user-display
            markupView="lexicon"
            showUserDetails="true"
            showUserName="true"
            userId="<%= themeDisplay.getRealUserId() %>"
            userName="<%= themeDisplay.getRealUser().getFullName() %>"
    />


<div class="alloy-editor-container">
    <liferay-ui:input-editor
            contents="Default Content"
            cssClass="my-ck-editor"
            editorName="ckeditor"
            name="myCkEditor"
            onInitMethod="OnDescriptionEditorInit"
            placeholder="description"
            showSource="true"/>
</div>

<%!
    private boolean customAbstract = false;
%>

<aui:script>
    function <portlet:namespace/>OnDescriptionEditorInit() {
    <c:if test="<%= !customAbstract %>">
        document.getElementById('<portlet:namespace/>myAlloyEditor').setAttribute('contenteditable', true);
    </c:if>
    }
</aui:script>
</p>