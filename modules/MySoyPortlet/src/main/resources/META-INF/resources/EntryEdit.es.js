import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import {Config} from 'metal-state';
import templates from './EntryEdit.soy';
import { requestMVCResource, showNotification } from 'commons/commons.es';

/**
 * Edit Entry Component
 */
class Edit extends Component {

    updateEntry() {
        const prefixedData = Liferay.Util.ns(this.portletNamespace, this.entry);

        requestMVCResource(this.siteURL, prefixedData)
            .then(resp => {
                showNotification("Success", "Entry updated!", "success", "notifications");
         }).catch(e => {
            console.log(e);
            alert('Ops, something is wrong :(' + e.message);
        });
    }

    changeName(event) {
        this.entry.name = event.target.value;
    }

    changeEmail(event) {
        this.entry.email = event.target.value;
    }

    changeMessage(event) {
        this.entry.message = event.target.value;
    }

    changeGuestbook(event) {
        this.entry.guestbookId = event.target.value;
    }
}

Edit.STATE = {
    id: Config.string(),
    backToViewURL: Config.string(),
    siteURL: Config.string(),
    portletNamespace: Config.string(),
    entry: Config.shapeOf({
        entryId: Config.string(),
        name: Config.string(),
        email: Config.string(),
        message: Config.string(),
        guestbookId: Config.string()
    }),
    guestbooks: Config.arrayOf(
        Config.shapeOf({
            guestbookId: Config.string(),
            name: Config.string()
        })
    )
};

// Register component
Soy.register(Edit, templates);

export default Edit;