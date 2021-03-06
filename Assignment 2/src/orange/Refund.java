package orange;

import java.math.BigInteger;

import orange.RequestException.requestError;

public final class Refund implements Request {
	private BigInteger Rma;
	private Refund (Builder builder){
		Rma = builder.getRma();
	}
	public static class Builder{
		private BigInteger RMA;
		public Builder setRMA(BigInteger rma) throws RequestException{
			if (rma == null) throw new RequestException(requestError.REFUND_ERROR);
			RMA = rma;
			return this;
		}
		public BigInteger getRma(){
			return RMA;
			
		}
		public Refund build(){
			return new Refund(this);
		}
	}
	public BigInteger getRma(){
		return Rma;
	}

	@Override
	public void process(Product product, RequestStatus status)
			throws RequestException {
		try {
			product.process(this, status);
		} catch (ProductException e) {
			throw new RequestException(requestError.REFUND_ERROR);
		}

	}

}
