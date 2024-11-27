package ankush.spring.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ankush.spring.hibernate.configurations.HibernateConfiguration;
import ankush.spring.hibernate.dao.AccessoryDao;
import ankush.spring.hibernate.entities.Accessory;

/**
 * Hello world!
 *
 */
public class HibernateApp 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(HibernateConfiguration.class); 
        AccessoryDao accessoryDao=applicationContext.getBean(AccessoryDao.class); 
        Accessory accessory=new Accessory();
        accessory.setAccessoryName("MusicSystem");
        accessory.setType("Fun");
		/*
		 * int rows=accessoryDao.saveAccessory(accessory); System.out.println(rows);
		 *        System.out.println(accessoryDao.getAccessories().toString());
		 *        */
        accessory.setId(3);
        accessory.setType("Music");
        try {
        	accessoryDao.updateAccessory(accessory);	
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
        System.out.println(accessoryDao.getAccessory(3).toString());
        
        
    }
}
