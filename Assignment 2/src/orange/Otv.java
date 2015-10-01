package orange;

import java.math.BigInteger;
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
	
	@Override
	public void process(Refund request, RequestStatus status)
			throws ProductException {
		if (request.getRma().compareTo(BigInteger.ZERO)>0){
			status.setScode(RequestStatus.StatusCode.OK);
			return;
		}
		status.setScode(RequestStatus.StatusCode.FAIL);
		return;
	}
	@Override
	public void process(Exchange request, RequestStatus status)
			throws ProductException {
		//avg(this<sn<this+1024)
		//max(this,avg)
		int num = 0;
		BigInteger avg = BigInteger.valueOf(0);
		for (SerialNumber s: request.getCompatibleProducts()){
			if (s.getSerialNumber().compareTo(this.getSerialNumber().getSerialNumber())>0 
					&&s.getSerialNumber().compareTo(this.getSerialNumber().getSerialNumber().add(BigInteger.valueOf(1024)))<0){
				num++;
				avg = avg.add(s.getSerialNumber());
			}
		}
		BigInteger max = this.getSerialNumber().getSerialNumber();
		for (SerialNumber s: request.getCompatibleProducts()){
			if(s.getSerialNumber().compareTo(max)>0
					&& s.getSerialNumber().compareTo(avg)<0){
				max = s.getSerialNumber();
			}
		}
		if(max.compareTo(this.getSerialNumber().getSerialNumber())>0){
			status.setScode(RequestStatus.StatusCode.OK);
			status.setResult(Optional.of(max));
			return;
		}
		status.setScode(RequestStatus.StatusCode.FAIL);
		return;
	}
	
}
