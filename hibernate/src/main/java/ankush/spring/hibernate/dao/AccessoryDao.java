package ankush.spring.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ankush.spring.hibernate.entities.Accessory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class AccessoryDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int saveAccessory(Accessory accessory) {
		int rows;	
		rows=(Integer)this.hibernateTemplate.save(accessory);
		return rows;
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void updateAccessory(Accessory accessory) {
		Accessory accessory2=getAccessory(accessory.getId());
		accessory2.setType(accessory.getType());
		System.out.println("Accessory from DB after update "+accessory2.toString());
		this.hibernateTemplate.saveOrUpdate(accessory2);
	}
	
	@Transactional
	public List<Accessory> getAccessories() {
		return this.hibernateTemplate.loadAll(Accessory.class);
	}
	
	@Transactional
	public void deleteAccessory(int id) {
		 this.hibernateTemplate.delete("id",Integer.valueOf(id));
	}
	
	@Transactional
	public Accessory getAccessory(int id) {
		return this.hibernateTemplate.get(Accessory.class, Integer.valueOf(id));
	}
}
