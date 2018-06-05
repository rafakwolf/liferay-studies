import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import {Config} from 'metal-state';
import templates from './Edit.soy';

/**
 * Edit Entry Component
 */
class Edit extends Component {

    toFormData(data) {
        const formData = new FormData();
        for (const [key, value] of Object.entries(data)) {
            formData.append(key, value);
        }

        return formData;
    }

    requestMVCResource(url, data, method = 'POST') {

        return new Promise((resolve, reject) => {
            fetch(url, {
                body: this.toFormData(data),
                credentials: 'include',
                method: method
            })
                .then(response => {
                    if (response.status < 400) {
                        response.json().then(json => resolve(json));
                        return;
                    }

                    response.json()
                        .then(json => reject(json))
                        .catch((e) => {
                            if (response.status == 401) {
                                Liferay.SPA.app.reloadPage();
                            } else {
                                reject({error: true, isUnexpected: true, errorMessage: e.message});
                            }
                        });

                })
                .catch((e) => reject({error: true, isUnexpected: true, errorMessage: e.message}));
        });
    }

    updateEntry() {
        const prefixedData = Liferay.Util.ns(this.portletNamespace, this.entry);

        this.requestMVCResource(this.siteURL, prefixedData)
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