package com.bi.biproxyapi.resource.orcamento;

import java.nio.charset.Charset;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bi.biproxyapi.model.ApropRecGlobal;
import com.bi.biproxyapi.model.DataFimMes;
import com.bi.biproxyapi.model.Despesa;
import com.bi.biproxyapi.model.DespesaAcum;
import com.bi.biproxyapi.model.DespesasAgrupadas;
import com.bi.biproxyapi.model.Indicadores;
import com.bi.biproxyapi.model.Receita;
import com.bi.biproxyapi.model.ReceitaAcum;
import com.bi.biproxyapi.model.ResultadoCaixa;
import com.bi.biproxyapi.model.ResultadoCaixaAcum;
import com.bi.biproxyapi.model.Tendencia;
import com.bi.biproxyapi.service.GestaoFiscalService;


@EnableResourceServer
@RestController
@RequestMapping("/orcamento")
public class OrcamentoResource {

	
	@Autowired
	private GestaoFiscalService gestaoFiscalService;
	
	
	final String site = "http://10.243.135.5/pentaho/plugin/cda/api/doQuery?";
	final String path = "path=/public/dashboard/orcamento";
	final String user = "&userid=anonimo.bi&password=********";
	final String charset = "UTF-8";
		

	@GetMapping("/geral/{fonte}")
	public String orcamentoGeral(@PathVariable String fonte) throws ParseException {
		final String uri =  site +
							path +
							"/dash_orc_receita_despesa.cda&dataAccessId=queryOrcReceitaDespesa" +
							"&parampFonte=" +
							fonte +
							user ;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);	
	
		return  result;
	}	
	
	
	
	@GetMapping("/resultadoCaixa/{ano}/{mes}/{fonte}")
	public ResultadoCaixa resultadoCaixa(@PathVariable String ano,@PathVariable String mes, @PathVariable String fonte) throws ParseException {
		final String uri =  site +
							path +
							"/dash_result_atual_anterior.cda&dataAccessId=qResult_atual_anterior" +
							"&parampAno=" +
							ano +
							"&parampMes=" +
							mes+
							"&parampFonte=" +
							fonte +
							user;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);	
	
		return  gestaoFiscalService.resultadoCaixa(result);
	}	
	

	@GetMapping("/resultadoCaixaAcum/{ano}/{mes}/{fonte}")
	public ResultadoCaixaAcum resultadoCaixaAcum(@PathVariable String ano,@PathVariable String mes,@PathVariable String fonte) throws ParseException {
		final String uri =  site +
							path +
							"/dash_result_acum.cda&dataAccessId=qResult_Acum" +
							"&parampAno=" +
							ano +
							"&parampMes=" +
							mes +
							"&parampFonte=" +
							fonte +
							user ;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);	
		
		return  gestaoFiscalService.resultadoCaixaAcum(result);
	}	
	

	@GetMapping("/receita/{ano}/{mes}/{fonte}")
	public Receita receita(@PathVariable String ano,@PathVariable String mes,@PathVariable String fonte) throws ParseException {
		final String uri =  site +
							path +
							"/dash_receita_atual_anterior.cda&dataAccessId=qReceita_atual_anterior" +
							"&parampAno=" +
							ano +
							"&parampMes=" +
							mes +
							"&parampFonte=" +
							fonte +
							user ;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);	
		
		return  gestaoFiscalService.receita(result);
	}	
	
	
	@GetMapping("/receitaAcum/{ano}/{mes}/{fonte}")
	public ReceitaAcum receitaAcum(@PathVariable String ano,@PathVariable String mes,@PathVariable String fonte) throws ParseException {
		final String uri =  site +
							path +
							"/dash_receita_acum.cda&dataAccessId=qReceita_acum" +
							"&parampAno=" +
							ano +
							"&parampMes=" +
							mes +
							"&parampFonte=" +
							fonte +
							user ;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);	
			
		return  gestaoFiscalService.receitaAcum(result);
	}
	
	

	@GetMapping("/despesa/{ano}/{mes}/{fonte}")
	public Despesa despesa(@PathVariable String ano,@PathVariable String mes,@PathVariable String fonte) throws ParseException {
		final String uri =  site +
							path +
							"/dash_despesa_atual_anterior.cda&dataAccessId=qDespesa_atual_anterior" +
							"&parampAno=" +
							ano +
							"&parampMes=" +
							mes +
							"&parampFonte=" +
							fonte +
							user ;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);	
		
		return  gestaoFiscalService.despesa(result);
	}	
	
	
	@GetMapping("/despesaAcum/{ano}/{mes}/{fonte}")
	public DespesaAcum despesaAcum(@PathVariable String ano,@PathVariable String mes,@PathVariable String fonte) throws ParseException {
		final String uri =  site +
							path +
							"/dash_despesa_acum.cda&dataAccessId=qDespesa_acum" +
							"&parampAno=" +
							ano +
							"&parampMes=" +
							mes +
							"&parampFonte=" +
							fonte +
							user ;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);	
		
		return  gestaoFiscalService.despesaAcum(result);
	}
	
	
	@GetMapping("/tendencia/{ano}/{mes}/{fonte}")
	public Tendencia graficoTendencia(@PathVariable String ano,@PathVariable String mes,@PathVariable String fonte) throws ParseException {
		final String uri =  site +
							path +
							"/dash_grafico_tendencia.cda&dataAccessId=qGraficoTendencia" +
							"&parampAno=" +
							ano +
							"&parampMes=" +
							mes +
							"&parampFonte=" +
							fonte +
							user ;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);	
		
		return gestaoFiscalService.tendencia(result);
	}
	
	@GetMapping("/controle/{ano}/{mes}")
	public DataFimMes fechamento(@PathVariable String ano,@PathVariable String mes) throws ParseException {
		final String uri =  site +
							path +
							"/dash_fim_mes.cda&dataAccessId=qFimMes" +
							"&parampAno=" +
							ano +
							"&parampMes=" +
							mes +
							"&parampFonte=" +
							user ;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);	
		
		return gestaoFiscalService.dataFimMes(result);
	}
	
	
	@GetMapping("/apropRecGlobal/{ano}/{mes}")
	public ApropRecGlobal caixaDetalhado(@PathVariable String ano,@PathVariable String mes) throws ParseException {
		final String uri =  site +
							path +
							"/dash_aprop_rec_global.cda&dataAccessId=qApropRecGlobal" +
							"&parampAno=" +
							ano +
							"&parampMes=" +
							mes +
							user ;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);	
		
		return  gestaoFiscalService.apropRecGlobal(result);
	}
	
	
	@GetMapping("/despesasAgrupadas/{ano}/{mes}")
	public DespesasAgrupadas despesasAgrupadas(@PathVariable String ano,@PathVariable String mes) throws ParseException {
		final String uri =  site +
							path +
							"/dash_despesasAgrupadas.cda&dataAccessId=qDespesasAgrupadas" +
							"&parampAno=" +
							ano +
							"&parampMes=" +
							mes +
							user ;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);	
		
		return  gestaoFiscalService.despesaPoder(result);
	}
	
	@GetMapping("/indicadores/{ano}/{mes}")
	public Indicadores indicadores(@PathVariable String ano,@PathVariable String mes) throws ParseException {
		final String uri =  site +
							path +
							"/dash_indicadores.cda&dataAccessId=Indicadores" +
							"&parampAno=" +
							ano +
							"&parampMes=" +
							mes +
							user ;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName(charset)));
		String result = restTemplate.getForObject(uri, String.class);	
		
		return  gestaoFiscalService.indicadores(result);
	}
	
	
}