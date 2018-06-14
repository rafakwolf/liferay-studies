function requestMVCResource(url, data, method = 'POST') {

    const formData = new FormData();
    for (const [key, value] of Object.entries(data)) {
        formData.append(key, value);
    }

    return new Promise((resolve, reject) => {
        fetch(url, {
            body: formData,
            credentials: 'include',
            method: method
        })
        .then(response => {
            const contentType = response.headers.get("content-type");

            if (contentType && contentType.indexOf("application/json") !== -1) {
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
            } else {
                if (response.status < 400) {
                    response.text().then(txt => resolve(txt));
                    return;
                }

                response.text()
                    .then(txt => reject(txt))
                    .catch((e) => {
                        if (response.status == 401) {
                            Liferay.SPA.app.reloadPage();
                        } else {
                            reject({error: true, isUnexpected: true, errorMessage: e.message});
                        }
                    });
            }
        })
        .catch((e) => reject({error: true, isUnexpected: true, errorMessage: e.message}));
    });
}

function showNotification(title, message, type, targetElementId) {
    new Liferay.Alert(
        {
            closeable: true,
            delay: {
                hide: 1000,
                show: 0
            },
            duration: 1000,
            icon: type,
            message: message,
            namespace: 'notification',
            title: title,
            type: type
        }
    ).render(document.getElementById(targetElementId));
}

export { requestMVCResource, showNotification }