import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import templates from './View.soy';

/**
 * View Component
 */
class View extends Component {


    deleteEntry() {
        YUI().use(
            'aui-modal',
            function(Y) {
                var modal = new Y.Modal(
                    {
                        bodyContent: 'Deleting entry...',
                        centered: true,
                        headerContent: 'Are you sure?',
                        render: '#modal',
                        zIndex: 999,
                    }
                ).render();

                modal.addToolbar(
                    [
                        {
                            label: 'Cancel',
                            on: {
                                click: function() {
                                    modal.hide();
                                }
                            }
                        },
                        {
                            label: 'Delete',
                            on: {
                                click: function() {
                                    alert('Just an example, there will be no printing here.');
                                    modal.hide();
                                }
                            }
                        }
                    ]
                );

            }
        );
    }

}

// Register component
Soy.register(View, templates);

export default View;