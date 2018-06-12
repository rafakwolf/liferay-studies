package guestbookportlet.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.GetterUtil;
import commons.CrudOperations;
import guestbookportlet.constants.GuestbookPortletPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

@Component(
        property = {
                "javax.portlet.name=" + GuestbookPortletPortletKeys.GuestbookPortlet,
                "mvc.command.name=" + GuestbookPortletPortletKeys.MVC_RESOURCE_COMMAND},
        service = MVCResourceCommand.class)
public class GuestbookPortletNewOrEditMVCResourceCommand extends BaseMVCResourceCommand {

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {

        String action = GetterUtil.getString(resourceRequest.getParameter("act"));

        if (action != null && !action.isEmpty()) {
            if (action.equals("delete")) {
                CrudOperations.removeGuestbook(resourceRequest, resourceResponse);
            }
        }

        CrudOperations.saveOrUpdateGuestbook(resourceRequest, resourceResponse);
    }
}
