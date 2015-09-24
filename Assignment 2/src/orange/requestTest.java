package orange;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class requestTest {
	@Test
	public void test() throws RequestException, ProductException {
		Refund.Builder b = new Refund.Builder();
		b.setRMA(new BigInteger("4353"));
		Refund r = b.build();
		Opad o = new Opad();
		o.process(r, new RequestStatus());
		
	}

}
