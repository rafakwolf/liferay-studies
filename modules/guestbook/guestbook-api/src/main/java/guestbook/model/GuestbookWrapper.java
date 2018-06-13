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

package guestbook.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Guestbook}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Guestbook
 * @generated
 */
@ProviderType
public class GuestbookWrapper implements Guestbook, ModelWrapper<Guestbook> {
	public GuestbookWrapper(Guestbook guestbook) {
		_guestbook = guestbook;
	}

	@Override
	public Class<?> getModelClass() {
		return Guestbook.class;
	}

	@Override
	public String getModelClassName() {
		return Guestbook.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("guestbookId", getGuestbookId());
		attributes.put("groupId", getGroupId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long guestbookId = (Long)attributes.get("guestbookId");

		if (guestbookId != null) {
			setGuestbookId(guestbookId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public Object clone() {
		return new GuestbookWrapper((Guestbook)_guestbook.clone());
	}

	@Override
	public int compareTo(Guestbook guestbook) {
		return _guestbook.compareTo(guestbook);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _guestbook.getExpandoBridge();
	}

	/**
	* Returns the group ID of this guestbook.
	*
	* @return the group ID of this guestbook
	*/
	@Override
	public long getGroupId() {
		return _guestbook.getGroupId();
	}

	/**
	* Returns the guestbook ID of this guestbook.
	*
	* @return the guestbook ID of this guestbook
	*/
	@Override
	public long getGuestbookId() {
		return _guestbook.getGuestbookId();
	}

	/**
	* Returns the name of this guestbook.
	*
	* @return the name of this guestbook
	*/
	@Override
	public String getName() {
		return _guestbook.getName();
	}

	/**
	* Returns the primary key of this guestbook.
	*
	* @return the primary key of this guestbook
	*/
	@Override
	public long getPrimaryKey() {
		return _guestbook.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _guestbook.getPrimaryKeyObj();
	}

	/**
	* Returns the uuid of this guestbook.
	*
	* @return the uuid of this guestbook
	*/
	@Override
	public String getUuid() {
		return _guestbook.getUuid();
	}

	@Override
	public int hashCode() {
		return _guestbook.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _guestbook.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _guestbook.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _guestbook.isNew();
	}

	@Override
	public void persist() {
		_guestbook.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_guestbook.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_guestbook.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_guestbook.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_guestbook.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this guestbook.
	*
	* @param groupId the group ID of this guestbook
	*/
	@Override
	public void setGroupId(long groupId) {
		_guestbook.setGroupId(groupId);
	}

	/**
	* Sets the guestbook ID of this guestbook.
	*
	* @param guestbookId the guestbook ID of this guestbook
	*/
	@Override
	public void setGuestbookId(long guestbookId) {
		_guestbook.setGuestbookId(guestbookId);
	}

	/**
	* Sets the name of this guestbook.
	*
	* @param name the name of this guestbook
	*/
	@Override
	public void setName(String name) {
		_guestbook.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_guestbook.setNew(n);
	}

	/**
	* Sets the primary key of this guestbook.
	*
	* @param primaryKey the primary key of this guestbook
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_guestbook.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_guestbook.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this guestbook.
	*
	* @param uuid the uuid of this guestbook
	*/
	@Override
	public void setUuid(String uuid) {
		_guestbook.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Guestbook> toCacheModel() {
		return _guestbook.toCacheModel();
	}

	@Override
	public Guestbook toEscapedModel() {
		return new GuestbookWrapper(_guestbook.toEscapedModel());
	}

	@Override
	public String toString() {
		return _guestbook.toString();
	}

	@Override
	public Guestbook toUnescapedModel() {
		return new GuestbookWrapper(_guestbook.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _guestbook.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GuestbookWrapper)) {
			return false;
		}

		GuestbookWrapper guestbookWrapper = (GuestbookWrapper)obj;

		if (Objects.equals(_guestbook, guestbookWrapper._guestbook)) {
			return true;
		}

		return false;
	}

	@Override
	public Guestbook getWrappedModel() {
		return _guestbook;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _guestbook.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _guestbook.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_guestbook.resetOriginalValues();
	}

	private final Guestbook _guestbook;
}