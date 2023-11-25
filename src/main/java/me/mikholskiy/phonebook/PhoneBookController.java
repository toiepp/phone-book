package me.mikholskiy.phonebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class PhoneBookController {
    private PhoneBookService service;

    @Autowired
    public PhoneBookController setService(PhoneBookService service) {
        this.service = service;
        return this;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("listOfRecords", service.getAll());
        return "main";
    }

    @GetMapping("/new")
    public String addNewPage(@ModelAttribute("record") PhoneBookRecord record) {
        return "new";
    }

    @PostMapping("/new")
    public String addRecord(@ModelAttribute("record") PhoneBookRecord phoneBookRecord) {
        service.save(phoneBookRecord);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updatePage(@RequestParam Long id, Model model) {
        model.addAttribute("recordToUpdate", service.getById(id).get());
        return "update-page";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("recordToUpdate") PhoneBookRecord record) {
        service.update(record);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteRecord(@RequestParam Long id) {
        service.deleteById(id);
        return "redirect:/";
    }
}
