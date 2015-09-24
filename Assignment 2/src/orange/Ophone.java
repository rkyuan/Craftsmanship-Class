package orange;

import java.math.BigInteger;
import java.util.Optional;
import java.util.Set;

public class Ophone extends AbstractProduct {
	
	Ophone(){
		super();
	}
	
	public Ophone(SerialNumber serialNumber, Optional<Set<String>> description) {
		super(serialNumber, description);
		// TODO Auto-generated constructor stub
	}
	public static boolean isValidSerialNumber(SerialNumber s){
		return (s.isOdd()&&s.gcd(new SerialNumber(630)).compareTo(new BigInteger("42"))==1);
	}
	public ProductType getProductType(){
		return ProductType.OPHONE;
		
	}

	@Override
	public boolean checkNum(SerialNumber s) {
		return Ophone.isValidSerialNumber(s);
	}

	@Override
	public Product makeOther(SerialNumber serialNumber,
			Optional<Set<String>> description) {
		return new Ophone(serialNumber,description);
	}
}
