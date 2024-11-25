package ankush.spring.jdbc.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
	@Getter @Setter private int id;
	@Getter @Setter private String makeString;
}
