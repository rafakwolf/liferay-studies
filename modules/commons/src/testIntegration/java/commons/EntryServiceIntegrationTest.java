package commons;

import com.liferay.arquillian.containter.remote.enricher.Inject;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import guestbook.model.Entry;
import guestbook.model.Guestbook;
import guestbook.model.impl.EntryImpl;
import guestbook.model.impl.GuestbookImpl;
import guestbook.service.EntryLocalService;
import guestbook.service.GuestbookLocalService;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(Arquillian.class)
public class EntryServiceIntegrationTest {

    @Test
    public void testSaveEntry() {
        Guestbook savedGuestbook = createGuestbook();
        Entry result = createEntry(savedGuestbook);

        assertEquals(result.getName(), "My entry");
        assertEquals(result.getEmail(), "test@mail.com");
        assertEquals(result.getMessage(), "my message");
        assertEquals(result.getGuestbookId(), savedGuestbook.getGuestbookId());
    }

    @Test
    public void testDeleteEntry() throws PortalException {
        Guestbook savedGuestbook = createGuestbook();
        Entry result = createEntry(savedGuestbook);

        long entryId = result.getEntryId();

        entryService.deleteEntry(entryId);

        Entry findEntry = entryService.fetchEntry(entryId);

        assertNull(findEntry);
    }

    @Test
    public void testEditEntry() {
        Guestbook savedGuestbook = createGuestbook();
        Entry result = createEntry(savedGuestbook);

        result.setName(result.getName()+"-changed");
        result.setEmail("test2@mail.com");

        Entry updatedEntry = entryService.updateEntry(result);

        assertEquals(updatedEntry.getName(), "My entry-changed");
        assertEquals(updatedEntry.getEmail(), "test2@mail.com");
        assertEquals(updatedEntry.getMessage(), "my message");
        assertEquals(updatedEntry.getGuestbookId(), savedGuestbook.getGuestbookId());
    }


    private Entry createEntry(Guestbook guestbook) {
        long newEntryId = counterLocalService.increment(Entry.class.getName());

        Entry entry = new EntryImpl();
        entry.setEntryId(newEntryId);
        entry.setName("My entry");
        entry.setEmail("test@mail.com");
        entry.setMessage("my message");
        entry.setGuestbookId(guestbook.getGuestbookId());

        Entry result = entryService.addEntry(entry);

        return result;
    }

    private Guestbook createGuestbook() {
        long newGuestbookId = counterLocalService.increment(Guestbook.class.getName());

        Guestbook guestbook = new GuestbookImpl();
        guestbook.setGuestbookId(newGuestbookId);
        guestbook.setName("my test guestbook");

        return guestbookLocalService.addGuestbook(guestbook);
    }

    @Inject
    private EntryLocalService entryService;

    @Inject
    private GuestbookLocalService guestbookLocalService;

    @Inject
    private CounterLocalService counterLocalService;
}
