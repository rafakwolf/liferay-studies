package commons;

import com.liferay.arquillian.containter.remote.enricher.Inject;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import guestbook.model.Guestbook;
import guestbook.model.impl.GuestbookImpl;
import guestbook.service.GuestbookLocalService;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(Arquillian.class)
public class GuestbookServiceIntegrationTest {

    @Test
    public void testSaveGuestbook() {
        Guestbook guestbook = createGuestbook();

        assertEquals(guestbook.getName(), "my test guestbook");
    }

    @Test
    public void testEditGuestbook() {
        Guestbook guestbook = createGuestbook();

        guestbook.setName(guestbook.getName()+"-changed");
        guestbookLocalService.updateGuestbook(guestbook);

        assertEquals(guestbook.getName(), "my test guestbook-changed");
    }

    @Test
    public void testDeleteGuestbook() throws PortalException {
        Guestbook guestbook = createGuestbook();

        long guestbookId = guestbook.getGuestbookId();

        guestbookLocalService.deleteGuestbook(guestbookId);

        Guestbook findGuestbook = guestbookLocalService.fetchGuestbook(guestbookId);

        assertNull(findGuestbook);
    }

    private Guestbook createGuestbook() {
        long newGuestbookId = counterLocalService.increment(Guestbook.class.getName());

        Guestbook guestbook = new GuestbookImpl();
        guestbook.setGuestbookId(newGuestbookId);
        guestbook.setName("my test guestbook");

        return guestbookLocalService.addGuestbook(guestbook);
    }

    @Inject
    private GuestbookLocalService guestbookLocalService;

    @Inject
    private CounterLocalService counterLocalService;
}
