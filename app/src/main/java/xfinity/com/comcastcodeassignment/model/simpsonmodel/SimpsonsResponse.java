package xfinity.com.comcastcodeassignment.model.simpsonmodel;

import java.util.List;
public class SimpsonsResponse{

	private String entity;

	private List<RelatedTopicsItem> relatedTopics;

	private String heading;

	private String definitionSource;

	private String abstractSimpsons;

	private String abstractURL;

	private String definitionURL;

	private String definition;

	private String abstractText;

	private String redirect;

	private String image;

	private String infobox;

	private String answer;

	private String type;

	private int imageIsLogo;

	private int imageHeight;

	private List<Object> results;

	private Meta meta;

	private int imageWidth;

	private String abstractSource;

	private String answerType;

	public void setEntity(String entity){
		this.entity = entity;
	}

	public String getEntity(){
		return entity;
	}

	public void setRelatedTopics(List<RelatedTopicsItem> relatedTopics){
		this.relatedTopics = relatedTopics;
	}

	public List<RelatedTopicsItem> getRelatedTopics(){
		return relatedTopics;
	}

	public void setHeading(String heading){
		this.heading = heading;
	}

	public String getHeading(){
		return heading;
	}

	public void setDefinitionSource(String definitionSource){
		this.definitionSource = definitionSource;
	}

	public String getDefinitionSource(){
		return definitionSource;
	}

	public void setAbstractSimpsons(String abstractSimpsons){
		this.abstractSimpsons = abstractSimpsons;
	}

	public String getAbstractSimpsons(){
		return abstractSimpsons;
	}

	public void setAbstractURL(String abstractURL){
		this.abstractURL = abstractURL;
	}

	public String getAbstractURL(){
		return abstractURL;
	}

	public void setDefinitionURL(String definitionURL){
		this.definitionURL = definitionURL;
	}

	public String getDefinitionURL(){
		return definitionURL;
	}

	public void setDefinition(String definition){
		this.definition = definition;
	}

	public String getDefinition(){
		return definition;
	}

	public void setAbstractText(String abstractText){
		this.abstractText = abstractText;
	}

	public String getAbstractText(){
		return abstractText;
	}

	public void setRedirect(String redirect){
		this.redirect = redirect;
	}

	public String getRedirect(){
		return redirect;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setInfobox(String infobox){
		this.infobox = infobox;
	}

	public String getInfobox(){
		return infobox;
	}

	public void setAnswer(String answer){
		this.answer = answer;
	}

	public String getAnswer(){
		return answer;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setImageIsLogo(int imageIsLogo){
		this.imageIsLogo = imageIsLogo;
	}

	public int getImageIsLogo(){
		return imageIsLogo;
	}

	public void setImageHeight(int imageHeight){
		this.imageHeight = imageHeight;
	}

	public int getImageHeight(){
		return imageHeight;
	}

	public void setResults(List<Object> results){
		this.results = results;
	}

	public List<Object> getResults(){
		return results;
	}

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setImageWidth(int imageWidth){
		this.imageWidth = imageWidth;
	}

	public int getImageWidth(){
		return imageWidth;
	}

	public void setAbstractSource(String abstractSource){
		this.abstractSource = abstractSource;
	}

	public String getAbstractSource(){
		return abstractSource;
	}

	public void setAnswerType(String answerType){
		this.answerType = answerType;
	}

	public String getAnswerType(){
		return answerType;
	}

	@Override
 	public String toString(){
		return 
			"SimpsonsResponse{" + 
			"entity = '" + entity + '\'' + 
			",relatedTopics = '" + relatedTopics + '\'' + 
			",heading = '" + heading + '\'' + 
			",definitionSource = '" + definitionSource + '\'' + 
			",abstract = '" + abstractSimpsons + '\'' +
			",abstractURL = '" + abstractURL + '\'' + 
			",definitionURL = '" + definitionURL + '\'' + 
			",definition = '" + definition + '\'' + 
			",abstractText = '" + abstractText + '\'' + 
			",redirect = '" + redirect + '\'' + 
			",image = '" + image + '\'' + 
			",infobox = '" + infobox + '\'' + 
			",answer = '" + answer + '\'' + 
			",type = '" + type + '\'' + 
			",imageIsLogo = '" + imageIsLogo + '\'' + 
			",imageHeight = '" + imageHeight + '\'' + 
			",results = '" + results + '\'' + 
			",meta = '" + meta + '\'' + 
			",imageWidth = '" + imageWidth + '\'' + 
			",abstractSource = '" + abstractSource + '\'' + 
			",answerType = '" + answerType + '\'' + 
			"}";
		}
}