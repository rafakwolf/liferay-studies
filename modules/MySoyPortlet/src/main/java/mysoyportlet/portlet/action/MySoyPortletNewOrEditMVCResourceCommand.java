package mysoyportlet.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import commons.CrudOperations;
import commons.ResourceOperations;
import mysoyportlet.constants.MySoyPortletPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;

@Component(
        property = {
                "javax.portlet.name=" + MySoyPortletPortletKeys.MySoyPortlet,
                "mvc.command.name=" + MySoyPortletPortletKeys.MVC_RESOURCE_COMMAND},
        service = MVCResourceCommand.class)
public class MySoyPortletNewOrEditMVCResourceCommand implements MVCResourceCommand {

    public int parseWithDefault(String s, int defValue) {
        return s.matches("-?\\d+") ? Integer.parseInt(s) : defValue;
    }

    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {

        String action = ResourceOperations.getParam(resourceRequest, "act");

        if (action != null && !action.isEmpty()){
            if (action.equals("delete")){
                try {
                    CrudOperations.removeEntry(resourceRequest, resourceResponse);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }

        try {
            CrudOperations.saveOrUpdateEntry(resourceRequest, resourceResponse);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
