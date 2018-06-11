package mysoyportlet.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.portlet.ResourceURL;

import commons.ResourceOperations;
import guestbook.model.Guestbook;
import guestbook.service.GuestbookLocalServiceUtil;
import mysoyportlet.constants.MySoyPortletPortletKeys;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author rafael
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=MySoyPortlet",
                "mvc.command.name=EntryNew"
        },
        service = MVCRenderCommand.class
)
public class MySoyPortletNewMVCRenderCommand
        implements MVCRenderCommand {

    @Override
    public String render(
            RenderRequest renderRequest, RenderResponse renderResponse) {

        Template template = (Template) renderRequest.getAttribute(
                WebKeys.TEMPLATE);

        PortletURL backToViewURL = renderResponse.createRenderURL();
        backToViewURL.setParameter("mvcRenderCommandName", "EntryView");
        template.put("backToViewURL", backToViewURL.toString());

        ResourceURL resourceURL = ResourceOperations.getPortletResourceURL(renderResponse,
                MySoyPortletPortletKeys.MVC_RESOURCE_COMMAND);

        template.put("siteURL", resourceURL.toString());
        template.put("portletNamespace", renderResponse.getNamespace());

        int guestbookCount = GuestbookLocalServiceUtil.getGuestbooksCount();
        List<Guestbook> guestbooks = GuestbookLocalServiceUtil.getGuestbooks(0, guestbookCount);
        template.put("guestbooks", guestbooks);

        return "EntryNew";
    }

}