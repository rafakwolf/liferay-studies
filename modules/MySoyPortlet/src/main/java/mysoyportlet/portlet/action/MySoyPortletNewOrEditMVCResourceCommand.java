package mysoyportlet.portlet.action;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.GetterUtil;
import commons.CrudOperations;
import guestbook.model.Entry;
import guestbook.service.EntryLocalServiceUtil;
import mysoyportlet.constants.MySoyPortletPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

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

        String action = GetterUtil.getString(resourceRequest.getParameter("act"));

        if (action != null && !action.isEmpty()){
            if (action.equals("delete")){
                CrudOperations.removeEntry(resourceRequest, resourceResponse);
            }

            if (action.equals("pagination")) {

                int page = parseWithDefault(GetterUtil.getString(resourceRequest.getParameter("page")),1);
                int pageLen = parseWithDefault(GetterUtil.getString(resourceRequest.getParameter("pageLen")),5);

                int start = ((page -1) * pageLen);
                List<Entry> entries = EntryLocalServiceUtil.getEntries(start, pageLen);

                JSONObject json = JSONFactoryUtil.createJSONObject();
                json.put("entries", entries);

                resourceResponse.setContentType("application/json");
                try {
                    Writer writer = resourceResponse.getWriter();
                    writer.write(json.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return true;
            }

        }

        CrudOperations.saveOrUpdateEntry(resourceRequest, resourceResponse);
        return true;
    }
}
