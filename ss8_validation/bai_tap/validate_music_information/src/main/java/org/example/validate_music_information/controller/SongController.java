package org.example.validate_music_information.controller;

import org.example.validate_music_information.dto.SongCreateDto;
import org.example.validate_music_information.entity.Song;
import org.example.validate_music_information.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("songCreateDto", new SongCreateDto());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute SongCreateDto songCreateDto, BindingResult bindingResult, RedirectAttributes redirect, Model model) {
        if (bindingResult.hasErrors()) {
            return "create";
        }

        Song song = new Song();
        BeanUtils.copyProperties(songCreateDto, song);
        songService.save(song);
        redirect.addFlashAttribute("message", "create success!");
        return "redirect:/songs";
    }
    
    
    
}
