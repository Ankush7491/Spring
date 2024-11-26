package ankush.spring.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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
        System.out.println(applicationContext.getBean(DriverManagerDataSource.class).toString());
        System.out.println(applicationContext.getBean(DriverManagerDataSource.class).toString());
        
        AccessoryDao accessoryDao=applicationContext.getBean(AccessoryDao.class); 
        Accessory accessory=new Accessory();
        accessory.setAccessoryName("Silverlining");
        accessory.setType("Decorative");
        int rows=accessoryDao.saveAccessory(accessory);
        System.out.println(rows);
    }
}
