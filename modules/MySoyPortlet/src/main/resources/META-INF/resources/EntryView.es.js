import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import templates from './EntryView.soy';
import {requestMVCResource, showNotification} from 'commons/commons.es';
import {Config} from 'metal-state';

/**
 * View Component
 */
class View extends Component {

    deleteEntry(event) {

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
                                    const entryId = $(event.target).attr('entryid');

                                    const prefixedData = Liferay.Util.ns(this.portletNamespace, {entryId});

                                    requestMVCResource(this.siteURL + "&" + this.portletNamespace + "act=delete", prefixedData)
                                        .then(resp => {
                                            showNotification("Success", "Entry deleted!", "success", "notifications");
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
    viewUrl: Config.string(),
    entries: Config.arrayOf(
        Config.shapeOf({
            entryId: Config.string(),
            name: Config.string(),
            message: Config.string(),
            email: Config.string(),
            guestbookId: Config.string()
        })
    )
};

// Register component
Soy.register(View, templates);

export default View;