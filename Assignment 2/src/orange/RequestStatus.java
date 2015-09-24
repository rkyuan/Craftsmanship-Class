package orange;

import java.math.BigInteger;
import java.util.Optional;

public class RequestStatus {
	public enum StatusCode{
		UNKOWN,
		OK,
		FAIL;
	}
	private StatusCode Scode;
	private Optional<BigInteger> result;
	public RequestStatus(){
		Scode =  StatusCode.UNKOWN;
		//result is already empty
	}
	
	public StatusCode getScode() {
		return Scode;
	}
	public void setScode(StatusCode scode) {
		Scode = scode;
	}
	public Optional<BigInteger> getResult() {
		return result;
	}
	public void setResult(Optional<BigInteger> result) {
		this.result = result;
	}
	
	

}
