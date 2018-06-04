package mysoyportlet.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.WebKeys;
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
		"javax.portlet.name=MySoyPortlet", "mvc.command.name=Edit"
	},
	service = MVCRenderCommand.class
)
public class MySoyPortletEditMVCRenderCommand
	implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		Template template = (Template)renderRequest.getAttribute(
			WebKeys.TEMPLATE);

		PortletURL backToView = renderResponse.createRenderURL();
 	  backToView.setParameter("mvcRenderCommandName", "View");
		template.put("backToViewUrl", backToView.toString());

		return "Edit";
	}

}