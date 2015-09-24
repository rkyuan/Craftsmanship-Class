package orange;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import orange.RequestException.requestError;

public final class Exchange implements Request {
	private NavigableSet<SerialNumber> compatibleP;
	
	private Exchange(Builder builder){
		compatibleP = new TreeSet<SerialNumber>();
		for (SerialNumber s: builder.getCompatibleProducts()){
			compatibleP.add(s);
		}
	}
	
	public static class Builder{
		private Set<SerialNumber> compatibles;
		public Builder addCompatible(SerialNumber serialNumber){
			compatibles.add(serialNumber);
			return this;
		}
		public Set<SerialNumber> getCompatibleProducts(){
			return compatibles;
		}
		public Exchange build(){
			return new Exchange(this);
		}
	}

	@Override
	public void process(Product product, RequestStatus status)
			throws RequestException {
		try {
			product.process(this, status);
		} catch (ProductException e) {
			throw new RequestException(requestError.EXCHANGE_ERROR);
		}

	}
	public NavigableSet<SerialNumber> getCompatibleProducts(){
		NavigableSet<SerialNumber> r = new TreeSet<SerialNumber>();
		r.addAll(compatibleP);
		return r;
		
	}

}
