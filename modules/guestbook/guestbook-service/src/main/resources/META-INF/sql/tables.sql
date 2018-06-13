create table guestbook_Entry (
	uuid_ VARCHAR(75) null,
	entryId LONG not null primary key,
	groupId LONG,
	name VARCHAR(75) null,
	message VARCHAR(75) null,
	email VARCHAR(75) null,
	guestbookId LONG,
	userId LONG,
	userName VARCHAR(75) null
);

create table guestbook_Guestbook (
	uuid_ VARCHAR(75) null,
	guestbookId LONG not null primary key,
	groupId LONG,
	name VARCHAR(75) null
);