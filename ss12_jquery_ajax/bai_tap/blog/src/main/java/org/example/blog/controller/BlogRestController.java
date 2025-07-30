package org.example.blog.controller;

import org.example.blog.entity.Blog;
import org.example.blog.service.IBlogService;
import org.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/api/blogs")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    
    @GetMapping("")
    public Page<Blog> findAll(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "2") int size){
        Pageable pageable = PageRequest.of(page - 1, size);
        return blogService.findAll(pageable);
    }
    
    @GetMapping("/")
    public ResponseEntity<Page<Blog>> index(@RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "sort", defaultValue = "title") String sortField,
                                @RequestParam(name = "dir", defaultValue = "desc") String sortDir,
                                @RequestParam(defaultValue = "") String keyword,
                                @RequestParam(defaultValue = "") Integer categoryId) {
        int size = 2;
        int searchId = (categoryId == null) ? 0 : categoryId;
        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        PageRequest pageable = PageRequest.of(page, size, sort);

        Page<Blog> blogPage = blogService.searchBlogs(keyword, searchId, pageable);
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Integer id) {
        if (blogService.findById(id) != null) {
            return new ResponseEntity<>(blogService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>("Không tìm thấy!", HttpStatus.NOT_FOUND);
    }
}
