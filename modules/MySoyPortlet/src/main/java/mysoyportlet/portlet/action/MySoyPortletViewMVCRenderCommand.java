package mysoyportlet.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import guestbook.model.Entry;
import guestbook.service.EntryLocalServiceUtil;

import java.util.List;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author rafael
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=MySoyPortlet", "mvc.command.name=View",
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class MySoyPortletViewMVCRenderCommand
        implements MVCRenderCommand {

    @Override
    public String render(
            RenderRequest renderRequest, RenderResponse renderResponse) {

        Template template = (Template) renderRequest.getAttribute(
                WebKeys.TEMPLATE);

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(
                WebKeys.THEME_DISPLAY);

        template.put("layouts", themeDisplay.getLayouts());

        PortletURL newUrl = renderResponse.createRenderURL();
        newUrl.setParameter("mvcRenderCommandName", "New");
        template.put("newUrl", newUrl.toString());

        PortletURL editUrl = renderResponse.createRenderURL();
        editUrl.setParameter("mvcRenderCommandName", "Edit");
        template.put("editUrl", editUrl.toString());

        List<Entry> entries = getEntries();
        template.put("entries", entries);

        String siteBaseURL = themeDisplay.getPortalURL().concat(
                themeDisplay.getPathFriendlyURLPrivateGroup()).concat("/");

        template.put("siteURL", siteBaseURL);
        template.put("portletNamespace", renderResponse.getNamespace());


        return "View";
    }

    public List<Entry> getEntries() {
        int entriesCount = EntryLocalServiceUtil.getEntriesCount();
        return EntryLocalServiceUtil.getEntries(0, entriesCount);
    }

}