package commons;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.bean.BeanLocator;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import guestbook.model.Entry;
import guestbook.model.Guestbook;
import guestbook.service.GuestbookLocalService;
import guestbook.service.GuestbookLocalServiceUtil;
import guestbook.service.util.ServiceProps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@PrepareForTest({ConfigurationFactoryUtil.class, ServiceProps.class})
@RunWith(PowerMockRunner.class)
public class EntryServicesTest {

    private GuestbookServices guestbookServices;
    private EntryServices entryServices;

    @Before
    public void setUp() {
        mockStatic(ConfigurationFactoryUtil.class);
        mockStatic(ServiceProps.class);
        //mockStatic(FrameworkUtil.class);


        /* BeanLocator */
        BeanLocator beanLocator = PowerMockito.mock(BeanLocator.class);
        when(beanLocator.getClassLoader())
                .thenReturn(Thread.currentThread().getContextClassLoader());
        PortalBeanLocatorUtil.setBeanLocator(beanLocator);




        /* CounterService */
        CounterLocalService counterLocalService = PowerMockito.mock(CounterLocalService.class);
        when(beanLocator.locate(Mockito.eq(CounterLocalService.class.getName())))
                .thenReturn(counterLocalService);
        when(counterLocalService.increment(anyString())).thenReturn(new Random().nextLong());




        /* GuestbookService */
        GuestbookLocalService guestbookLocalService = PowerMockito.mock(GuestbookLocalService.class);
        when(beanLocator.locate(Mockito.eq(GuestbookLocalService.class.getName())))
                .thenReturn(guestbookLocalService);



//
//        Bundle bundle = PowerMockito.mock(Bundle.class);
//        BundleContext bundleContext = PowerMockito.mock(BundleContext.class);
//        when(bundle.getBundleContext()).thenReturn(bundleContext);
//        when(FrameworkUtil.getBundle(GuestbookLocalService.class))
//                .thenReturn(bundle);





      //  ServiceTracker serviceTracker = PowerMockito.mock(ServiceTracker.class);


//        GuestbookLocalServiceUtil mockGuestbookLocalServiceUtil = PowerMockito.mock(GuestbookLocalServiceUtil.class);
//        mockGuestbookLocalServiceUtil.


        //serviceTracker.addingService()







        //when(serviceTracker.getService()).thenReturn(guestbookLocalService);




       // when(GuestbookLocalServiceUtil.getService()).thenReturn(guestbookLocalService);



        guestbookServices = new GuestbookServices();
        entryServices = new EntryServices();
    }

    @After
    public void tearDown() {
        entryServices = null;
        guestbookServices = null;

        //PortalBeanLocatorUtil.setBeanLocator(null);
    }

    @Test
    public void save() {
        Guestbook guestbook = guestbookServices.save("guestbook test");

        Entry entry = entryServices.save(
                "My entry", "test@mail.com",
                "my message", 0, guestbook.getGuestbookId());

        assertEquals(entry.getName(), "My entry");
        assertEquals(entry.getEmail(), "test@mail.com");
        assertEquals(entry.getMessage(), "my message");
        assertEquals(entry.getGuestbookId(), guestbook.getGuestbookId());
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}