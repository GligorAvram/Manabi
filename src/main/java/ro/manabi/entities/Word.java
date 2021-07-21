package ro.manabi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NonNull;
import ro.manabi.services.BlogEntryService;

@Entity
@Data
public class Word {
	
	public Word() {}
	
	public Word(String word, BlogEntry blogEntry) {
		this.word = word;
		this.blogEntry = blogEntry;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
    @JoinColumn
    private BlogEntry blogEntry;
    
    
	@NonNull
	private String word;

	@Override
	public String toString() {
		return word;
	}
}
