import { Selector } from 'testcafe';

fixture `Liferay Guestbook test`
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

test('Add Guestbook test', async t => {
    await t
        .click('#addGuestbookBtn')
        .typeText('#guestbookFieldName', 'My Testcafe guestbook name')
        .click('#saveGuestbook')
        .expect(Selector('.yui3-widget-bd').innerText).contains("Guestbook stored")
        .click('#backtoview');
});

test('Edit Guestbook test', async t => {
    await t
        .click('#editGuestbookLink')
        .typeText('#guestbookNameField', '---changed')
        .click('#updateGuestbookBtn')
        .expect(Selector('.yui3-widget-bd').innerText).contains("Guestbook updated")
        .click('#backtoview');
});

test('Delete Guestbook test', async t => {
    await t
        .click('#btnDeleteGuestbook')
        .click('#confirmDeleteBtn')
        .expect(Selector('.alert-success').innerText).contains("Guestbook deleted");
});