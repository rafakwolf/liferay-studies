;(function() {
	AUI().applyConfig(
		{
			groups: {
				'MyDateField-group': {
					base: MODULE_PATH + '/',
					combine: Liferay.AUI.getCombine(),
					filter: Liferay.AUI.getFilterConfig(),
					modules: {
						'MyDateField-form-field': {
							condition: {
								trigger: 'liferay-ddm-form-renderer'
							},
							path: 'MyDateField_field.js',
							requires: [
								'liferay-ddm-form-renderer-field'
							]
						},
						'MyDateField-form-field-template': {
							condition: {
								trigger: 'liferay-ddm-form-renderer'
							},
							path: 'MyDateField.soy.js',
							requires: [
								'soyutils'
							]
						}
					},
					root: MODULE_PATH + '/'
				}
			}
		}
	);
})();