package ro.manabi.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ro.manabi.entities.BlogEntry;
import ro.manabi.entities.Word;
import ro.manabi.pojos.SearchVal;
import ro.manabi.repositories.BlogEntryRepository;
import ro.manabi.services.BlogEntryService;
import ro.manabi.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private BlogEntryRepository blogEntryRep;
	
	@Autowired
	private BlogEntryService blogService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping({"", "/", "/index"})
	public String index() {
		return "index";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@RequestMapping("/metode")
	public String methods() {
		return "methods";
	}
	
//	@RequestMapping("/about")
//	public String about() {
//		return "about";
//	}
	
	@RequestMapping("/metode/anki")	
	public String anki() {
		return "anki";
	}
	
	@RequestMapping("/metode/unelte")
	public String tools() {
		return "tools";
	}
	
	@RequestMapping("/metode/ascultatul")
	public String listening() {
		return "listening";
	}
	
	@RequestMapping("/limbajaponeza")
	public String language() {
		return "language";
	}
	
	@RequestMapping("/limbajaponeza/fonetica")
	public String phonetics() {
		return "phonetics";
	}
	
	@RequestMapping("/limbajaponeza/kanji")
	public String kanji() {
		return "kanji";
	}
	
	@RequestMapping("/limbajaponeza/gramatica")
	public String grammar() {
		return "grammar";
	}
	
	@RequestMapping("/limbajaponeza/blog")
	public ModelAndView blog() {
		
		ModelAndView model = new ModelAndView("blog");
		
		List<BlogEntry> blogEntries = blogEntryRep.findAll();
		
		model.addObject("blogEntries", blogEntries);
		
		return model;
	}
	
	@RequestMapping("/limbajaponeza/blog/{id}")
	public ModelAndView article(@PathVariable(value="id") String idAsString) {
		long id = -1;
		try{
			id = Long.parseLong(idAsString);
		} catch(NumberFormatException e){
			e.printStackTrace();
		}
		BlogEntry entry = null;
		
		if(id != -1 && blogEntryRep.findById(id).isPresent()) {
			entry = blogEntryRep.findById(id).get();
		} 
		else {
			return new ModelAndView("redirect:/limbajaponeza/blog");
		}
		
		ModelAndView model = new ModelAndView("article");
		
		List<String> rubyWords = entry.getWords().stream().map(Word::toString).collect(Collectors.toList());
				
		
		model.addObject("blogEntry", entry);
		model.addObject("rubyWords", rubyWords);
		
		
		return model;
	}
	
	
	@RequestMapping("/signin")
    public String signin() {
        return "signin";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "redirect:/index";
    }
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping(value ="/addBlogPost", method=RequestMethod.POST)
	public String postBlogEntry(@RequestParam("articleName") String articleName,
								@RequestParam("grammarStructure") String grammarStructure,
								@RequestParam("text-body") String textBody,
								@RequestParam("wordList[]") String[] wordList) {
System.out.println(textBody.length() + " " + textBody);	
		blogService.createEntry(articleName, grammarStructure, textBody, wordList);
		
		return "redirect:/admin";
	}
	
	
	@RequestMapping("/search/{query}")
	public @ResponseBody List<SearchVal> searchPost(@PathVariable(value="query") String query) {
		
	    List<BlogEntry> queryResult = blogService.findByQuery(query);
	    
	    List<SearchVal> retVal = new ArrayList<>();
	    for(BlogEntry q : queryResult) {
	    	retVal.add(new SearchVal(q.getId(), q.getGrammarStructure()));
	    }
	    
	    return retVal;
	}
	
	@RequestMapping(value="/changePassword", method=RequestMethod.POST)
	public String changePassowrd(@RequestParam("newPassword") String newPassword,
			@RequestParam("confirmPassword") String confirmPassword,
			@RequestParam("currentPassword") String currentPassword,
			Principal principal) throws Exception {
		
		if(newPassword.equals(confirmPassword)) {
			if(!userService.changeUserPassword(principal, newPassword, currentPassword)) {
				throw new Exception ("incorrect old password");
			};
		}
		else {
			throw new Exception("The password in New password and in Confirm password need to match"); 
		}
		
		return "redirect:/admin";
	}
}
