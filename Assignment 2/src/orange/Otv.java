package orange;

import java.util.Optional;
import java.util.Set;

public class Otv extends AbstractProduct{
	
	Otv(){
		super();
	}
	public Otv(SerialNumber serialNumber, Optional<Set<String>> description) {
		super(serialNumber, description);
		// TODO Auto-generated constructor stub
	}
	public static boolean isValidSerialNumber(SerialNumber s){
		int g = s.gcd(new SerialNumber(630)).intValue();
		
		return (s.isOdd()&&g<=14);
	}
	public ProductType getProductType(){
		return ProductType.OTV;
		
	}
	@Override
	public boolean checkNum(SerialNumber s) {
		return Otv.isValidSerialNumber(s);
	}
	@Override
	public Product makeOther(SerialNumber serialNumber,
			Optional<Set<String>> description) {
		return new Otv(serialNumber,description);
	}
}
