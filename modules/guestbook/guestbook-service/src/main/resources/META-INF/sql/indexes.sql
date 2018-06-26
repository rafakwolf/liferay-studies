create index IX_3620081B on guestbook_Entry (name[$COLUMN_LENGTH:75$], groupId, guestbookId);
create unique index IX_673BE390 on guestbook_Entry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_62960702 on guestbook_Guestbook (name[$COLUMN_LENGTH:75$], groupId);
create unique index IX_12FFC11F on guestbook_Guestbook (uuid_[$COLUMN_LENGTH:75$], groupId);