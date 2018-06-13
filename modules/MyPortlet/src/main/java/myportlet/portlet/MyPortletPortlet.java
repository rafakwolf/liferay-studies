package myportlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import guestbook.model.Entry;
import guestbook.model.Guestbook;
import guestbook.model.impl.EntryImpl;
import guestbook.model.impl.GuestbookImpl;
import guestbook.service.EntryLocalService;
import guestbook.service.EntryLocalServiceUtil;
import guestbook.service.GuestbookLocalService;
import guestbook.service.GuestbookLocalServiceUtil;
import myportlet.constants.MyPortletPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author rafael
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.instanceable=false",
                "javax.portlet.display-name=Lista de Convidados (MVC)",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + MyPortletPortletKeys.MyPortlet,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user",
                "javax.portlet.expiration-cache=0"
        },
        service = Portlet.class
)
public class MyPortletPortlet extends MVCPortlet {

    private EntryLocalService _entryLocalService;

    @Reference(unbind = "-")
    protected void setEntryService(EntryLocalService entryLocalService) {
        this._entryLocalService = entryLocalService;
    }

    @ProcessAction(name = "editEntry")
    public void editEntry(ActionRequest request, ActionResponse response) throws PortalException {
        Long entryId = ParamUtil.getLong(request, "key");
        Entry entry = EntryLocalServiceUtil.getEntry(entryId);
        request.setAttribute("edit", entry);

        ArrayList<Guestbook> guestbooks = getGuestbooks();
        request.setAttribute("guestbooks", guestbooks);

        response.setRenderParameter("jspPage", "/edit_entry.jsp");
    }

    @ProcessAction(name="newEntry")
    public void addEntryUrl(ActionRequest request, ActionResponse response) {
        ArrayList<Guestbook> guestbooks = this.getGuestbooks();
        request.setAttribute("guestbooks", guestbooks);

        response.setRenderParameter("jspPage", "/new_entry.jsp");
    }

    @ProcessAction(name = "updateEntry")
    public void editEntryConfirmation(ActionRequest request, ActionResponse response) throws PortalException {
        String name = ParamUtil.getString(request, "name");
        String message = ParamUtil.getString(request, "message");
        String email = ParamUtil.getString(request, "email");
        Long guestbookId = ParamUtil.getLong(request, "guestbookId");
        Long entryId = ParamUtil.getLong(request, "key");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                Entry.class.getName(), request);

        try {
            Entry entry = new EntryImpl();
            entry.setEntryId(entryId);
            entry.setGuestbookId(guestbookId);
            entry.setName(name);
            entry.setMessage(message);
            entry.setEmail(email);
            entry.setUserId(serviceContext.getUserId());

            _entryLocalService.updateEntry(entry);

            SessionMessages.add(request, "entryUpdated");

            response.setRenderParameter(
                    "guestbookId", Long.toString(guestbookId));

        } catch (Exception e) {
            System.out.println(e);
            SessionErrors.add(request, e.getClass().getName());
        }
    }

    @ProcessAction(name = "removeEntry")
    public void removeEntry(ActionRequest request, ActionResponse response) throws PortalException {

        String str = request.getParameter("key");
        long l = Long.valueOf(str);

        EntryLocalServiceUtil.deleteEntry(l);
    }

    @ProcessAction(name = "addEntry")
    public void addEntry(ActionRequest request, ActionResponse response) throws PortalException {

        String email = ParamUtil.getString(request, "email");
        String name = ParamUtil.getString(request, "name");
        String message = ParamUtil.getString(request, "message");
        Long guestbookId = ParamUtil.getLong(request, "guestbookId");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                Entry.class.getName(), request);

        long id = CounterLocalServiceUtil.increment(Entry.class.getName());

        Entry entry = new EntryImpl();
        entry.setEntryId(id);
        entry.setName(name);
        entry.setMessage(message);
        entry.setEmail(email);
        entry.setGuestbookId(guestbookId);
        entry.setUserId(serviceContext.getUserId());

        try {
            EntryLocalServiceUtil.addEntry(entry);
            SessionMessages.add(request, "entryAdded");
        } catch (Exception e) {
            System.out.println(e);
            SessionErrors.add(request, e.getClass().getName());
        }
    }

    @ProcessAction(name = "search")
    public void search(ActionRequest req, ActionResponse res) {
        String searchTerm = req.getParameter("search");

        req.setAttribute("search", searchTerm);

        ArrayList<Entry> dataList = search(searchTerm);
        req.setAttribute("entries", dataList);

        res.setRenderParameter("jspPage", "/view.jsp");
    }

    private ArrayList<Guestbook> getGuestbooks() {
        int guestbookCount = GuestbookLocalServiceUtil.getGuestbooksCount();

        if (guestbookCount > 0) {
            List<Guestbook> guestbooks = GuestbookLocalServiceUtil.getGuestbooks(0, guestbookCount);

            ArrayList<Guestbook> dataList = new ArrayList<>();

            for (Guestbook guestbook : guestbooks) {
                Guestbook guestb = new GuestbookImpl();
                guestb.setGuestbookId(guestbook.getGuestbookId());
                guestb.setName(guestbook.getName());

                dataList.add(guestb);
            }

            return dataList;
        }

        return new ArrayList<>();
    }

    private ArrayList<Entry> search(String term) {
        int entriesCount = EntryLocalServiceUtil.getEntriesCount();

        if (entriesCount > 0) {
            List<Entry> entries = EntryLocalServiceUtil
                    .getEntries(0, entriesCount)
                    .stream()
                    .filter(f -> f.getName().contains(term))
                    .collect(Collectors.toList());

            ArrayList<Entry> dataList = new ArrayList<>();

            for (Entry entry : entries) {
                Entry ent = new EntryImpl();
                ent.setEntryId(entry.getEntryId());
                ent.setName(entry.getName());
                ent.setMessage(entry.getMessage());
                ent.setEmail(entry.getEmail());
                ent.setGuestbookId(entry.getGuestbookId());

                dataList.add(ent);
            }

            return dataList;
        }

        return new ArrayList<>();
    }

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        String searchTerm = renderRequest.getParameter("name");

        if (searchTerm == null) searchTerm = "";
        ArrayList<Entry> dataList = search(searchTerm);

        renderRequest.setAttribute("entries", dataList);

        super.render(renderRequest, renderResponse);
    }
}