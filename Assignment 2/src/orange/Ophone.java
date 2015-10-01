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
	
	@Override
	public void process(Refund request, RequestStatus status)
			throws ProductException {
		for(int i = 2; i<= 8;i*=2){
			if (Ophone.isValidSerialNumber(new SerialNumber(request.getRma().multiply(BigInteger.valueOf(i))))){
				status.setScode(RequestStatus.StatusCode.OK);
				return;
			}
			
		}
		status.setScode(RequestStatus.StatusCode.FAIL);
		return;
	}
	
	@Override
	public void process(Exchange request, RequestStatus status)
			throws ProductException {
		int num =0;
		BigInteger avg = BigInteger.valueOf(0);
		for(SerialNumber s:request.getCompatibleProducts()){
			if(s.getSerialNumber().compareTo(this.getSerialNumber().getSerialNumber())>1){
				avg.add(s.getSerialNumber());
				num++;
			}
		}
		if (num==0){
			status.setScode(RequestStatus.StatusCode.FAIL);
			return;
		}
		avg = avg.divide(BigInteger.valueOf(num));
		BigInteger max = BigInteger.valueOf(0);
		for(SerialNumber s:request.getCompatibleProducts()){
			if (max.compareTo(s.getSerialNumber())<0 && s.getSerialNumber().compareTo(avg)<0){
				max=s.getSerialNumber();
			}
		}
		status.setScode(RequestStatus.StatusCode.OK);
		status.setResult(Optional.of(max));
		return;
	}
}
