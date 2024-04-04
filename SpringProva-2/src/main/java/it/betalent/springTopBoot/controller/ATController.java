package it.betalent.springTopBoot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.betalent.springTopBoot.entity.Attore;
import it.betalent.springTopBoot.entity.User;
import it.betalent.springTopBoot.service.ATService;

@Controller
public class ATController {
	
	@Autowired
    ATService atService;
	
			
	@RequestMapping("/")
	public String viewHomePage(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "login";
        }else {

		List<Attore> listaatt = atService.listAll();
	    model.addAttribute("listaatt", listaatt);
	    return "index";
	    
	}
	}
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
	    Attore att = new Attore();
	    model.addAttribute("att", att);
	    return "add";
	}
    
    @RequestMapping("/addAT")
    public String saveProduct(@ModelAttribute("att") Attore att) {
        atService.save(att);
        return "redirect:/";
    }
    
    @RequestMapping("/edit/{id}")									
    public ModelAndView showEditAT(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("edit");
        Attore att = atService.get(id);
        mav.addObject("att", att);
        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteAttoret(@PathVariable(name = "id") Integer id) {
		atService.delete(id);
        return "redirect:/";       
    }
    @RequestMapping("/search")
    public String findByNome(@RequestParam("Nome") String Nome, Model model) {
    	List<Attore> listaatt = atService.findByNome(Nome);
        model.addAttribute("listaatt", listaatt);
        return "index";
    }
 
   

}