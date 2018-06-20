import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import {Config} from 'metal-state';
import templates from './EntryNew.soy';
import {requestMVCResource, showNotification} from 'commons/commons.es';

/**
 * New Entry Component
 */
class EntryNew extends Component {

    addEntry() {
        const prefixedData = Liferay.Util.ns(this.portletNamespace,
            {name: this.name, message: this.message, email: this.email, guestbookId: this.guestbookId});

        requestMVCResource(this.siteURL, prefixedData)
            .then(resp => {
                showNotification("Success", "Entry stored!", "success", "notifications");
            }).catch(e => {
            console.log(e);
            alert('Ops, something is wrong :(' + e.message);
        });
    }

    changeName(event) {
        this.name = event.target.value;
    }

    changeMessage(event) {
        this.message = event.target.value;
    }

    changeEmail(event) {
        this.email = event.target.email;
    }

    changeGuestbook(event) {
        this.guestbookId = event.target.value;
    }
}

EntryNew.STATE = {
    name: Config.string(),
    message: Config.string(),
    email: Config.string(),
    guestbookId: Config.number(),
    siteURL: Config.string(),
    portletNamespace: Config.string(),
    guestbooks: Config.arrayOf(
        Config.shapeOf({
            guestbookId: Config.number(),
            name: Config.string()
        })
    )
};

// Register component
Soy.register(EntryNew, templates);

export default EntryNew;