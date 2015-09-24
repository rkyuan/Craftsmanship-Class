package orange;

import static org.junit.Assert.*;

import org.junit.Test;

public class exceptionTest {

	//@Test (expected = Exception.class)  
	public void test() throws ProductException {
		SerialNumber s = new SerialNumber(5);
		AbstractProduct.make(ProductType.OPAD, s, null);
		//should throw ProductException
	}

}
