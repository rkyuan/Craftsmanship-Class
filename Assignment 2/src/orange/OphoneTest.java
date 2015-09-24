package orange;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class OphoneTest {
	
	
	@Test
	public void test() {
		Ophone test = new Ophone(new SerialNumber(2), null);
		assertFalse(test.isValidSerialNumber(test.serial));
	}

}
