import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class ConverteData {

	static Date stringToDate(String dataString) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		Date data = null;
		try {
			data = dateFormat.parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return data;
	}

}