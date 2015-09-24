package orange;

import java.util.Optional;
import java.util.Set;

public class Owatch extends AbstractProduct{
	
	Owatch(){
		super();
	}

	public Owatch(SerialNumber serialNumber, Optional<Set<String>> description) {
		super(serialNumber, description);
		// TODO Auto-generated constructor stub
	}
	public static boolean isValidSerialNumber(SerialNumber s){
		int g = s.gcd(new SerialNumber(630)).intValue();
		return (s.isOdd()&&g>14&&g<=42);
	}
	public ProductType getProductType(){
		return ProductType.OWATCH;
		
	}

	@Override
	public boolean checkNum(SerialNumber s) {
		return Owatch.isValidSerialNumber(s);
	}

	@Override
	public Product makeOther(SerialNumber serialNumber,
			Optional<Set<String>> description) {
		return new Owatch(serialNumber,description);
	}
}
