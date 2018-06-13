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

import guestbook.model.Guestbook;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Guestbook in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Guestbook
 * @generated
 */
@ProviderType
public class GuestbookCacheModel implements CacheModel<Guestbook>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GuestbookCacheModel)) {
			return false;
		}

		GuestbookCacheModel guestbookCacheModel = (GuestbookCacheModel)obj;

		if (guestbookId == guestbookCacheModel.guestbookId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, guestbookId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", guestbookId=");
		sb.append(guestbookId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Guestbook toEntityModel() {
		GuestbookImpl guestbookImpl = new GuestbookImpl();

		if (uuid == null) {
			guestbookImpl.setUuid("");
		}
		else {
			guestbookImpl.setUuid(uuid);
		}

		guestbookImpl.setGuestbookId(guestbookId);
		guestbookImpl.setGroupId(groupId);

		if (name == null) {
			guestbookImpl.setName("");
		}
		else {
			guestbookImpl.setName(name);
		}

		guestbookImpl.resetOriginalValues();

		return guestbookImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		guestbookId = objectInput.readLong();

		groupId = objectInput.readLong();
		name = objectInput.readUTF();
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

		objectOutput.writeLong(guestbookId);

		objectOutput.writeLong(groupId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public String uuid;
	public long guestbookId;
	public long groupId;
	public String name;
}