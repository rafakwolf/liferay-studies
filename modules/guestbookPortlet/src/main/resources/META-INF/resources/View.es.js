import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import templates from './View.soy';
import {Config} from 'metal-state';
import { requestMVCResource } from './commons';

class View extends Component {

	deleteGuestbook(event) {

        YUI().use(
            'aui-modal',
            (Y) => {
                var modal = new Y.Modal(
                    {
                        bodyContent: 'Deleting guestbook...',
                        centered: true,
                        headerContent: 'Are you sure?',
                        render: '#modal',
                        zIndex: 999,
                    }
                ).render();

                modal.addToolbar(
                    [
                        {
                            label: 'Cancel',
                            on: {
                                click: () => {
                                    modal.hide();
                                }
                            }
                        },
                        {
                            label: 'Delete',
                            on: {
                                click: () => {

                                    const guestbookId = $('#btnDeleteGuestbook').attr('guestbookid');

                                    const prefixedData = Liferay.Util.ns(this.portletNamespace, {guestbookId});

                                    requestMVCResource(this.siteURL+"&"+this.portletNamespace+"act=delete", prefixedData)
                                        .then(resp => {
                                            alert("Guestbook deleted!");
                                            Liferay.SPA.app.reloadPage();
                                        }).catch(e => {
                                        console.log(e);
                                        alert('Ops, something is wrong :(' + e.message);
                                    });

                                    modal.hide();
                                }
                            }
                        }
                    ]
                );

            }
        );
	}

}

View.STATE = {
    siteURL: Config.string(),
    portletNamespace: Config.string()
};

// Register component
Soy.register(View, templates);

export default View;