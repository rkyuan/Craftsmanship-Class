package orange;

import java.util.Optional;
import java.util.Set;

public class Opod extends AbstractProduct{
	Opod(){
		super();
	}

	public Opod(SerialNumber serialNumber, Optional<Set<String>> description) {
		super(serialNumber, description);
		// TODO Auto-generated constructor stub
	}
	public static boolean isValidSerialNumber(SerialNumber s){
		return (s.isEven()&&!s.testBit(2));
	}
	public ProductType getProductType(){
		return ProductType.OPOD;
		
	}

	@Override
	public boolean checkNum(SerialNumber s) {
		return Opod.isValidSerialNumber(s);
	}

	@Override
	public Product makeOther(SerialNumber serialNumber,
			Optional<Set<String>> description) {
		return new Opod(serialNumber,description);
	}

}
