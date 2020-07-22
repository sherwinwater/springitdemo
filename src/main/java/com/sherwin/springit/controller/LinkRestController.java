package com.sherwin.springit.controller;

import com.sherwin.springit.domain.Link;
import com.sherwin.springit.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/links")
public class LinkRestController {

    @Autowired
    private LinkRepository linkRepository;

    public LinkRestController(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    @GetMapping("/foo")
    public String foo(Model model){
        model.addAttribute("pageTitle","This page is FOO!");
        return "foo";
    }

    // list
    @GetMapping("/")
    public List<Link> list(){
        return linkRepository.findAll();
    }

    @PostMapping("/create")
    public Link create(@ModelAttribute Link link){return linkRepository.save(link);}

    @GetMapping("/{id}")
    public Optional<Link> read(@PathVariable Long id){return linkRepository.findById(id);}

    @PutMapping("/{id}")
    public Link update(@PathVariable Long id, @ModelAttribute Link link){return linkRepository.save(link);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        linkRepository.deleteById(id);

    }

}
