package mysoyportlet.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;
import commons.ResourceOperations;
import guestbook.model.Entry;
import guestbook.model.Guestbook;
import guestbook.service.EntryLocalServiceUtil;
import guestbook.service.GuestbookLocalServiceUtil;
import mysoyportlet.constants.MySoyPortletPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceURL;
import java.util.List;

/**
 * @author rafael
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=MySoyPortlet",
                "mvc.command.name=EntryEdit"
        },
        service = MVCRenderCommand.class
)
public class MySoyPortletEditMVCRenderCommand
        implements MVCRenderCommand {

    @Override
    public String render(
            RenderRequest renderRequest, RenderResponse renderResponse) {

        Template template = (Template) renderRequest.getAttribute(
                WebKeys.TEMPLATE);

        PortletURL backToView = renderResponse.createRenderURL();
        backToView.setParameter("mvcRenderCommandName", "EntryView");
        template.put("backToViewURL", backToView.toString());

        ResourceURL resourceURL = ResourceOperations.getPortletResourceURL(renderResponse,
                MySoyPortletPortletKeys.MVC_RESOURCE_COMMAND);

        template.put("siteURL", resourceURL.toString());
        template.put("portletNamespace", renderResponse.getNamespace());

        int guestbookCount = GuestbookLocalServiceUtil.getGuestbooksCount();
        List<Guestbook> guestbooks = GuestbookLocalServiceUtil.getGuestbooks(0, guestbookCount);
        template.put("guestbooks", guestbooks);

        String entryId = GetterUtil.getString(renderRequest.getParameter("entryId"));
        long id = Long.parseLong(entryId);
        Entry entry = EntryLocalServiceUtil.fetchEntry(id);

        template.put("entry", entry);

        return "EntryEdit";
    }

}