package presentation;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

/**
 * The class TextFactory is used to look up texts from a resource bundle.
 */
public class TextFactory {

	public static String getResourceText(String bundleName, String key) {
		String text;
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Application app = context.getApplication();
			ResourceBundle bundle = app.getResourceBundle(context, bundleName);
			text = bundle.getString(key);
		} catch (MissingResourceException e) {
			return "???" + key + "???";
		}
		return text;
	}
}