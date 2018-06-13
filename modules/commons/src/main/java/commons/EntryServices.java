package commons;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import guestbook.model.Entry;
import guestbook.model.impl.EntryImpl;
import guestbook.service.EntryLocalServiceUtil;

public class EntryServices {

    public void save(String entryName, String email, String message, long userId, long guestbookId) {

        try {
            Long newEntryId = CounterLocalServiceUtil.increment(Entry.class.getName());

            Entry entry = new EntryImpl();

            entry.setEntryId(newEntryId);
            entry.setName(entryName);
            entry.setMessage(message);
            entry.setEmail(email);
            entry.setGuestbookId(guestbookId);
            entry.setUserId(userId);

            EntryLocalServiceUtil.addEntry(entry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(long entryId, String entryName, String email, String message, long userId, long guestbookId) {
        try {
            Entry entry = EntryLocalServiceUtil.fetchEntry(entryId);

            entry.setName(entryName);
            entry.setMessage(message);
            entry.setEmail(email);
            entry.setGuestbookId(guestbookId);
            entry.setUserId(userId);

            EntryLocalServiceUtil.updateEntry(entry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(long entryId) {
        try {
            EntryLocalServiceUtil.deleteEntry(entryId);
        } catch (PortalException e) {
            e.printStackTrace();
        }
    }

}
