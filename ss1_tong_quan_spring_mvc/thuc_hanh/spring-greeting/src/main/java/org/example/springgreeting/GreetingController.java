package org.example.springgreeting;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// là annotation để đánh dấu lớp GreetingController là một controller (đối tượng sẽ xử lý các request)
@Controller
public class GreetingController {
    // là annotation để đánh dấu phương thức greeting() là một phương thức dùng để xử lý request khi có một request GET được gửi đến đường dẫn "/greeting"
    @GetMapping("/greeting")
    
//    @RequestParam: là annotation để đánh dấu rằng name là tham số được truyền vào
//    model: là đối tượng để truyền dữ liệu từ controller sang view
//    model.addAttribute(): là phương thức để truyền một dữ liệu từ controller sang view
    public String greeting(@RequestParam String name, Model model){
        model.addAttribute("name", name);
        return "index";
    }
}
