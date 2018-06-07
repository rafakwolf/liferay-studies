package guestbookportlet.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import guestbook.model.Guestbook;
import guestbook.service.GuestbookLocalService;
import guestbook.service.GuestbookLocalServiceUtil;
import guestbookportlet.constants.GuestbookPortletPortletKeys;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author rafael.wolf
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+GuestbookPortletPortletKeys.GuestbookPortlet,
                "mvc.command.name=View"
        },
        service = MVCRenderCommand.class
)
public class GuestbookPortletViewMVCRenderCommand
        implements MVCRenderCommand {

    @Override
    public String render(
            RenderRequest renderRequest, RenderResponse renderResponse) {

        Template template = (Template) renderRequest.getAttribute(
                WebKeys.TEMPLATE);

        PortletURL navigationURL = renderResponse.createRenderURL();
        navigationURL.setParameter("mvcRenderCommandName", "View");
        template.put("backToViewURL", navigationURL.toString());

        PortletURL newUrl = renderResponse.createRenderURL();
        newUrl.setParameter("mvcRenderCommandName", "New");
        template.put("newUrl", newUrl.toString());

        PortletURL editUrl = renderResponse.createRenderURL();
        editUrl.setParameter("mvcRenderCommandName", "Edit");
        template.put("editUrl", editUrl.toString());

        template.put("portletNamespace", renderResponse.getNamespace());

        int guestbookCount = GuestbookLocalServiceUtil.getGuestbooksCount();
        List<Guestbook> guestbooks = GuestbookLocalServiceUtil.getGuestbooks(0, guestbookCount);
        template.put("guestbooks", guestbooks);

        return "View";
    }

}