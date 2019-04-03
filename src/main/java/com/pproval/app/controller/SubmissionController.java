package com.pproval.app.controller;

import com.pproval.app.model.Article;
import com.pproval.app.model.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubmissionController {

  @Autowired
  private ArticleRepository articleRepository;

  @GetMapping("/submit-Submitter")
  public String submitForm(Model model) {
    model.addAttribute("submission", new Article());
    return "submit-Submitter";
  }

  @PostMapping("/submit-Submitter")
  public String submitSubmit(@ModelAttribute Article article) {
    articleRepository.save(article);
    return "view-Submitter";
  }

  @GetMapping("/view-Submitter")
  public String view(Model model) {
    model.addAttribute("articles", articleRepository.findAll());
    return "view-Submitter";
  }
}
