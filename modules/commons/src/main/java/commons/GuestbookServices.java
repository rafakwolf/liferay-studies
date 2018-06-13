package commons;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import guestbook.model.Guestbook;
import guestbook.model.impl.GuestbookImpl;
import guestbook.service.GuestbookLocalServiceUtil;

public class GuestbookServices {
    public void save(String guestbookName) {
        try {
            Long newGuestbookId = CounterLocalServiceUtil.increment(Guestbook.class.getName());
            Guestbook guestbook = new GuestbookImpl();
            guestbook.setGuestbookId(newGuestbookId);
            guestbook.setName(guestbookName);
            GuestbookLocalServiceUtil.addGuestbook(guestbook);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(long guestbookId, String guestbookName) {
        try {
            Guestbook guestbook = GuestbookLocalServiceUtil.fetchGuestbook(guestbookId);
            guestbook.setName(guestbookName);
            GuestbookLocalServiceUtil.updateGuestbook(guestbook);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(long guestbookId) {
        try {
            GuestbookLocalServiceUtil.deleteGuestbook(guestbookId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
