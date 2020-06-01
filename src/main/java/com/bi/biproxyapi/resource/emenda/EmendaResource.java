package com.bi.biproxyapi.resource.emenda;


import java.nio.charset.Charset;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@EnableResourceServer
@RestController
@RequestMapping("/emenda")
public class EmendaResource {

	
	final String site = "http://10.243.135.5/pentaho/plugin/cda/api/doQuery?";
	final String path = "path=/public/dashboard/emenda";
	final String user = "&userid=anonimo.bi&password=Da$hb0ard";
	final String charset = "UTF-8";
	

	@GetMapping("/anos")
	public String listarAnos() {
		final String uri = 	site +
							path +
							"/dash_emendas_ano.cda&dataAccessId=queryAno" +
							user;		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);								
		return result;
	}
	
	
	@GetMapping("/autores")
	public String listarAutores() {
		final String uri =  site +
							path +
							"/dimensao_autor.cda&dataAccessId=Autores" +
							user;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);				
		return result;
	}
	
	
	@GetMapping("/orgaos")
	public String listarOrgaos() {		
		final String uri =  site +
							path +
							"/dash_emendas_orgaos.cda&dataAccessId=queryOrgaos" +
							user;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);	
		return  result;
	}
	
	

	@GetMapping("/totais/{ano}")
	public String emendaTotal(@PathVariable Long ano) {
		final String uri =  site +
							path +
							"/dash_emenda_total.cda&dataAccessId=queryTotal" +
							"&parampAno=" +
							ano +
							user ;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);	
		return  result;
	}
	
	
	@GetMapping("/processos/{ano}/{cod_emenda}")
	public String emendaProcessos(@PathVariable Long ano, @PathVariable String cod_emenda) {
		final String uri = 	site +
							path + 
							"/dash_emenda_processo.cda&dataAccessId=queryProcesso" +
							"&parampAno=" + ano +
							"&parampEmenda=" + cod_emenda +
							user ;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);	
		return  result;
	}
	
	
	

	@GetMapping("/geral/{ano}")
	public String emendaGeral(@PathVariable Long ano) {
		final String uri =  site +
							path +
							"/dash_emendas_geral.cda&dataAccessId=queryGeral" +
							"&parampAno=" +
							ano +
							user ;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);	
		return  result;
	}
	
	
	
	
	
	
	
}
