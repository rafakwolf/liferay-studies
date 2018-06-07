package guestbookportlet.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;
import guestbook.model.Guestbook;
import guestbook.service.GuestbookLocalServiceUtil;
import guestbookportlet.constants.GuestbookPortletPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
/**
 * @author rafael
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+GuestbookPortletPortletKeys.GuestbookPortlet,
                "mvc.command.name=Edit"
        },
        service = MVCRenderCommand.class
)
public class GuestbookPortletEditMVCRenderCommand implements MVCRenderCommand {

    private ResourceURL getPortletResourceURL(
            RenderResponse renderResponse, String resourceID) {

        ResourceURL resourceURL = renderResponse.createResourceURL();
        resourceURL.setResourceID(resourceID);
        return resourceURL;
    }


    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        Template template = (Template) renderRequest.getAttribute(
                WebKeys.TEMPLATE);

        PortletURL backToView = renderResponse.createRenderURL();
        backToView.setParameter("mvcRenderCommandName", "View");
        template.put("backToViewURL", backToView.toString());

        ResourceURL resourceURL = getPortletResourceURL(renderResponse,
                GuestbookPortletPortletKeys.MVC_RESOURCE_COMMAND);

        template.put("siteURL", resourceURL.toString());
        template.put("portletNamespace", renderResponse.getNamespace());

        String guestbookId = GetterUtil.getString(renderRequest.getParameter("guestbookId"));
        long id = Long.parseLong(guestbookId);
        Guestbook guestbook = GuestbookLocalServiceUtil.fetchGuestbook(id);

        template.put("guestbook", guestbook);

        return "Edit";
    }
}