package mysoyportlet.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.portlet.ResourceURL;

import mysoyportlet.common.ResourceOperations;
import mysoyportlet.constants.MySoyPortletPortletKeys;
import org.osgi.service.component.annotations.Component;

/**
 * @author rafael
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=MySoyPortlet", "mvc.command.name=New"
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
        backToViewURL.setParameter("mvcRenderCommandName", "View");
        template.put("backToViewURL", backToViewURL.toString());

        ResourceURL resourceURL = new ResourceOperations().getPortletResourceURL(renderResponse,
                MySoyPortletPortletKeys.MVC_RESOURCE_COMMAND);

        template.put("siteURL", resourceURL.toString());
        template.put("portletNamespace", renderResponse.getNamespace());

        return "New";
    }

}