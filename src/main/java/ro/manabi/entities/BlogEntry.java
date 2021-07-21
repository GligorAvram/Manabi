package ro.manabi.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class BlogEntry {
	
	public BlogEntry() {};
	public BlogEntry(String articleName, String grammarStructure, String textBody) {
		this.articleName= articleName;
		this.grammarStructure = grammarStructure;
		this.textBody = textBody;
	};
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NonNull
	private String articleName;
	@NonNull
	private String grammarStructure;
	@NonNull
	@Column(length = 15000)
	private String textBody;
	
	@NonNull
	@OneToMany(mappedBy="blogEntry",cascade = CascadeType.ALL)
	private List<Word> words;

}
