import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import {Config} from 'metal-state';
import templates from './GuestbookEdit.soy';
import { requestMVCResource, showNotification } from 'commons/commons.es';

/**
 * Edit Guestbook Component
 */
class Edit extends Component {

    updateGuestbook() {
        const prefixedData = Liferay.Util.ns(this.portletNamespace, this.guestbook);

        requestMVCResource(this.siteURL, prefixedData)
            .then(resp => {
                showNotification('Updated', 'Guestbook updated!', 'success', 'notifications');
            }).catch(e => {
            console.log(e);
            alert('Ops, something is wrong :(' + e.message);
        });
    }

    changeName(event) {
        this.guestbook.name = event.target.value;
    }
}

Edit.STATE = {
    guestbook: Config.shapeOf({
        guestbookId: Config.string(),
        name: Config.string()
    }),
    siteURL: Config.string(),
    portletNamespace: Config.string()
};

// Register component
Soy.register(Edit, templates);

export default Edit;