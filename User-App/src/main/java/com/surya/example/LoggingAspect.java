//com.surya.example.aop;
 
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
 
import lombok.extern.slf4j.Slf4j;
 
@Aspect // we are to spring this extra logic iam writing
@Component // a spring take care of this class (object creation)
@Slf4j
public class LoggingAspect {
 
	@Before("execution(* com.surya.example.controllers.addUser(..))")
	public void logbefore() {
		log.warn("loging something before addNewUser Endpoint");
	}
 
}
 