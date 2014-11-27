package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.Chale;
import model.Pousada;
import model.Quarto;
import model.QuartoComum;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PousadaController {
	
	private Pousada pousada;
	
	@RequestMapping("/principal")
	public String execute() {
		System.out.println("Executando a lógica com Spring MVC");
		
		if(pousada == null){
			criaQuartos();
		}
		
		return "principal";
	}
	
	private void criaQuartos() {
		pousada = new Pousada();
		Map<String, Quarto> quartos = new HashMap<String, Quarto>();
		for(Integer i=1; i<11; i++){
			quartos.put(i.toString(), new QuartoComum());
		}
		for(Integer i=11; i<21; i++){
			quartos.put(i.toString(), new Chale());
		}
		
		pousada.setQuartosLivres(quartos);
		
	}

	@RequestMapping(value = "/registroQuartoComum", method = RequestMethod.GET)
	public ModelAndView registroQuarto(HttpServletRequest request) {
		Map<String,Quarto> quartos = pousada.getQuartosLivres();
		return new ModelAndView("cadastroQuartoComum", "command", new QuartoComum());
	}
	
	@RequestMapping(value = "/quartoRegistrado", method = RequestMethod.POST)
	public String quartoRegistrado(@ModelAttribute("SpringWeb")QuartoComum quartoComum, ModelMap model) {
		model.addAttribute("numero", quartoComum.getNumero());
		model.addAttribute("possuiBanheira", quartoComum.getPossuiBanheira());
		quartoComum.setEstaOcupado(true);
		
		pousada.getQuartosLivres().remove(quartoComum.getNumero());
		pousada.getQuartosOcupados().put(quartoComum.getNumero(), quartoComum);
		
		return "quartos";
	}
	
	@RequestMapping(value = "/liberaQuartoComum", method = RequestMethod.POST)
	public String liberaQuarto(@ModelAttribute("userId")Integer userId, Model model) {
		
		Quarto quarto = pousada.getQuartosOcupados().get(userId);
		pousada.getQuartosOcupados().remove(userId);
		pousada.getQuartosLivres().put(quarto.getNumero(), quarto);
		
		return "quartos";
	}
}