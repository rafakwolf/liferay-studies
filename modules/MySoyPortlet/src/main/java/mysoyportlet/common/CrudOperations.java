package mysoyportlet.common;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import guestbook.model.Entry;
import guestbook.model.impl.EntryImpl;
import guestbook.service.EntryLocalServiceUtil;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

public class CrudOperations {

    public void saveOrUpdate(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {
        String name = getParam(resourceRequest, "name");
        String message = getParam(resourceRequest, "message");
        String entryId = getParam(resourceRequest, "entryId");

        if (name.isEmpty() || message.isEmpty()) {
            throw new PortletException("No data found");
        }

        try {
            if (entryId != null && !entryId.isEmpty()) {
                Entry entry = EntryLocalServiceUtil.fetchEntry(Long.parseLong(entryId));
                entry.setName(name);
                entry.setMessage(message);

                EntryLocalServiceUtil.updateEntry(entry);
            } else {
                Entry entry = new EntryImpl();
                entry.setEntryId(new Random().nextLong());
                entry.setName(name);
                entry.setMessage(message);

                EntryLocalServiceUtil.addEntry(entry);
            }
        } catch (Exception e) {
            JSONObject resp = JSONFactoryUtil.createJSONObject();
            resp.put("error", e.getMessage());
            try {
                writeJsonResponse(resp, resourceResponse);
            } catch (IOException ie) {
                ie.printStackTrace();
            }
            e.printStackTrace();
        }

        JSONObject resp = JSONFactoryUtil.createJSONObject();
        resp.put("name", name);
        resp.put("message", message);

        try {
            writeJsonResponse(resp, resourceResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getParam(PortletRequest portletRequest, String param) {
        return GetterUtil.getString(portletRequest.getParameter(param));
    }

    private void writeJsonResponse(JSONObject jsonObject, ResourceResponse response) throws IOException {
        response.setContentType("application/json");
        Writer writer = response.getWriter();
        writer.write(jsonObject.toString());
    }

}
