import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingletonFactory {

	private static SessionFactory factory;
	
	private SingletonFactory() {
		// TO AVOID INSTANTIOTION
	}
	
	public static synchronized SessionFactory getFactory() {
		
		if(factory == null) {
			
			// CREATING CONFIGURATION
			Configuration config = new Configuration()
					.configure("config.cfg.xml")
					.addAnnotatedClass(User.class);
			
			// CREATING SESSION FACTORY
			factory = config.buildSessionFactory();
		}
		
		return factory;
	}
}
