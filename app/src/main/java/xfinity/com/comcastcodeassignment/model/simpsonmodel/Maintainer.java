package xfinity.com.comcastcodeassignment.model.simpsonmodel;

public class Maintainer{

	private String github;

	public void setGithub(String github){
		this.github = github;
	}

	public String getGithub(){
		return github;
	}

	@Override
 	public String toString(){
		return 
			"Maintainer{" + 
			"github = '" + github + '\'' + 
			"}";
		}
}