import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import templates from './View.soy';
import { requestMVCResource } from './commons';

class View extends Component {

	deleteGuestbook(event) {

	    console.log(event);

        YUI().use(
            'aui-modal',
            function(Y) {
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
                                click: function() {
                                    modal.hide();
                                }
                            }
                        },
                        {
                            label: 'Delete',
                            on: {
                                click: function() {

                                    const prefixedData = Liferay.Util.ns(this.portletNamespace, this.guestbook);

                                    requestMVCResource(this.siteURL, prefixedData)
                                        .then(resp => {
                                            alert("Guestbook updated!");
                                            document.getElementById("backtoview").click();
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

// Register component
Soy.register(View, templates);

export default View;