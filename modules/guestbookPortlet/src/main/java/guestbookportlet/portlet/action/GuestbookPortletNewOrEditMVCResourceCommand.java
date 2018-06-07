package guestbookportlet.portlet.action;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.GetterUtil;
import guestbook.model.Guestbook;
import guestbook.model.impl.GuestbookImpl;
import guestbook.service.GuestbookLocalServiceUtil;
import guestbookportlet.constants.GuestbookPortletPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

@Component(
        property = {
                "javax.portlet.name=" + GuestbookPortletPortletKeys.GuestbookPortlet,
                "mvc.command.name=" + GuestbookPortletPortletKeys.MVC_RESOURCE_COMMAND},
        service = MVCResourceCommand.class)
public class GuestbookPortletNewOrEditMVCResourceCommand implements MVCResourceCommand {
    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {

        String name = GetterUtil.getString(resourceRequest.getParameter("name"));

        if (name == null || name.isEmpty()) {
            throw new PortletException("No data found.");
        }

        Guestbook guestbook = new GuestbookImpl();
        guestbook.setGuestbookId(new Random().nextLong());
        guestbook.setName(name);

        try{
            GuestbookLocalServiceUtil.addGuestbook(guestbook);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        resourceResponse.setContentType("application/json");
        JSONObject resp = JSONFactoryUtil.createJSONObject();
        resp.put("name", name);

        try {
            Writer writer = resourceResponse.getWriter();
            writer.write(resp.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
