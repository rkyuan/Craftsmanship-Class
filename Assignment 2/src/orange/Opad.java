package orange;

import java.util.Optional;
import java.util.Set;

public class Opad extends AbstractProduct{
	Opad(){
		super();
	}
	Opad(SerialNumber serialNumber,Optional<Set<String>>description) {
		super(serialNumber, description);
	}

	public static boolean isValidSerialNumber(SerialNumber s){
		return (s.isEven()&&s.testBit(2));
	}
	public ProductType getProductType(){
		return ProductType.OPAD;
		
	}
	@Override
	public boolean checkNum(SerialNumber s) {
		return Opad.isValidSerialNumber(s);
	}
	@Override
	public Product makeOther(SerialNumber serialNumber,
			Optional<Set<String>> description) {
		return new Opad(serialNumber,description);
	}

}
