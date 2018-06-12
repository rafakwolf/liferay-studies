package mysoyportlet.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.WebKeys;
import commons.ResourceOperations;
import guestbook.model.Entry;
import guestbook.service.EntryLocalServiceUtil;
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
                "mvc.command.name=EntryView",
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

        PortletURL newUrl = renderResponse.createRenderURL();
        newUrl.setParameter("mvcRenderCommandName", "EntryNew");
        template.put("newUrl", newUrl.toString());

        PortletURL editUrl = renderResponse.createRenderURL();
        editUrl.setParameter("mvcRenderCommandName", "EntryEdit");
        template.put("editUrl", editUrl.toString());

        PortletURL viewUrl = renderResponse.createRenderURL();
        viewUrl.setParameter("mvcRenderCommandName", "EntryView");
        template.put("viewUrl", viewUrl.toString());

        List<Entry> entries = getEntries();
        template.put("entries", entries);

        ResourceURL resourceURL = ResourceOperations.getPortletResourceURL(renderResponse,
                MySoyPortletPortletKeys.MVC_RESOURCE_COMMAND);

        template.put("siteURL", resourceURL.toString());
        template.put("portletNamespace", renderResponse.getNamespace());

        return "EntryView";
    }

    public List<Entry> getEntries() {
        int entriesCount = EntryLocalServiceUtil.getEntriesCount();
        return EntryLocalServiceUtil.getEntries(0, entriesCount);
    }

}