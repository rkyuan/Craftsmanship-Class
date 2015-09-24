package orange;

import java.math.BigInteger;

public class SerialNumber {
	private BigInteger serial;
	
	public SerialNumber (BigInteger serialNumber){
		serial = serialNumber;
	}
	public SerialNumber (int serialNumber){
		serial = new BigInteger(Integer.toString(serialNumber));
	}
	public BigInteger getSerialNumber(){
		return serial;
	}
	public BigInteger gcd(SerialNumber other){
		return serial.gcd(other.getSerialNumber());
	}
	public BigInteger mod(SerialNumber other){
		return serial.mod(other.getSerialNumber());
	}
	public boolean testBit (int bit){
		return serial.testBit(bit);
	}
	public boolean isEven(){
		BigInteger two = new BigInteger ("2");
		int m = serial.mod(two).intValue();
		return m == 0;	
	}
	public boolean isOdd(){
		return !isEven();
	}
}
