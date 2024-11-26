package ankush.spring.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name="accessories")
public class Accessory {

	@Getter @Setter 
	@Column(name="id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "accessory_name")
	@Getter @Setter private String accessoryName;
	@Column(name = "type")
	@Getter @Setter private String type;
}
