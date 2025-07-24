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
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}/edit")
    public String updateForm(@PathVariable Integer id, @ModelAttribute SongCreateDto songCreateDto, RedirectAttributes redirect, Model model) {
        Song song = songService.findById(id);
        if (song == null) {
            redirect.addFlashAttribute("message", "not found!");
            return "redirect:/songs";
        }
        BeanUtils.copyProperties(song, songCreateDto);
        model.addAttribute("songCreateDto", songCreateDto);
        model.addAttribute("id", id);
        return "update";
    }

    @PostMapping("/{id}/edit")
    public String update(@Validated @ModelAttribute SongCreateDto songCreateDto, BindingResult bindingResult,
                         RedirectAttributes redirect, Model model, @PathVariable Integer id) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        if (songService.findById(id) == null) {
            redirect.addFlashAttribute("message", "Not found!");
            return "redirect:/songs";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songCreateDto, song);
        song.setId(id);
        songService.save(song);
        model.addAttribute("song", song);
        redirect.addFlashAttribute("message", "update successfully!");
        return "redirect:/songs";
    }
}
