/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package guestbook.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import guestbook.model.Guestbook;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the guestbook service. This utility wraps {@link guestbook.service.persistence.impl.GuestbookPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GuestbookPersistence
 * @see guestbook.service.persistence.impl.GuestbookPersistenceImpl
 * @generated
 */
@ProviderType
public class GuestbookUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Guestbook guestbook) {
		getPersistence().clearCache(guestbook);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Guestbook> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Guestbook> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Guestbook> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Guestbook> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Guestbook update(Guestbook guestbook) {
		return getPersistence().update(guestbook);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Guestbook update(Guestbook guestbook,
		ServiceContext serviceContext) {
		return getPersistence().update(guestbook, serviceContext);
	}

	/**
	* Returns all the guestbooks where name = &#63;.
	*
	* @param name the name
	* @return the matching guestbooks
	*/
	public static List<Guestbook> findByNameSearch(String name) {
		return getPersistence().findByNameSearch(name);
	}

	/**
	* Returns a range of all the guestbooks where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GuestbookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of guestbooks
	* @param end the upper bound of the range of guestbooks (not inclusive)
	* @return the range of matching guestbooks
	*/
	public static List<Guestbook> findByNameSearch(String name, int start,
		int end) {
		return getPersistence().findByNameSearch(name, start, end);
	}

	/**
	* Returns an ordered range of all the guestbooks where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GuestbookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of guestbooks
	* @param end the upper bound of the range of guestbooks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching guestbooks
	*/
	public static List<Guestbook> findByNameSearch(String name, int start,
		int end, OrderByComparator<Guestbook> orderByComparator) {
		return getPersistence()
				   .findByNameSearch(name, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the guestbooks where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GuestbookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of guestbooks
	* @param end the upper bound of the range of guestbooks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching guestbooks
	*/
	public static List<Guestbook> findByNameSearch(String name, int start,
		int end, OrderByComparator<Guestbook> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByNameSearch(name, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first guestbook in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching guestbook
	* @throws NoSuchGuestbookException if a matching guestbook could not be found
	*/
	public static Guestbook findByNameSearch_First(String name,
		OrderByComparator<Guestbook> orderByComparator)
		throws guestbook.exception.NoSuchGuestbookException {
		return getPersistence().findByNameSearch_First(name, orderByComparator);
	}

	/**
	* Returns the first guestbook in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching guestbook, or <code>null</code> if a matching guestbook could not be found
	*/
	public static Guestbook fetchByNameSearch_First(String name,
		OrderByComparator<Guestbook> orderByComparator) {
		return getPersistence().fetchByNameSearch_First(name, orderByComparator);
	}

	/**
	* Returns the last guestbook in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching guestbook
	* @throws NoSuchGuestbookException if a matching guestbook could not be found
	*/
	public static Guestbook findByNameSearch_Last(String name,
		OrderByComparator<Guestbook> orderByComparator)
		throws guestbook.exception.NoSuchGuestbookException {
		return getPersistence().findByNameSearch_Last(name, orderByComparator);
	}

	/**
	* Returns the last guestbook in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching guestbook, or <code>null</code> if a matching guestbook could not be found
	*/
	public static Guestbook fetchByNameSearch_Last(String name,
		OrderByComparator<Guestbook> orderByComparator) {
		return getPersistence().fetchByNameSearch_Last(name, orderByComparator);
	}

	/**
	* Returns the guestbooks before and after the current guestbook in the ordered set where name = &#63;.
	*
	* @param guestbookId the primary key of the current guestbook
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next guestbook
	* @throws NoSuchGuestbookException if a guestbook with the primary key could not be found
	*/
	public static Guestbook[] findByNameSearch_PrevAndNext(long guestbookId,
		String name, OrderByComparator<Guestbook> orderByComparator)
		throws guestbook.exception.NoSuchGuestbookException {
		return getPersistence()
				   .findByNameSearch_PrevAndNext(guestbookId, name,
			orderByComparator);
	}

	/**
	* Removes all the guestbooks where name = &#63; from the database.
	*
	* @param name the name
	*/
	public static void removeByNameSearch(String name) {
		getPersistence().removeByNameSearch(name);
	}

	/**
	* Returns the number of guestbooks where name = &#63;.
	*
	* @param name the name
	* @return the number of matching guestbooks
	*/
	public static int countByNameSearch(String name) {
		return getPersistence().countByNameSearch(name);
	}

	/**
	* Caches the guestbook in the entity cache if it is enabled.
	*
	* @param guestbook the guestbook
	*/
	public static void cacheResult(Guestbook guestbook) {
		getPersistence().cacheResult(guestbook);
	}

	/**
	* Caches the guestbooks in the entity cache if it is enabled.
	*
	* @param guestbooks the guestbooks
	*/
	public static void cacheResult(List<Guestbook> guestbooks) {
		getPersistence().cacheResult(guestbooks);
	}

	/**
	* Creates a new guestbook with the primary key. Does not add the guestbook to the database.
	*
	* @param guestbookId the primary key for the new guestbook
	* @return the new guestbook
	*/
	public static Guestbook create(long guestbookId) {
		return getPersistence().create(guestbookId);
	}

	/**
	* Removes the guestbook with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param guestbookId the primary key of the guestbook
	* @return the guestbook that was removed
	* @throws NoSuchGuestbookException if a guestbook with the primary key could not be found
	*/
	public static Guestbook remove(long guestbookId)
		throws guestbook.exception.NoSuchGuestbookException {
		return getPersistence().remove(guestbookId);
	}

	public static Guestbook updateImpl(Guestbook guestbook) {
		return getPersistence().updateImpl(guestbook);
	}

	/**
	* Returns the guestbook with the primary key or throws a {@link NoSuchGuestbookException} if it could not be found.
	*
	* @param guestbookId the primary key of the guestbook
	* @return the guestbook
	* @throws NoSuchGuestbookException if a guestbook with the primary key could not be found
	*/
	public static Guestbook findByPrimaryKey(long guestbookId)
		throws guestbook.exception.NoSuchGuestbookException {
		return getPersistence().findByPrimaryKey(guestbookId);
	}

	/**
	* Returns the guestbook with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param guestbookId the primary key of the guestbook
	* @return the guestbook, or <code>null</code> if a guestbook with the primary key could not be found
	*/
	public static Guestbook fetchByPrimaryKey(long guestbookId) {
		return getPersistence().fetchByPrimaryKey(guestbookId);
	}

	public static java.util.Map<java.io.Serializable, Guestbook> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the guestbooks.
	*
	* @return the guestbooks
	*/
	public static List<Guestbook> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the guestbooks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GuestbookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of guestbooks
	* @param end the upper bound of the range of guestbooks (not inclusive)
	* @return the range of guestbooks
	*/
	public static List<Guestbook> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the guestbooks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GuestbookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of guestbooks
	* @param end the upper bound of the range of guestbooks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of guestbooks
	*/
	public static List<Guestbook> findAll(int start, int end,
		OrderByComparator<Guestbook> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the guestbooks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GuestbookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of guestbooks
	* @param end the upper bound of the range of guestbooks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of guestbooks
	*/
	public static List<Guestbook> findAll(int start, int end,
		OrderByComparator<Guestbook> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the guestbooks from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of guestbooks.
	*
	* @return the number of guestbooks
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GuestbookPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GuestbookPersistence, GuestbookPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GuestbookPersistence.class);

		ServiceTracker<GuestbookPersistence, GuestbookPersistence> serviceTracker =
			new ServiceTracker<GuestbookPersistence, GuestbookPersistence>(bundle.getBundleContext(),
				GuestbookPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}