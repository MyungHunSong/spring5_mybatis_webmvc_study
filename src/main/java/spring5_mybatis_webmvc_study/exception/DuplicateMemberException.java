package spring5_mybatis_webmvc_study.exception;

@SuppressWarnings("serial")
public class DuplicateMemberException extends RuntimeException {
	
	public DuplicateMemberException(String message) {
		super(message);
	}
}
