package orange;

import java.math.BigInteger;
import java.util.Optional;
import java.util.Set;

import orange.ProductException.ErrorCode;

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

	@Override
	public void process(Refund request, RequestStatus status)
			throws ProductException {
		if (getSerialNumber().getSerialNumber().gcd(request.getRma()).compareTo(new BigInteger("12"))>0){
			status.setScode(RequestStatus.StatusCode.OK);
			return;
		}
		status.setScode(RequestStatus.StatusCode.FAIL);
		return;
		//don't know what to do with result
		
	}
	@Override
	public void process(Exchange request, RequestStatus status)
			throws ProductException {
		BigInteger max = new BigInteger("0");
		for (SerialNumber s: request.getCompatibleProducts()){
			if (s.getSerialNumber().compareTo(max)>0 && s.getSerialNumber().compareTo(this.getSerialNumber().getSerialNumber())<0){
				max = s.getSerialNumber();
			}
		}
		if(max.compareTo(new BigInteger("0"))>0){
			status.setScode(RequestStatus.StatusCode.OK);
			status.setResult(Optional.of(max));
			return;
		}
		status.setScode(RequestStatus.StatusCode.FAIL);
		return;
	}
}
