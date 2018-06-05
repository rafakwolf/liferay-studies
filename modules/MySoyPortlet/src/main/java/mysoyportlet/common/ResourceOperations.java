package mysoyportlet.common;

import javax.portlet.RenderResponse;
import javax.portlet.ResourceURL;

public class ResourceOperations {
    public ResourceURL getPortletResourceURL(
            RenderResponse renderResponse, String resourceID) {

        ResourceURL resourceURL = renderResponse.createResourceURL();
        resourceURL.setResourceID(resourceID);
        return resourceURL;
    }
}
