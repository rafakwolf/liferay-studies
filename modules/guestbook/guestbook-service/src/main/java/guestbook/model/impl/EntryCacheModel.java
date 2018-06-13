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

package guestbook.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import guestbook.model.Entry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Entry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Entry
 * @generated
 */
@ProviderType
public class EntryCacheModel implements CacheModel<Entry>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EntryCacheModel)) {
			return false;
		}

		EntryCacheModel entryCacheModel = (EntryCacheModel)obj;

		if (entryId == entryCacheModel.entryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, entryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", entryId=");
		sb.append(entryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", message=");
		sb.append(message);
		sb.append(", email=");
		sb.append(email);
		sb.append(", guestbookId=");
		sb.append(guestbookId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Entry toEntityModel() {
		EntryImpl entryImpl = new EntryImpl();

		if (uuid == null) {
			entryImpl.setUuid("");
		}
		else {
			entryImpl.setUuid(uuid);
		}

		entryImpl.setEntryId(entryId);
		entryImpl.setGroupId(groupId);

		if (name == null) {
			entryImpl.setName("");
		}
		else {
			entryImpl.setName(name);
		}

		if (message == null) {
			entryImpl.setMessage("");
		}
		else {
			entryImpl.setMessage(message);
		}

		if (email == null) {
			entryImpl.setEmail("");
		}
		else {
			entryImpl.setEmail(email);
		}

		entryImpl.setGuestbookId(guestbookId);
		entryImpl.setUserId(userId);

		if (userName == null) {
			entryImpl.setUserName("");
		}
		else {
			entryImpl.setUserName(userName);
		}

		entryImpl.resetOriginalValues();

		return entryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		entryId = objectInput.readLong();

		groupId = objectInput.readLong();
		name = objectInput.readUTF();
		message = objectInput.readUTF();
		email = objectInput.readUTF();

		guestbookId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(entryId);

		objectOutput.writeLong(groupId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(guestbookId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}
	}

	public String uuid;
	public long entryId;
	public long groupId;
	public String name;
	public String message;
	public String email;
	public long guestbookId;
	public long userId;
	public String userName;
}