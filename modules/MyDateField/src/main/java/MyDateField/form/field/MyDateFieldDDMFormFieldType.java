package MyDateField.form.field;

import com.liferay.dynamic.data.mapping.form.field.type.BaseDDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;

import org.osgi.service.component.annotations.Component;

/**
 * @author rafael.wolf
 */
@Component(
	immediate = true,
	property = {
		"ddm.form.field.type.display.order:Integer=9",
		"ddm.form.field.type.icon=text",
		"ddm.form.field.type.js.class.name=Liferay.DDM.Field.MyDateField",
		"ddm.form.field.type.js.module=MyDateField-form-field",
		"ddm.form.field.type.label=MyDateField-label",
		"ddm.form.field.type.name=MyDateField"
	},
	service = DDMFormFieldType.class
)
public class MyDateFieldDDMFormFieldType extends BaseDDMFormFieldType {

	@Override
	public String getName() {
		return "MyDateField";
	}

}