package org.example.library_management.controller;

import org.example.library_management.entity.Book;
import org.example.library_management.entity.BorrowCode;
import org.example.library_management.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    
    @GetMapping("/books")
    public String index(Model model){
        model.addAttribute("books", bookService.findAll());
        return "index";
    }
    
    @GetMapping("/books/{id}")
    public String view(@PathVariable Long id, Model model, RedirectAttributes redirect){
        Book book = bookService.findById(id);
        if (book==null){
            redirect.addFlashAttribute("message", "không tìm thấy sách!");
            return "redirect:/books";
        }
        model.addAttribute("bookId", id);
        model.addAttribute("book", book);
        return "view";
    }
    
    @PostMapping("/borrow/{id}")
    public String borrow(@PathVariable Long id, RedirectAttributes redirect){
        BorrowCode code = bookService.borrowBook(id);
        redirect.addFlashAttribute("code", code.getCode());
        return "redirect:/books";
    }
    
    @GetMapping("/return")
    public String returnForm(){
        return "return";
    }
    
    @PostMapping("/return")
    public String doReturn(@RequestParam String code, RedirectAttributes redirect){
        try {
            bookService.returnBook(code);
            redirect.addFlashAttribute("success", "Trả sách thành công!");
        }catch (RuntimeException e){
            redirect.addFlashAttribute("error", "Mã mượn sách không hợp lệ hoặc đã trả!");
        }
        return "redirect:/return";
    }
}
