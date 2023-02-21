//make the required changes to this class so that InvalidConsumerNumberException is of type exception. 
public class InvalidConsumerNumberException extends Exception
{
	private static final long serialVersionUID = 1L;

	//fill the code
	public InvalidConsumerNumberException(String msg) {
		super(msg);
	}
}