package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import model.Chale;
import model.Pousada;
import model.Quarto;
import model.QuartoComum;
import model.Recibo;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
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
		System.out.println("Executando a l�gica com Spring MVC");
		
		if(pousada == null){
			criaQuartos();
		}
		
		return "principal";
	}
	
	private void criaQuartos() {
		pousada = new Pousada();
		Map<Integer, Quarto> quartos = new HashMap<Integer, Quarto>();
		for(Integer i=1; i<11; i++){
			quartos.put(i, new QuartoComum());
		}
		for(Integer i=11; i<21; i++){
			quartos.put(i, new Chale());
		}
		
		pousada.setQuartosLivres(quartos);
		
	}

	@RequestMapping(value = "/registroQuartoComum", method = RequestMethod.GET)
	public ModelAndView registroQuarto() {
		Boolean quartosEsgotados = false;
		Map<Integer, Quarto> quartosComuns = new HashMap<Integer, Quarto>();
		for (Entry<Integer, Quarto> quarto : pousada.getQuartosLivres().entrySet()) {
			if(quarto.getValue() instanceof QuartoComum){
				quartosComuns.put(quarto.getKey(), quarto.getValue());
			}
		}
		
		Set<Integer> quartos = quartosComuns.keySet();
		
		if(quartos.isEmpty()){
			quartosEsgotados = true;
		}
		
		ModelAndView mv = new ModelAndView("cadastroQuartoComum", "command", new QuartoComum());
		mv.addObject("quartos", quartos);
		mv.addObject("todosOcupados", quartosEsgotados);
		return mv;
	}
	
	@RequestMapping(value = "/quartoRegistrado", method = RequestMethod.POST)
	public String quartoRegistrado(@ModelAttribute QuartoComum quartoComum, ModelMap model) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		DateTime localDate = new DateTime();
		quartoComum.setEstaOcupado(true);
		quartoComum.setDataEntrada(localDate);
		
		pousada.getQuartosLivres().remove(quartoComum.getNumero());
		pousada.getQuartosOcupados().put(quartoComum.getNumero(), quartoComum);
		Set<Entry<Integer, Quarto>> quartosOcupados = pousada.getQuartosOcupados().entrySet();
		
		model.addAttribute("quartos", quartosOcupados);
		model.addAttribute("datafull", df.format(quartoComum.getDataEntrada().toDate()));
		
		
		return "quartosOcupados";
	}
	
	@RequestMapping(value = "/liberaQuartoComum", method = RequestMethod.GET)
	public ModelAndView liberaQuarto() {
		Boolean quartosLivres=false;
		Map<Integer, Quarto> quartosComuns = new HashMap<Integer, Quarto>();
		for (Entry<Integer, Quarto> quarto : pousada.getQuartosOcupados().entrySet()) {
			if(quarto.getValue() instanceof QuartoComum){
				quartosComuns.put(quarto.getKey(), quarto.getValue());
			}
		}
		
		Set<Integer> quartos = quartosComuns.keySet();
		
		if(quartos.isEmpty()){
			quartosLivres = true;
		}
		
		ModelAndView mv = new ModelAndView("liberaQuartoComum", "command", new QuartoComum());
		mv.addObject("quartos", quartos);
		mv.addObject("quartosLivres", quartosLivres);
		return mv;
		
	}
	
	@RequestMapping(value = "/quartoComumLiberado", method = RequestMethod.POST)
	public String quartoLiberado(@ModelAttribute QuartoComum quartoComum, ModelMap model) {
		Recibo recibo = new Recibo();
		DateTime localDate = new DateTime();
		quartoComum.setEstaOcupado(false);
		
		pousada.getQuartosOcupados().remove(quartoComum.getNumero());
		pousada.getQuartosLivres().put(quartoComum.getNumero(), quartoComum);
		
		model.addAttribute("quarto", quartoComum);
		model.addAttribute("totalDevido", recibo.getTotalDevido(quartoComum, localDate));
		
		
		return "cobranca";
	}
}