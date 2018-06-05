package mysoyportlet.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import mysoyportlet.common.CrudOperations;
import mysoyportlet.constants.MySoyPortletPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

@Component(
        property = {
                "javax.portlet.name=" + MySoyPortletPortletKeys.MySoyPortlet,
                "mvc.command.name=" + MySoyPortletPortletKeys.MVC_RESOURCE_COMMAND},
        service = MVCResourceCommand.class)
public class MySoyPortletNewOrEditMVCResourceCommand implements MVCResourceCommand {

    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {
        new CrudOperations().saveOrUpdate(resourceRequest, resourceResponse);
        return true;
    }
}
