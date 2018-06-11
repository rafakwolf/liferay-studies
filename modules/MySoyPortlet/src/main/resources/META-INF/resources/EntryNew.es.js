import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import {Config} from 'metal-state';
import templates from './EntryNew.soy';
import { requestMVCResource } from 'commons/commons.es';

/**
 * New Entry Component
 */
class New extends Component {

   addEntry() {
        const prefixedData = Liferay.Util.ns(this.portletNamespace, {name:this.name, message:this.message});

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
}

New.STATE = {
    name: Config.string(),
    message: Config.string(),
    siteURL: Config.string(),
    portletNamespace: Config.string()
};

// Register component
Soy.register(New, templates);

export default New;