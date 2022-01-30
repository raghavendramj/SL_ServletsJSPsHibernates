import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.simpilearn.config.AppConfig;
import com.simpilearn.model.Profile;

public class QualifierDemo {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Profile profile = (Profile) applicationContext.getBean("profile");
		profile.printAge();
		profile.printName();
	}

}
