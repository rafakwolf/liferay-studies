create index IX_7AD77D1C on guestbook_Entry (groupId, guestbookId);
create unique index IX_673BE390 on guestbook_Entry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_54428521 on guestbook_Guestbook (groupId);
create unique index IX_12FFC11F on guestbook_Guestbook (uuid_[$COLUMN_LENGTH:75$], groupId);