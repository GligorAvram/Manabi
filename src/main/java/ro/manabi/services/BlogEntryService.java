package ro.manabi.services;

import java.util.List;

import ro.manabi.entities.BlogEntry;
import ro.manabi.entities.Word;

public interface BlogEntryService {
	
	List<BlogEntry> findByQuery(String query);
	BlogEntry createEntry(String name, String grammarStructure, String articleBody, String[] words);
	BlogEntry editEntry(long id, String articleBody, String[] words);

}
