import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import {Config} from 'metal-state';
import templates from './New.soy';

/**
 * New Guestbook Component
 */
class New extends Component {

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

    addGuestbook() {
        const prefixedData = Liferay.Util.ns(this.portletNamespace, {name: this.name});

        this.requestMVCResource(this.siteURL, prefixedData)
            .then(resp => {
                alert("Guestbook is stored!");
                document.getElementById("backtoview").click();
            }).catch(e => {
            console.log(e);
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