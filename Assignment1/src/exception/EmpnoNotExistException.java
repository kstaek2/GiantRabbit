package exception;

public class EmpnoNotExistException extends Exception{
	public EmpnoNotExistException(){}
	public EmpnoNotExistException(String msg){
		super(msg);
	}
}
