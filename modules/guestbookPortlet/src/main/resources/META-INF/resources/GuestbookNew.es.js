import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import {Config} from 'metal-state';
import templates from './GuestbookNew.soy';
import { requestMVCResource, showNotification } from 'commons/commons.es';

/**
 * New Guestbook Component
 */
class New extends Component {

    addGuestbook() {
        const prefixedData = Liferay.Util.ns(this.portletNamespace, {name: this.name});

        requestMVCResource(this.siteURL, prefixedData)
            .then(() => {
                showNotification('Success', 'Guestbook stored!', 'success', 'notifications');
            }).catch(e => {
                alert('Ops, something is wrong :(' + e.message);
            });
    }

    changeName(event) {
        this.name = event.target.value;
    }
}

New.STATE = {
    name: Config.string(),
    siteURL: Config.string(),
    portletNamespace: Config.string()
};

// Register component
Soy.register(New, templates);

export default New;