package commons;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import guestbook.model.Entry;
import guestbook.model.Guestbook;
import guestbook.model.impl.EntryImpl;
import guestbook.model.impl.GuestbookImpl;
import guestbook.service.EntryLocalServiceUtil;
import guestbook.service.GuestbookLocalServiceUtil;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

public class CrudOperations {

    public static void saveOrUpdateEntry(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {
        String name = ResourceOperations.getParam(resourceRequest, "name");
        String message = ResourceOperations.getParam(resourceRequest, "message");
        String entryId = ResourceOperations.getParam(resourceRequest, "entryId");
        String guestbookId = ResourceOperations.getParam(resourceRequest, "guestbookId");

        if (name.isEmpty() || message.isEmpty()) {
            throw new PortletException("No data found");
        }

        try {
            if (entryId != null && !entryId.isEmpty()) {
                Entry entry = EntryLocalServiceUtil.fetchEntry(Long.parseLong(entryId));
                entry.setName(name);
                entry.setMessage(message);
                entry.setGuestbookId(Long.parseLong(guestbookId));

                EntryLocalServiceUtil.updateEntry(entry);
            } else {
                Entry entry = new EntryImpl();
                entry.setEntryId(new Random().nextLong());
                entry.setName(name);
                entry.setMessage(message);
                entry.setGuestbookId(Long.parseLong(guestbookId));

                EntryLocalServiceUtil.addEntry(entry);
            }
        } catch (Exception e) {
            JSONObject resp = JSONFactoryUtil.createJSONObject();
            resp.put("error", e.getMessage());
            try {
                ResourceOperations.writeJsonResponse(resp, resourceResponse);
            } catch (IOException ie) {
                ie.printStackTrace();
            }
            e.printStackTrace();
        }

        JSONObject resp = JSONFactoryUtil.createJSONObject();
        resp.put("name", name);
        resp.put("message", message);
        resp.put("guestbookId", guestbookId);

        try {
            ResourceOperations.writeJsonResponse(resp, resourceResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveOrUpdateGuestbook(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {

        String name = ResourceOperations.getParam(resourceRequest,"name");
        String guestbookId = ResourceOperations.getParam(resourceRequest, "guestbookId");


        if (name == null || name.isEmpty()) {
            throw new PortletException("No data found.");
        }

        try {
            if (guestbookId != null && !guestbookId.isEmpty()) {
                Guestbook guestbook = GuestbookLocalServiceUtil.fetchGuestbook(Long.parseLong(guestbookId));
                guestbook.setName(name);

                GuestbookLocalServiceUtil.updateGuestbook(guestbook);
            } else {
                Guestbook guestbook = new GuestbookImpl();
                guestbook.setGuestbookId(new Random().nextLong());
                guestbook.setName(name);

                GuestbookLocalServiceUtil.addGuestbook(guestbook);
            }
        } catch (Exception e) {
            JSONObject resp = JSONFactoryUtil.createJSONObject();
            resp.put("error", e.getMessage());
            try {
                ResourceOperations.writeJsonResponse(resp, resourceResponse);
            } catch (IOException ie) {
                ie.printStackTrace();
            }
            e.printStackTrace();
        }

        JSONObject resp = JSONFactoryUtil.createJSONObject();
        resp.put("name", name);

        try {
            ResourceOperations.writeJsonResponse(resp, resourceResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeEntry(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
        String entryId = GetterUtil.getString(resourceRequest.getParameter("entryId"));

        try {
            EntryLocalServiceUtil.deleteEntry(Long.parseLong(entryId));

            resourceResponse.setContentType("application/json");
            JSONObject resp = JSONFactoryUtil.createJSONObject();
            resp.put("message", "Entry deleted");

            try {
                Writer writer = resourceResponse.getWriter();
                writer.write(resp.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (PortalException e) {
            e.printStackTrace();
        }
    }

    public static void removeGuestbook(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
        String guestbookId = GetterUtil.getString(resourceRequest.getParameter("guestbookId"));

        try {
            GuestbookLocalServiceUtil.deleteGuestbook(Long.parseLong(guestbookId));

            resourceResponse.setContentType("application/json");
            JSONObject resp = JSONFactoryUtil.createJSONObject();
            resp.put("message", "Guestbook deleted");

            try {
                Writer writer = resourceResponse.getWriter();
                writer.write(resp.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (PortalException e) {
            e.printStackTrace();
        }
    }
}
