package mysoyportlet.portlet;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;
import com.liferay.portal.portlet.bridge.soy.SoyPortlet;
import mysoyportlet.constants.MySoyPortletPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

/**
 * @author rafael
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.single-page-application=true",
		"javax.portlet.display-name=MySoyPortlet Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=EntryView",
		"javax.portlet.name=" + MySoyPortletPortletKeys.MySoyPortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.expiration-cache=0"
	},
	service = Portlet.class
)
public class MySoyPortletPortlet extends SoyPortlet {


	public static void main(String[] args) {
		CacheRegistryUtil.clear(); // - to clear all the Database caches
		MultiVMPoolUtil.clear();   // - clearing cache across JVM clusters
		WebCachePoolUtil.clear(); //- clearing cache in XsiNilLoader. Single VM
	}
}