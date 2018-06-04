package myportlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import guestbook.model.Entry;
import guestbook.model.impl.EntryImpl;
import guestbook.service.EntryLocalService;
import guestbook.service.EntryLocalServiceUtil;
import guestbook.service.EntryServiceUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import myportlet.constants.MyPortletPortletKeys;
import org.osgi.service.component.annotations.Component;

/**
 * @author rafael
 */
@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=Lista de Convidados",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.name=" + MyPortletPortletKeys.MyPortlet,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class MyPortletPortlet extends MVCPortlet {

  @ProcessAction(name = "editEntry")
  public void editEntry(ActionRequest request, ActionResponse response) throws PortalException {

    String str = request.getParameter("key");
    long l = Long.valueOf(str);

    Entry entry = EntryLocalServiceUtil.getEntry(l);

    request.setAttribute("edit", entry);

    response.setRenderParameter("jspPage", "/edit_entry.jsp");
  }

  @ProcessAction(name = "updateEntry")
  public void editEntryConfirmation(ActionRequest request, ActionResponse response) {
    String userName = ParamUtil.getString(request, "name");
    String message = ParamUtil.getString(request, "message");

    long id = CounterLocalServiceUtil.increment(Entry.class.getName());

    Entry entry = new EntryImpl();
    entry.setName(userName);
    entry.setMessage(message);

    EntryLocalServiceUtil.updateEntry(entry);
  }

  @ProcessAction(name = "removeEntry")
  public void removeEntry(ActionRequest request, ActionResponse response) throws PortalException {

    String str = request.getParameter("key");
    long l = Long.valueOf(str);

    EntryLocalServiceUtil.deleteEntry(l);
  }

  @ProcessAction(name = "addEntry")
  public void addEntry(ActionRequest request, ActionResponse response) {

    String userName = ParamUtil.getString(request, "name");
    String message = ParamUtil.getString(request, "message");

    long id = CounterLocalServiceUtil.increment(Entry.class.getName());

    Entry entry = new EntryImpl();
    entry.setEntryId(id);
    entry.setName(userName);
    entry.setMessage(message);

    EntryLocalServiceUtil.addEntry(entry);
  }

  @ProcessAction(name = "search")
  public void search(ActionRequest req, ActionResponse res) {
    String str = req.getParameter("name");

    req.setAttribute("name", str);

    ArrayList<Entry> dataList = search(str);
    req.setAttribute("entries", dataList);

    res.setRenderParameter("jspPage", "/view.jsp");
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
        dataList.add(ent);
      }

      return dataList;
    }

    return new ArrayList<>();
  }

  @Override
  public void render(RenderRequest renderRequest, RenderResponse renderResponse)
      throws IOException, PortletException {
    String str = renderRequest.getParameter("name");

    if (str == null) str = "";
    ArrayList<Entry> dataList = search(str);

    renderRequest.setAttribute("entries", dataList);
    super.render(renderRequest, renderResponse);
  }

}