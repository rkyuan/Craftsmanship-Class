package orange;

public class RequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6844620773730796273L;
	public enum requestError{
		EXCHANGE_ERROR,
		REFUND_ERROR;
	}
	private requestError rE;
	
	
	public RequestException(requestError e){
		rE = e;
		
	}


	public requestError getRequestError() {
		return rE;
	}

	
}
