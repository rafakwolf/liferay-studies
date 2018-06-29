package guestbookportlet.portlet.action;

import com.liferay.portal.kernel.mobile.device.Device;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import commons.ResourceOperations;
import guestbook.model.Guestbook;
import guestbook.service.GuestbookLocalServiceUtil;
import guestbookportlet.constants.GuestbookPortletPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceURL;
import java.util.List;

/**
 * @author rafael.wolf
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+GuestbookPortletPortletKeys.GuestbookPortlet,
                "mvc.command.name=GuestbookView",
                "mvc.command.name=/"
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

        ThemeDisplay themeDisplay= (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        PortletDisplay portletDisplay= themeDisplay.getPortletDisplay();
        String portletId= portletDisplay.getId();
        template.put("portletId", portletId);


        PortletURL navigationURL = renderResponse.createRenderURL();
        navigationURL.setParameter("mvcRenderCommandName", "GuestbookView");
        template.put("backToViewURL", navigationURL.toString());

        PortletURL newUrl = renderResponse.createRenderURL();
        newUrl.setParameter("mvcRenderCommandName", "GuestbookNew");
        template.put("newUrl", newUrl.toString());

        PortletURL editUrl = renderResponse.createRenderURL();
        editUrl.setParameter("mvcRenderCommandName", "GuestbookEdit");
        template.put("editUrl", editUrl.toString());

        ResourceURL resourceURL = ResourceOperations.getPortletResourceURL(renderResponse,
                GuestbookPortletPortletKeys.MVC_RESOURCE_COMMAND);

        template.put("siteURL", resourceURL.toString());
        template.put("portletNamespace", renderResponse.getNamespace());

        int guestbookCount = GuestbookLocalServiceUtil.getGuestbooksCount();
        List<Guestbook> guestbooks = GuestbookLocalServiceUtil.getGuestbooks(0, guestbookCount);
        template.put("guestbooks", guestbooks);

        Device device = themeDisplay.getDevice();

        template.put("Device_Brand", device.getBrand());
        template.put("Device_OS", device.getOS());
        template.put("Device_OS_Version", device.getOSVersion());
        template.put("Device_Model", device.getModel());
        template.put("Device_Physical_Size", device.getScreenPhysicalSize().getHeight()+" x "+device.getScreenPhysicalSize().getWidth());
        template.put("Device_Resolution", device.getScreenResolution().getHeight()+" x "+device.getScreenResolution().getWidth());

        return "GuestbookView";
    }

}