package org.example.ungdungnghenhac.controller;

import org.example.ungdungnghenhac.model.Song;
import org.example.ungdungnghenhac.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {
    
    @Autowired
    private ISongService songService;
    
    @Value("${upload-dir}")
    private String uploadDir;

    private static final List<String> ALLOWED_EXT = Arrays.asList(".mp3", ".wav", ".ogg", ".m4p");
    
    @GetMapping("/upload")
    public String showForm(Model model){
        model.addAttribute("song", new Song());
        return "upload";
    }
    
    @PostMapping("/upload")
    public String handleUpload(@ModelAttribute Song song, @RequestParam("file")MultipartFile file, Model model){
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        String ext = filename.substring(filename.lastIndexOf(".")).toLowerCase();
        
        if (!ALLOWED_EXT.contains(ext)){
            model.addAttribute("error", "Chỉ chấp nhận file nhạc có đuôi .mp3, .wav, .ogg, .m4p");
            return "upload";
        }
        
        try {
            File dest = new File(uploadDir + File.separator + filename);
            file.transferTo(dest);
            song.setFilePath("/music/" + filename);
            songService.save(song);
            return "redirect:/songs/list";
        }catch (IOException e){
            e.printStackTrace();
            model.addAttribute("error", "Upload thất bại!");
            return "upload";
        }
    }
    
    @GetMapping("list")
    public String list(Model model){
        model.addAttribute("songs", songService.findAll());
        return "list";
    }
}
