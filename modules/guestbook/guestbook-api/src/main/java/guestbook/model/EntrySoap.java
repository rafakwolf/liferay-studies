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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link guestbook.service.http.EntryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see guestbook.service.http.EntryServiceSoap
 * @generated
 */
@ProviderType
public class EntrySoap implements Serializable {
	public static EntrySoap toSoapModel(Entry model) {
		EntrySoap soapModel = new EntrySoap();

		soapModel.setEntryId(model.getEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setName(model.getName());
		soapModel.setMessage(model.getMessage());
		soapModel.setGuestbookId(model.getGuestbookId());

		return soapModel;
	}

	public static EntrySoap[] toSoapModels(Entry[] models) {
		EntrySoap[] soapModels = new EntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EntrySoap[][] toSoapModels(Entry[][] models) {
		EntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new EntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EntrySoap[] toSoapModels(List<Entry> models) {
		List<EntrySoap> soapModels = new ArrayList<EntrySoap>(models.size());

		for (Entry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EntrySoap[soapModels.size()]);
	}

	public EntrySoap() {
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long pk) {
		setEntryId(pk);
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public long getGuestbookId() {
		return _guestbookId;
	}

	public void setGuestbookId(long guestbookId) {
		_guestbookId = guestbookId;
	}

	private long _entryId;
	private long _groupId;
	private String _name;
	private String _message;
	private long _guestbookId;
}