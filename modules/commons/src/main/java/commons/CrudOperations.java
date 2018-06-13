package commons;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;

public class CrudOperations {

    public static void saveOrUpdateEntry(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
        String name = ResourceOperations.getParam(resourceRequest, "name");
        String email = ResourceOperations.getParam(resourceRequest, "email");
        String message = ResourceOperations.getParam(resourceRequest, "message");

        Long guestbookId = null;
        Long entryId = null;
        try {
            guestbookId = Long.parseLong(ResourceOperations.getParam(resourceRequest, "guestbookId"));
            entryId = Long.parseLong(ResourceOperations.getParam(resourceRequest, "entryId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (name.isEmpty() || email.isEmpty() || message.isEmpty()) {
            throw new PortletException("No data found");
        }

        try {
            if (!entryId.toString().equals("0")) {
                new EntryServices().update(entryId, name, email, message, 0, guestbookId);
            } else {
                new EntryServices().save(name, email, message, 0, guestbookId);
            }
        } catch (Exception e) {
            JSONObject resp = JSONFactoryUtil.createJSONObject();
            resp.put("error", e.getMessage());
            ResourceOperations.writeJsonResponse(resp, resourceResponse);

            e.printStackTrace();
        }

        JSONObject resp = JSONFactoryUtil.createJSONObject();
        resp.put("name", name);
        resp.put("message", message);
        resp.put("guestbookId", guestbookId);

        ResourceOperations.writeJsonResponse(resp, resourceResponse);
    }

    public static void saveOrUpdateGuestbook(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
        String name = ResourceOperations.getParam(resourceRequest,"name");
        Long guestbookId = Long.parseLong( ResourceOperations.getParam(resourceRequest, "guestbookId"));

        if (name == null || name.isEmpty()) {
            throw new PortletException("No data found.");
        }

        try {
            if (!guestbookId.toString().equals("0")) {
                new GuestbookServices().update(guestbookId, name);
            } else {
                new GuestbookServices().save(name);
            }
        } catch (Exception e) {
            JSONObject resp = JSONFactoryUtil.createJSONObject();
            resp.put("error", e.getMessage());
            ResourceOperations.writeJsonResponse(resp, resourceResponse);

            e.printStackTrace();
        }

        JSONObject resp = JSONFactoryUtil.createJSONObject();
        resp.put("name", name);

        ResourceOperations.writeJsonResponse(resp, resourceResponse);
    }

    public static void removeEntry(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
        Long entryId = Long.parseLong(ResourceOperations.getParam(resourceRequest, "entryId"));

        new EntryServices().delete(entryId);

        JSONObject resp = JSONFactoryUtil.createJSONObject();
        resp.put("message", "Entry deleted");
        ResourceOperations.writeJsonResponse(resp, resourceResponse);
    }

    public static void removeGuestbook(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
        Long guestbookId = Long.parseLong(ResourceOperations.getParam(resourceRequest, "guestbookId"));

        new GuestbookServices().delete(guestbookId);

        JSONObject resp = JSONFactoryUtil.createJSONObject();
        resp.put("message", "Guestbook deleted");
        ResourceOperations.writeJsonResponse(resp, resourceResponse);
    }
}
