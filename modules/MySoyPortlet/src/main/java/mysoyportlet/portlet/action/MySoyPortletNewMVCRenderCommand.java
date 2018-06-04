package mysoyportlet.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.portlet.ResourceURL;
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

  public ResourceURL getPortletResourceURL(
      RenderResponse renderResponse, String resourceID) {

    ResourceURL resourceURL = renderResponse.createResourceURL();

    resourceURL.setResourceID(resourceID);

    return resourceURL;
  }


	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		Template template = (Template)renderRequest.getAttribute(
			WebKeys.TEMPLATE);

		PortletURL backToViewURL = renderResponse.createRenderURL();
		backToViewURL.setParameter("mvcRenderCommandName", "View");
		template.put("backToViewURL", backToViewURL.toString());

    ResourceURL resourceURL = getPortletResourceURL(renderResponse,
				MySoyPortletNewMVCResourceCommand.MVC_RESOURCE_COMMAND);

		template.put("siteURL", resourceURL.toString());

		return "New";
	}

}