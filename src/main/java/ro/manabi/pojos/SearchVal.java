package ro.manabi.pojos;

import lombok.NonNull;

public class SearchVal {
	
	private String grammarStructure;
	private long id;
	
	public SearchVal(long id, String grammarStructure) {
		this.id =  id;
		this.grammarStructure = grammarStructure;
	}

	public String getGrammarStructure() {		
		return grammarStructure;
	}
	
	public long getId() {		
		return id;
	}
}
