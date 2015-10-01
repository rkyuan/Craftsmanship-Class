package orange;

import java.math.BigInteger;
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
	
	@Override
	public void process(Refund request, RequestStatus status)
			throws ProductException {
		if (request.getRma().xor(this.getSerialNumber().getSerialNumber()).compareTo(BigInteger.valueOf(14))>0){
			status.setScode(RequestStatus.StatusCode.OK);
			return;
		}
		status.setScode(RequestStatus.StatusCode.FAIL);
		return;
	}
	@Override
	public void process(Exchange request, RequestStatus status)
			throws ProductException {
		BigInteger min = this.getSerialNumber().getSerialNumber();
		for (SerialNumber s: request.getCompatibleProducts()){
			if (s.getSerialNumber().compareTo(min)<0 && s.getSerialNumber().compareTo(this.getSerialNumber().getSerialNumber())>0){
				min = s.getSerialNumber();
			}
		}
		if(min.compareTo(this.getSerialNumber().getSerialNumber())<0){
			status.setScode(RequestStatus.StatusCode.OK);
			status.setResult(Optional.of(min));
			return;
		}
		status.setScode(RequestStatus.StatusCode.FAIL);
		return;
	}
}
