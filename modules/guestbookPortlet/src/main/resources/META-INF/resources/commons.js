function toFormData(data) {
    const formData = new FormData();
    for (const [key, value] of Object.entries(data)) {
        formData.append(key, value);
    }

    return formData;
}

function requestMVCResource(url, data, method = 'POST') {

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

export { requestMVCResource }