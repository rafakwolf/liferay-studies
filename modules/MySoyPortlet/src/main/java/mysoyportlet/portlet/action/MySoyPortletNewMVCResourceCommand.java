package mysoyportlet.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.GetterUtil;
import guestbook.model.Entry;
import guestbook.model.impl.EntryImpl;
import guestbook.service.EntryLocalServiceUtil;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import mysoyportlet.constants.MySoyPortletPortletKeys;
import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "javax.portlet.name=" + MySoyPortletPortletKeys.MySoyPortlet,
        "mvc.command.name=" + MySoyPortletNewMVCResourceCommand.MVC_RESOURCE_COMMAND},
    service = MVCResourceCommand.class)
public class MySoyPortletNewMVCResourceCommand implements MVCResourceCommand {

  public static final String MVC_RESOURCE_COMMAND = "Entries";


  public static String getParam(PortletRequest portletRequest, String param) {
    return GetterUtil.getString(portletRequest.getParameter(param));
  }

  @Override
  public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
      throws PortletException {

    String name = getParam(resourceRequest,"name");
    String message = getParam(resourceRequest,"message");

    if (name.isEmpty() || message.isEmpty()) {
      throw new PortletException("No data found");
    }

    Entry entry = new EntryImpl();
    entry.setName(name);
    entry.setMessage(message);

    EntryLocalServiceUtil.addEntry(entry);

    return true;
  }
}
