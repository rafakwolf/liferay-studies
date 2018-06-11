import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import {Config} from 'metal-state';
import templates from './EntryEdit.soy';
import { requestMVCResource } from 'commons/commons.es';

/**
 * Edit Entry Component
 */
class Edit extends Component {

    updateEntry() {
        const prefixedData = Liferay.Util.ns(this.portletNamespace, this.entry);

        requestMVCResource(this.siteURL, prefixedData)
            .then(resp => {
                alert("Entry is updated!");
                document.getElementById("backtoview").click();
            }).catch(e => {
            console.log(e);
            alert('Ops, something is wrong :(' + e.message);
        });
    }

    changeName(event) {
        this.entry.name = event.target.value;
    }

    changeMessage(event) {
        this.entry.message = event.target.value;
    }
}

Edit.STATE = {
    entry: Config.shapeOf({
        entryId: Config.string(),
        name: Config.string(),
        message: Config.string()
    }),
    siteURL: Config.string(),
    portletNamespace: Config.string()
};

// Register component
Soy.register(Edit, templates);

export default Edit;