package commons;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;

import javax.portlet.*;
import java.io.IOException;
import java.io.Writer;

public class ResourceOperations {

    public static ResourceURL getPortletResourceURL(
            RenderResponse response, String resourceID) {

        ResourceURL resourceURL = null;
        try {
            resourceURL = response.createResourceURL();
            resourceURL.setResourceID(resourceID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

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
