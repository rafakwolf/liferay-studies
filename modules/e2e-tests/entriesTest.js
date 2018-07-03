import { Selector } from 'testcafe';

fixture `Liferay Entries test`
    .page `http://localhost:8080/web/guest`;

test('Login test', async t => {
    await t
        .click('a.sign-in.text-default')
        .expect(Selector('.modal-title').innerText).eql('Sign In')
        .pressKey(process.platform === 'darwin' ? 'meta+a delete' : 'ctrl+a delete')
        .typeText('#_com_liferay_login_web_portlet_LoginPortlet_login','test@liferay.com')
        .typeText('#_com_liferay_login_web_portlet_LoginPortlet_password','R3m3mb3r1!')
        .click('span.lfr-btn-label')
        .expect(Selector('span.user-avatar-link').count).eql(1);
});

test('Add Entry test', async t => {

    await t
        .hover('#portlet_MySoyPortlet', { offsetY: 100 })
        .click('#portlet_MySoyPortlet');

    await t
        .click('#newEntryBtn')
        .click(Selector('#guestbookSelect'))
        .typeText('#entryName', 'My Testcafe entry name')
        .typeText('#entryEmail', 'My Testcafe entry email')
        .typeText('#entryMessage', 'My Testcafe entry message')
        .click('#saveEntryBtn')
        .expect(Selector('.alert-success').innerText).contains("Entry stored")
        .click('#backtoview');
});

test('Edit Entry test', async t => {

    await t
        .hover('#portlet_MySoyPortlet', { offsetY: 100 })
        .click('#portlet_MySoyPortlet');

    await t
        .click('#editEntryBtn')
        .click(Selector('#guestbookSelect'))
        .typeText('#entryName', '---changed')
        .typeText('#entryEmail', '---changed')
        .typeText('#entryMessage', '---changed')
        .click('#updateEntryBtn')
        .expect(Selector('.alert-success').innerText).contains("Entry updated")
        .click('#backtoview');
});

test('Delete Entry test', async t => {

    await t
        .hover('#portlet_MySoyPortlet', { offsetY: 100 })
        .click('#portlet_MySoyPortlet');

    await t
        .click('#btnDeleteEntry')
        .click('#btnDeleteEntryConfirm')
        .expect(Selector('.alert-success').innerText).contains("Entry deleted");
});