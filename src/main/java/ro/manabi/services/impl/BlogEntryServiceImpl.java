package ro.manabi.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.manabi.entities.BlogEntry;
import ro.manabi.entities.Word;
import ro.manabi.repositories.BlogEntryRepository;
import ro.manabi.services.BlogEntryService;

@Service
public class BlogEntryServiceImpl implements BlogEntryService {
	
	@Autowired
	private BlogEntryRepository blogRepository;

	
	@Override
	public List<BlogEntry> findByQuery(String query) {
		List<BlogEntry> localEntry = blogRepository.findByQuery(query);
		return localEntry;
	}

	@Override
	public BlogEntry createEntry(String name, String grammarStructure, String articleBody, String[] words) {
		BlogEntry localEntry = new BlogEntry(name, grammarStructure, articleBody);
		List<Word> wordList = new ArrayList<>();
		
		for(String s : words) {
			Word word = new Word(s, localEntry);
			wordList.add(word);
		}
		localEntry.setWords(wordList);
		
		blogRepository.save(localEntry);
		return localEntry;
	}

	//TODO redo the list of words
	@Override
	public BlogEntry editEntry(long id, String articleBody, String[] words) {
		BlogEntry localEntry = blogRepository.findById(id).get();
		if(localEntry != null) {
			localEntry.setTextBody(articleBody);
			
			blogRepository.save(localEntry);
		}
		return localEntry;
	}
}
