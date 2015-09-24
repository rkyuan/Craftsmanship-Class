package orange;

public class ProductException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2559972053623642954L;
	
	private ProductType pType;
	private SerialNumber sNum;
	private ErrorCode eCode;
	
	public enum ErrorCode{
		INVALID_SERIAL_NUMBER,INVALID_PRODUCT_TYPE,UNSUPPORTED_OPERATION
	}
	public ProductException (ProductType productType, SerialNumber serialNumber, ErrorCode errorCode){
		pType = productType;
		sNum = serialNumber;
		eCode = errorCode;
			
	}
	public ProductType getProductType(){
		return pType;
	}
	public String getProductName(){
		return pType.getName();
	}
	public SerialNumber getSerialNumber(){
		return sNum;
	}
	public ErrorCode getErrorCode(){
		return eCode;
	}
	
}
