create table guestbook_Entry (
	entryId LONG not null primary key,
	groupId LONG,
	name VARCHAR(75) null,
	message VARCHAR(75) null,
	guestbookId LONG
);

create table guestbook_Guestbook (
	guestbookId LONG not null primary key,
	groupId LONG,
	name VARCHAR(75) null
);