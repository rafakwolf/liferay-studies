import { Selector } from 'testcafe';

fixture `Liferay test`
    .page `http://localhost:8080/web/guest`;

test('Login test', async t => {
    await t
        .click('a.sign-in.text-default')
        .expect(Selector('.modal-title').innerText).eql('Sign In')
        .pressKey(process.platform == 'darwin' ? 'meta+a delete' : 'ctrl+a delete')
        .typeText('#_com_liferay_login_web_portlet_LoginPortlet_login','test@liferay.com')
        .typeText('#_com_liferay_login_web_portlet_LoginPortlet_password','R3m3mb3r1!')
        .click('span.lfr-btn-label')
        .expect(Selector('span.user-avatar-link').count).eql(1);

    Selector('span.user-avatar-link').count.then((resp)=> {
            console.log('Login avatar count : '+resp);
    });        
});