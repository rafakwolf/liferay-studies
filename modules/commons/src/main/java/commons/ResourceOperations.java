package commons;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;

import javax.portlet.PortletRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import java.io.IOException;
import java.io.Writer;

public class ResourceOperations {

    public static ResourceURL getPortletResourceURL(
            RenderResponse renderResponse, String resourceID) {

        ResourceURL resourceURL = renderResponse.createResourceURL();
        resourceURL.setResourceID(resourceID);
        return resourceURL;
    }

    public static String getParam(PortletRequest portletRequest, String param) {
        String paramValue = GetterUtil.getString(portletRequest.getParameter(param));
        return (paramValue != null && !paramValue.isEmpty() && !paramValue.equals("undefined") && !paramValue.equals("null")) ? paramValue : "0";
    }

    public static void writeJsonResponse(JSONObject jsonObject, ResourceResponse response) throws IOException {
        response.setContentType("application/json");
        Writer writer = response.getWriter();
        writer.write(jsonObject.toString());
    }

}
