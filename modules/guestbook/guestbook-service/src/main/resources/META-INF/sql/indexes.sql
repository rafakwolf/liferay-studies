create index IX_E1C73659 on guestbook_Entry (name[$COLUMN_LENGTH:75$]);
create unique index IX_673BE390 on guestbook_Entry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_A88EAA8 on guestbook_Guestbook (name[$COLUMN_LENGTH:75$]);
create unique index IX_12FFC11F on guestbook_Guestbook (uuid_[$COLUMN_LENGTH:75$], groupId);