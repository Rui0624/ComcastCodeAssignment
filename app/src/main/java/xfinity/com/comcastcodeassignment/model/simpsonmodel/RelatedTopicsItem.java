package xfinity.com.comcastcodeassignment.model.simpsonmodel;

public class RelatedTopicsItem{

	private String text;

	private Icon icon;

	private String firstURL;

	private String result;

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setIcon(Icon icon){
		this.icon = icon;
	}

	public Icon getIcon(){
		return icon;
	}

	public void setFirstURL(String firstURL){
		this.firstURL = firstURL;
	}

	public String getFirstURL(){
		return firstURL;
	}

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"RelatedTopicsItem{" + 
			"text = '" + text + '\'' + 
			",icon = '" + icon + '\'' + 
			",firstURL = '" + firstURL + '\'' + 
			",result = '" + result + '\'' + 
			"}";
		}
}