package guestbookportlet.portlet;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;
import guestbookportlet.constants.GuestbookPortletPortletKeys;

import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.portlet.bridge.soy.SoyPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author rafael.wolf
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.single-page-application=false",
		"javax.portlet.display-name=guestbookPortlet Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=View",
		"javax.portlet.name=" + GuestbookPortletPortletKeys.GuestbookPortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GuestbookPortletPortlet extends SoyPortlet {

	public static void main(String[] args) {
		CacheRegistryUtil.clear(); // - to clear all the Database caches
		MultiVMPoolUtil.clear();   // - clearing cache across JVM clusters
		WebCachePoolUtil.clear(); // - clearing cache in XsiNilLoader. Single VM
	}

}