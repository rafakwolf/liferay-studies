import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import templates from './GuestbookView.soy';
import {Config} from 'metal-state';
import {requestMVCResource, showNotification} from 'commons/commons.es';

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
                            id: 'confirmDeleteBtn',
                            label: 'Delete',
                            on: {
                                click: () => {
                                    const guestbookId = $(event.target).attr('guestbookid');

                                    const prefixedData = Liferay.Util.ns(this.portletNamespace, {guestbookId});

                                    requestMVCResource(this.siteURL + "&" + this.portletNamespace + "act=delete", prefixedData)
                                        .then(resp => {
                                            showNotification('Deleted', 'Guestbook deleted!', 'success', 'notifications').then(resp => {
                                                Liferay.SPA.app.reloadPage();
                                            });
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


    searchGuestbook() {
        var input, filter, table, tr, td, i;
        input = document.getElementById("searchGuestbook");
        filter = input.value.toUpperCase();
        table = document.getElementById("guestbookTable");
        tr = table.getElementsByTagName("tr");

        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
            if (td) {
                if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.visibility = "visible";
                } else {
                    tr[i].style.visibility = "hidden";
                }
            }
        }
    }

}

View.STATE = {
    portletId: Config.string(),
    siteURL: Config.string(),
    portletNamespace: Config.string()
};

// Register component
Soy.register(View, templates);

export default View;