AUI.add(
	'MyDateField-form-field',
	function(A) {
		var MyDateFieldField = A.Component.create(
			{
				ATTRS: {
					type: {
						value: 'MyDateField-form-field'
					}
				},

				EXTENDS: Liferay.DDM.Renderer.Field,

				NAME: 'MyDateField-form-field'

			}
		);

		Liferay.namespace('DDM.Field').MyDateField = MyDateFieldField;
	},
	'',
	{
		requires: ['liferay-ddm-form-renderer-field']
	}
);