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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import guestbook.exception.NoSuchGuestbookException;

import guestbook.model.Guestbook;

/**
 * The persistence interface for the guestbook service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see guestbook.service.persistence.impl.GuestbookPersistenceImpl
 * @see GuestbookUtil
 * @generated
 */
@ProviderType
public interface GuestbookPersistence extends BasePersistence<Guestbook> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GuestbookUtil} to access the guestbook persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the guestbooks where name = &#63;.
	*
	* @param name the name
	* @return the matching guestbooks
	*/
	public java.util.List<Guestbook> findByNameSearch(java.lang.String name);

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
	public java.util.List<Guestbook> findByNameSearch(java.lang.String name,
		int start, int end);

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
	public java.util.List<Guestbook> findByNameSearch(java.lang.String name,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Guestbook> orderByComparator);

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
	public java.util.List<Guestbook> findByNameSearch(java.lang.String name,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Guestbook> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first guestbook in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching guestbook
	* @throws NoSuchGuestbookException if a matching guestbook could not be found
	*/
	public Guestbook findByNameSearch_First(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<Guestbook> orderByComparator)
		throws NoSuchGuestbookException;

	/**
	* Returns the first guestbook in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching guestbook, or <code>null</code> if a matching guestbook could not be found
	*/
	public Guestbook fetchByNameSearch_First(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<Guestbook> orderByComparator);

	/**
	* Returns the last guestbook in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching guestbook
	* @throws NoSuchGuestbookException if a matching guestbook could not be found
	*/
	public Guestbook findByNameSearch_Last(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<Guestbook> orderByComparator)
		throws NoSuchGuestbookException;

	/**
	* Returns the last guestbook in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching guestbook, or <code>null</code> if a matching guestbook could not be found
	*/
	public Guestbook fetchByNameSearch_Last(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<Guestbook> orderByComparator);

	/**
	* Returns the guestbooks before and after the current guestbook in the ordered set where name = &#63;.
	*
	* @param guestbookId the primary key of the current guestbook
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next guestbook
	* @throws NoSuchGuestbookException if a guestbook with the primary key could not be found
	*/
	public Guestbook[] findByNameSearch_PrevAndNext(long guestbookId,
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<Guestbook> orderByComparator)
		throws NoSuchGuestbookException;

	/**
	* Removes all the guestbooks where name = &#63; from the database.
	*
	* @param name the name
	*/
	public void removeByNameSearch(java.lang.String name);

	/**
	* Returns the number of guestbooks where name = &#63;.
	*
	* @param name the name
	* @return the number of matching guestbooks
	*/
	public int countByNameSearch(java.lang.String name);

	/**
	* Caches the guestbook in the entity cache if it is enabled.
	*
	* @param guestbook the guestbook
	*/
	public void cacheResult(Guestbook guestbook);

	/**
	* Caches the guestbooks in the entity cache if it is enabled.
	*
	* @param guestbooks the guestbooks
	*/
	public void cacheResult(java.util.List<Guestbook> guestbooks);

	/**
	* Creates a new guestbook with the primary key. Does not add the guestbook to the database.
	*
	* @param guestbookId the primary key for the new guestbook
	* @return the new guestbook
	*/
	public Guestbook create(long guestbookId);

	/**
	* Removes the guestbook with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param guestbookId the primary key of the guestbook
	* @return the guestbook that was removed
	* @throws NoSuchGuestbookException if a guestbook with the primary key could not be found
	*/
	public Guestbook remove(long guestbookId) throws NoSuchGuestbookException;

	public Guestbook updateImpl(Guestbook guestbook);

	/**
	* Returns the guestbook with the primary key or throws a {@link NoSuchGuestbookException} if it could not be found.
	*
	* @param guestbookId the primary key of the guestbook
	* @return the guestbook
	* @throws NoSuchGuestbookException if a guestbook with the primary key could not be found
	*/
	public Guestbook findByPrimaryKey(long guestbookId)
		throws NoSuchGuestbookException;

	/**
	* Returns the guestbook with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param guestbookId the primary key of the guestbook
	* @return the guestbook, or <code>null</code> if a guestbook with the primary key could not be found
	*/
	public Guestbook fetchByPrimaryKey(long guestbookId);

	@Override
	public java.util.Map<java.io.Serializable, Guestbook> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the guestbooks.
	*
	* @return the guestbooks
	*/
	public java.util.List<Guestbook> findAll();

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
	public java.util.List<Guestbook> findAll(int start, int end);

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
	public java.util.List<Guestbook> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Guestbook> orderByComparator);

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
	public java.util.List<Guestbook> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Guestbook> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the guestbooks from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of guestbooks.
	*
	* @return the number of guestbooks
	*/
	public int countAll();
}