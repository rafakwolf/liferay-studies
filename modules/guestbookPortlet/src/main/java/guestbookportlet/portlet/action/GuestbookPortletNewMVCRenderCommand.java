package guestbookportlet.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.WebKeys;
import commons.ResourceOperations;
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
                "mvc.command.name=New"
        },
        service = MVCRenderCommand.class
)
public class GuestbookPortletNewMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        Template template = (Template) renderRequest.getAttribute(
                WebKeys.TEMPLATE);

        PortletURL backToViewURL = renderResponse.createRenderURL();
        backToViewURL.setParameter("mvcRenderCommandName", "View");
        template.put("backToViewURL", backToViewURL.toString());

        ResourceURL resourceURL = ResourceOperations.getPortletResourceURL(renderResponse,
                GuestbookPortletPortletKeys.MVC_RESOURCE_COMMAND);

        template.put("siteURL", resourceURL.toString());
        template.put("portletNamespace", renderResponse.getNamespace());

        return "New";

    }
}
