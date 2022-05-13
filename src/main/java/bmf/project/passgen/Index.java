package bmf.project.passgen;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

@VariableResolver(DelegatingVariableResolver.class)
public class Index {
	
	private String password = "";
	
	@Init
	public void init() {
		
	}
	
	@NotifyChange({"cPass"})
	public void setPass(String pass) {
		password = pass;
	}	
	
	public String cPass() {
		return BCrypt.hashpw(password, BCrypt.gensalt(12)).substring(7);
	}

}
