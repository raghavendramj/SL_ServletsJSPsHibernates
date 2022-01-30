import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.simpilearn.config.AppConfig;
import com.simpilearn.model.Bank;
import com.simpilearn.model.Car;
import com.simpilearn.model.ICICIBank;
import com.simpilearn.model.Vehicle;

public class App {

	public void xmlBasedConfig() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Vehicle bike = (Vehicle) applicationContext.getBean("bike");
		bike.drive();

		Vehicle car = (Vehicle) applicationContext.getBean("car");
		car.drive();

		Bank iciciBank = (Bank) applicationContext.getBean("icici");
		iciciBank.balance();

		Bank hdfcBank = (Bank) applicationContext.getBean("hdfc");
		hdfcBank.balance();
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Bank icicBankInstance = applicationContext.getBean(ICICIBank.class);
		icicBankInstance.balance();
		
		Vehicle bike = (Vehicle) applicationContext.getBean(Car.class);
		bike.drive();
	}
}
