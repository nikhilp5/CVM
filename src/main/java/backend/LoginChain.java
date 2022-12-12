package backend;

public class LoginChain {
	
	LoginProcessor chain;
	
	public LoginChain(){
		buildChain();
	}

	private void buildChain(){
		chain = new AdminProcessor(new HealthWorkerProcessor(new UserProcessor(null)));
	}

	public void process(User user) {
		chain.process(user);
	}

}
