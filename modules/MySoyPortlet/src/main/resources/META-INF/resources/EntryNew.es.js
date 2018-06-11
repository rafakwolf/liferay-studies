import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import {Config} from 'metal-state';
import templates from './EntryNew.soy';
import {requestMVCResource} from 'commons/commons.es';

/**
 * New Entry Component
 */
class EntryNew extends Component {

    addEntry() {
        const prefixedData = Liferay.Util.ns(this.portletNamespace,
            {name: this.name, message: this.message, guestbookId: this.guestbookId});

        requestMVCResource(this.siteURL, prefixedData)
            .then(resp => {
                alert("Entry is stored!");
                document.getElementById("backtoview").click();
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

    changeGuestbook(event) {
        this.guestbookId = event.target.value;
    }
}

EntryNew.STATE = {
    name: Config.string(),
    message: Config.string(),
    guestbookId: Config.string(),
    siteURL: Config.string(),
    portletNamespace: Config.string(),
    guestbooks: Config.arrayOf(
        Config.shapeOf({
            guestbookId: Config.string(),
            name: Config.string()
        })
    )
};

// Register component
Soy.register(EntryNew, templates);

export default EntryNew;