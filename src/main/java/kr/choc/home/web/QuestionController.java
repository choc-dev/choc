package kr.choc.home.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.choc.home.model.Question;

@Controller
public class QuestionController {
	
	ArrayList<Question> questions = new ArrayList<>();

	@GetMapping("/questions")
	public String show(Model model) {
		model.addAttribute("questions", questions);
		return "redirect:/index_test.html";
	}
	
	@PostMapping("/qna/question")
	public String question(Question question){
		questions.add(question);
		System.out.println(question);
		return "redirect:/questions";
	}
	
	@GetMapping("/index_test.html")
	public String index(Model model) {
		model.addAttribute("questions", questions);
		return "/index_test";
	}
}
