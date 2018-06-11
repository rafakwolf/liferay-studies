import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import templates from './EntryView.soy';
import { requestMVCResource } from 'commons/commons.es';
import {Config} from 'metal-state';

/**
 * View Component
 */
class View extends Component {

    deleteEntry() {
        YUI().use(
            'aui-modal',
            (Y) => {
                var modal = new Y.Modal(
                    {
                        bodyContent: 'Deleting entry...',
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
                                    const entryId = $('#btnDeleteEntry').attr('entryid');

                                    const prefixedData = Liferay.Util.ns(this.portletNamespace, {entryId});

                                    requestMVCResource(this.siteURL+"&"+this.portletNamespace+"act=delete", prefixedData)
                                        .then(resp => {
                                            alert("Entry deleted!");
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

// Register component
Soy.register(View, templates);

export default View;