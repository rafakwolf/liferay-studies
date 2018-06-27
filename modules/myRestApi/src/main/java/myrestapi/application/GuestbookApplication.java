package myrestapi.application;

import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONSerializer;
import guestbook.model.Guestbook;
import guestbook.service.GuestbookLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author rafael.wolf
 * Request - http://localhost:8080/o/myRestApi/greetings/guestbooks/
 */
@Path("/guestbooks")
@Component(immediate = true, service = Application.class)
public class GuestbookApplication extends Application {


    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }


    @Reference
    public GuestbookLocalService guestbookLocalService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Guestbook> getGuestbooks(@QueryParam(value = "groupId") long groupId){
        return guestbookLocalService.getGuestbooks(groupId);
    }

    @GET
    @Path("{guestbookId}")
    @Produces( { MediaType.APPLICATION_JSON })
    public String getGuestbook(@PathParam("guestbookId") long guestbookId){
        try {
            Guestbook guestbook = guestbookLocalService.getGuestbook(guestbookId);

            JSONObject json = JSONFactoryUtil.createJSONObject(guestbook.toString());

            return json.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @POST
    public Guestbook addGuestbook(Guestbook guestbook) {
       return guestbookLocalService.addGuestbook(guestbook);
    }

    @PUT
    public Guestbook updateGuestbook(Guestbook guestbook) {
        return guestbookLocalService.updateGuestbook(guestbook);
    }

    @DELETE
    @Path("{guestbookId}")
    public Response deleteGuestbook(@PathParam("guestbookId") long guestbookId) {
        try {
            guestbookLocalService.deleteGuestbook(guestbookId);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
