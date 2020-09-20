package com.example.demo.stock.controllers.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.stock.data.model.StockData;
import com.example.demo.stock.services.api.StockDataService;

@RestController()

@RequestMapping("/stockData")

public class StockDataApiController {

	@Autowired
    StockDataService stockDataService;
	
	@ModelAttribute("stockData")
	public StockData loadEmptyModelBean(){
	   return new StockData();
	}
	
    @GetMapping("/")
    public String index(Model model) {
    	model.addAttribute("stockData", new StockData());
        return "upload";
    }
    
    @GetMapping("/addnew")
    public ModelAndView showAddForm(Model model) {
    	Map<String, Object> params = new HashMap<>();
	    params.put("stockData", new StockData());

	    return new ModelAndView("add", params);
    }
	
	@GetMapping("")
	public ModelAndView getStockData(@RequestParam String stockName, Model model) {
		List<StockData> list = stockDataService.findByStockName(stockName);
		Map<String, Object> params = new HashMap<>();
	    params.put("stocks", list);
	    params.put("stockData", new StockData());

	    return new ModelAndView("upload", params);
		//model.addAttribute("stocks",list);
		//return "redirect:/";
	}

	@PostMapping("/add")
	public ModelAndView addStockData(@ModelAttribute("stockData") StockData stockData, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		Map<String, Object> params = new HashMap<>();
	    

	    
		
		if(!bindingResult.hasErrors()) {
	    	stockDataService.insert(stockData);
	    	redirectAttributes.addFlashAttribute("message",
		            "Successfully added new row.");
	    	return new ModelAndView("upload", params);
	    } else {
	    	redirectAttributes.addFlashAttribute("message",
	    			"Error adding new row.");

	    	return new ModelAndView("add", params);
	    }
	}
}
