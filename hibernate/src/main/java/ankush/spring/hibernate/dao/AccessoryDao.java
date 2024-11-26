package ankush.spring.hibernate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import ankush.spring.hibernate.entities.Accessory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class AccessoryDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public int saveAccessory(Accessory accessory) {
		int rows;	
		rows=(Integer)this.hibernateTemplate.save(accessory);
		return rows;
	}
	
}
