package com.anglia.login.controllers.autorizacija;

import com.anglia.login.model.autorizacija.Autorizacija;
import com.anglia.login.model.user.User;
import com.anglia.login.service.autorizacija.AutorizacijaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autorizacija")
public class AutorizacijaController {

    private final AutorizacijaService autorizacijaService;

    public AutorizacijaController(AutorizacijaService autorizacijaService) {
        this.autorizacijaService = autorizacijaService;
    }

    @GetMapping
    public String prikaziAutorizaciju(@ModelAttribute Autorizacija autorizacija, Model model, HttpSession s){
        User user = (User) s.getAttribute("user");
        if(user != null){
            model.addAttribute("listaAutorizacije", autorizacijaService.findAll());
            return "autorizacija/autorizacija";
        }else{
            return "redirect:/login";
        }
    }

    @PostMapping
    public String dodajAutorizaciju(Model model, @Valid @ModelAttribute Autorizacija autorizacija){
        autorizacijaService.save(autorizacija);
        model.addAttribute("autorizacija", autorizacija);
        return "redirect:/autorizacija";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> izbrisiAutorizaciju(@PathVariable Integer id){
        autorizacijaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/show-delete-modal/{id}")
    public String showDeleteAutorizacijaModal(@PathVariable Integer id, Model model) {
        model.addAttribute("deleteAutorizacijaId", id);
        return "autorizacija/delete-autorizacija-modal :: deleteAutorizacijaModal";
    }

    @GetMapping("/findOne/{id}")
    public String pronadjiAutorizaciju(@PathVariable Integer id, RedirectAttributes attributes){
        attributes.addAttribute("autorizacija", autorizacijaService.getOne(id));
        return "redirect:/autorizacija";
    }

    @ModelAttribute("novoiAutorizacije")
    public List<Integer> nivoiAutorizacije(){
        List<Integer> nivoiAutorizacije = new ArrayList<>();
        for(int i = 0; i <= 10; i++){
            nivoiAutorizacije.add(i);
        }
        return nivoiAutorizacije;
    }


}
