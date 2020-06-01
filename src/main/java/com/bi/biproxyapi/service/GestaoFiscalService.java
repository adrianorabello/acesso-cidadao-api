package com.bi.biproxyapi.service;

import java.math.BigDecimal;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.bi.biproxyapi.model.ApropRecGlobal;
import com.bi.biproxyapi.model.DataFimMes;
import com.bi.biproxyapi.model.Despesa;
import com.bi.biproxyapi.model.DespesaAcum;
import com.bi.biproxyapi.model.DespesasAgrupadas;
import com.bi.biproxyapi.model.Indicador;
import com.bi.biproxyapi.model.Indicadores;
import com.bi.biproxyapi.model.ListaDespesasAgrupadas;
import com.bi.biproxyapi.model.ListaResultado;
import com.bi.biproxyapi.model.Receita;
import com.bi.biproxyapi.model.ReceitaAcum;
import com.bi.biproxyapi.model.ResultadoCaixa;
import com.bi.biproxyapi.model.ResultadoCaixaAcum;
import com.bi.biproxyapi.model.ResultadoComposto;
import com.bi.biproxyapi.model.Tendencia;

@Service
public class GestaoFiscalService {

	int colIndexMesAnterior = 0;
    int colIndexMesAtual = 0;
    int colIndexMaxSerieHistorica=0;
    int colIndexVariacao = 0;
    
    int colIndexMesAnteriorAnoAtual= 0;
    int colIndexMesAnteriorAnoAnterior= 0;
    int colIndexVarMesAnterior= 0;
    int colIndexMesAtualAnoAtual= 0;
    int colIndexMesAtualAnoAnterior= 0;
    int colIndexVarMesAtual= 0;
    
    int colIndexRecAcumAnoAtual = 0;
    int colIndexDesAcumAnoAtual = 0;
    
    int colIndexAno = 0;
    int colIndexMes = 0;
	int colIndexVlrReceita=0;
	int colIndexVlrDespesa=0;
	int colIndexVlrResultado=0;
	
	int colIndexStatusMes= 0;
	int colIndexStatusMesAnterior= 0;
	int colIndexFimExtracao=0;
	int colIndexFimCarga=0;
    
	
	int colIndexDescricao = 0;
	int colIndexAcumAtual=0;
	
	
	int colIndexCodigoTipoFonte = 0;
	int colIndexNomeTipoFonte = 0;
	int colIndexCodigoPoder = 0;
	int colIndexNomePoder = 0;
	int colIndexCodigoOrgao = 0;
	int colIndexNomeOrgao = 0;
	int colIndexCodigoUO = 0;
	int colIndexNomeUO = 0;
	int colIndexCodigoCE = 0;
	int colIndexNomeCE = 0;
	int colIndexCodigoGND = 0;
	int colIndexNomeGND = 0;
	int colIndexCodigoFonte = 0;
	int colIndexNomeFonte = 0;
	int colIndexMesAnoAtual = 0;
	int colIndexMesAnoAnterior = 0;
	int colIndexAcumAnoAtual = 0;
	int colIndexAcumAnoAnterior = 0;
	int colIndexAutorizado = 0;
	int colIndexMnePoder = 0;
	int colIndexMneOrgao = 0;
	int colIndexMneUO = 0;
	int colIndexMneCE = 0;
	int colIndexMneGND = 0;
	int colIndexMneFonte = 0;
	
	int colIndexIndicador = 0;
	int colIndexValor = 0;
	int colIndexUnidade = 0;
	int colIndexMin = 0;
	int colIndexMax = 0;
       
    JSONObject metadata = new JSONObject();
	JSONParser jsonParser = new JSONParser();
	JSONObject jsnJsonObject = new JSONObject();
	
	
	public Indicadores indicadores(String result) throws ParseException {
		jsnJsonObject = (JSONObject) jsonParser.parse(result);
		JSONArray metadataArray = (JSONArray) jsnJsonObject.get("metadata");		
		for(int i = 0; i < metadataArray.size();i++) {						
			metadata =  (JSONObject) metadataArray.get(i);						
			
			if(metadata.get("colName").equals("indicador")) {								
				colIndexIndicador =(int) (long) metadata.get("colIndex");								
				
			}else if (metadata.get("colName").equals("valor")){
				colIndexValor =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("unidade")){
				colIndexUnidade =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("min")){
				colIndexMin =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("max")){
				colIndexMax =(int) (long) metadata.get("colIndex");
				
			}
		}		
		JSONArray resultsetArray = (JSONArray) jsnJsonObject.get("resultset");						
		Indicadores indicadores = new Indicadores();	
		for(int i = 0; i < resultsetArray.size();i++) {						
			JSONArray linhaResult = (JSONArray) resultsetArray.get(i);			
			Indicador indicador = new Indicador();			
			
			indicador.setIndicador((String) linhaResult.get(colIndexIndicador));
			indicador.setValor(Double.parseDouble((String)linhaResult.get(colIndexValor)));
			indicador.setUnidade((String) linhaResult.get(colIndexUnidade));
			indicador.setMax(Double.parseDouble((String)linhaResult.get(colIndexMax)));
			indicador.setMin(Double.parseDouble((String)linhaResult.get(colIndexMin)));

			indicadores.getIndicadores().add(indicador);
			
		}
				
		return  indicadores;
  
	}
	
	
	
	public DespesasAgrupadas despesaPoder(String result) throws ParseException {
		jsnJsonObject = (JSONObject) jsonParser.parse(result);
		JSONArray metadataArray = (JSONArray) jsnJsonObject.get("metadata");		
		for(int i = 0; i < metadataArray.size();i++) {						
			metadata =  (JSONObject) metadataArray.get(i);						
			
			if(metadata.get("colName").equals("codigoTipoFonte")) {								
				colIndexCodigoTipoFonte =(int) (long) metadata.get("colIndex");								
				
			}else if (metadata.get("colName").equals("nomeTipoFonte")){
				colIndexNomeTipoFonte =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("codigoPoder")){
				colIndexCodigoPoder =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("nomePoder")){
				colIndexNomePoder =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("mnePoder")){
				colIndexMnePoder =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("codigoOrgao")){
				colIndexCodigoOrgao =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("nomeOrgao")){
				colIndexNomeOrgao =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("mneOrgao")){
				colIndexMneOrgao =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("codigoUO")){
				colIndexCodigoUO =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("nomeUO")){
				colIndexNomeUO =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("mneUO")){
				colIndexMneUO =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("codigoCE")){
				colIndexCodigoCE =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("nomeCE")){
				colIndexNomeCE =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("mneCE")){
				colIndexMneCE =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("codigoGND")){
				colIndexCodigoGND =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("nomeGND")){
				colIndexNomeGND =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("mneGND")){
				colIndexMneGND =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("codigoFonte")){
				colIndexCodigoFonte =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("nomeFonte")){
				colIndexNomeFonte =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("mneFonte")){
				colIndexMneFonte =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("mesAnoAtual")){
				colIndexMesAnoAtual =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("mesAnoAnterior")){
				colIndexMesAnoAnterior =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("acumAnoAtual")){
				colIndexAcumAnoAtual =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("acumAnoAnterior")){
				colIndexAcumAnoAnterior =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("vlr_autorizado")){
				colIndexAutorizado =(int) (long) metadata.get("colIndex");
				
			}
		}		
		JSONArray resultsetArray = (JSONArray) jsnJsonObject.get("resultset");						
		DespesasAgrupadas despesasAgrupadas = new DespesasAgrupadas();	
		for(int i = 0; i < resultsetArray.size();i++) {						
			JSONArray linhaResult = (JSONArray) resultsetArray.get(i);			
			ListaDespesasAgrupadas listaDespesasAgrupadas = new ListaDespesasAgrupadas();			
			
			listaDespesasAgrupadas.setCodigoTipoFonte((String) linhaResult.get(colIndexCodigoTipoFonte));
			listaDespesasAgrupadas.setNomeTipoFonte((String) linhaResult.get(colIndexNomeTipoFonte));
			
			listaDespesasAgrupadas.setCodigoPoder((String) linhaResult.get(colIndexCodigoPoder));
			listaDespesasAgrupadas.setNomePoder((String) linhaResult.get(colIndexNomePoder));
			listaDespesasAgrupadas.setMnePoder((String) linhaResult.get(colIndexMnePoder));
			
			listaDespesasAgrupadas.setCodigoOrgao((String) linhaResult.get(colIndexCodigoOrgao));
			listaDespesasAgrupadas.setNomeOrgao((String) linhaResult.get(colIndexNomeOrgao));
			listaDespesasAgrupadas.setMneOrgao((String) linhaResult.get(colIndexMneOrgao));
			
			listaDespesasAgrupadas.setCodigoUO((String) linhaResult.get(colIndexCodigoUO));
			listaDespesasAgrupadas.setNomeUO((String) linhaResult.get(colIndexNomeUO));
			listaDespesasAgrupadas.setMneUO((String) linhaResult.get(colIndexMneUO));
			
			listaDespesasAgrupadas.setCodigoCE((String) linhaResult.get(colIndexCodigoCE));
			listaDespesasAgrupadas.setNomeCE((String) linhaResult.get(colIndexNomeCE));
			listaDespesasAgrupadas.setMneCE((String) linhaResult.get(colIndexMneCE));
			
			listaDespesasAgrupadas.setCodigoGND((String) linhaResult.get(colIndexCodigoGND));
			listaDespesasAgrupadas.setNomeGND((String) linhaResult.get(colIndexNomeGND));
			listaDespesasAgrupadas.setMneGND((String) linhaResult.get(colIndexMneGND));
			
			listaDespesasAgrupadas.setCodigoFonte((String) linhaResult.get(colIndexCodigoFonte));
			listaDespesasAgrupadas.setNomeFonte((String) linhaResult.get(colIndexNomeFonte));
			listaDespesasAgrupadas.setMneFonte((String) linhaResult.get(colIndexMneFonte));
			
			BigDecimal mesAnoAtual = new BigDecimal(linhaResult.get(colIndexMesAnoAtual).toString());
			BigDecimal mesAnoAnterior = new BigDecimal(linhaResult.get(colIndexMesAnoAnterior).toString());
			BigDecimal acumAnoAtual = new BigDecimal(linhaResult.get(colIndexAcumAnoAtual).toString());
			BigDecimal acumAnoAnterior = new BigDecimal(linhaResult.get(colIndexAcumAnoAnterior).toString());
			BigDecimal valorAutorizado = new BigDecimal(linhaResult.get(colIndexAutorizado).toString());
			
			listaDespesasAgrupadas.setMesAnoAtual((BigDecimal)   mesAnoAtual);			
			listaDespesasAgrupadas.setMesAnoAnterior((BigDecimal)   mesAnoAnterior);	
			listaDespesasAgrupadas.setAcumAnoAtual((BigDecimal)   acumAnoAtual);							
			listaDespesasAgrupadas.setAcumAnoAnterior((BigDecimal)  acumAnoAnterior);	
			listaDespesasAgrupadas.setValorAutorizado((BigDecimal)  valorAutorizado);	
			
			despesasAgrupadas.getDespesasAgrupadas().add(listaDespesasAgrupadas);
			
		}
				
		return  despesasAgrupadas;
  
	}
	
	
	
	
	public ApropRecGlobal apropRecGlobal(String result) throws ParseException {
		jsnJsonObject = (JSONObject) jsonParser.parse(result);
		JSONArray metadataArray = (JSONArray) jsnJsonObject.get("metadata");		
		for(int i = 0; i < metadataArray.size();i++) {						
			metadata =  (JSONObject) metadataArray.get(i);						
			
			if(metadata.get("colName").equals("descricao")) {								
				colIndexDescricao =(int) (long) metadata.get("colIndex");								
				
			}else if (metadata.get("colName").equals("valorAtual")){
				colIndexMesAtual =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("valorAcumAtual")){
				colIndexAcumAtual =(int) (long) metadata.get("colIndex");
				
			}
		}		
		JSONArray resultsetArray = (JSONArray) jsnJsonObject.get("resultset");						
		ApropRecGlobal apropRecGlobal = new ApropRecGlobal();	
		for(int i = 0; i < resultsetArray.size();i++) {						
			JSONArray linhaResult = (JSONArray) resultsetArray.get(i);			
			ListaResultado linhaResultado = new ListaResultado();			
			
			linhaResultado.setDescricao((String) linhaResult.get(colIndexDescricao));		
			
			BigDecimal valorAtual = new BigDecimal(linhaResult.get(colIndexMesAtual).toString());
			BigDecimal valorAcumAtual = new BigDecimal(linhaResult.get(colIndexAcumAtual).toString());
			
			linhaResultado.setMesAtual((BigDecimal)   valorAtual);			
			linhaResultado.setAcumAtual((BigDecimal)  valorAcumAtual);			
			apropRecGlobal.getApropriacaoReceita().add(linhaResultado);
		}
				
		return  apropRecGlobal;
  
	}
		
		
	
	public DataFimMes dataFimMes(String result) throws ParseException {
		DataFimMes dataFimMes = new DataFimMes();		
		jsnJsonObject = (JSONObject) jsonParser.parse(result);
		JSONArray metadataArray = (JSONArray) jsnJsonObject.get("metadata");
		
		for(int i = 0; i < metadataArray.size();i++) {			
			metadata =  (JSONObject) metadataArray.get(i);			
			if(metadata.get("colName").equals("statusMes")) {								
				colIndexStatusMes =(int) (long) metadata.get("colIndex");										
			
			}else if(metadata.get("colName").equals("statusMesAnterior")) {								
				colIndexStatusMesAnterior =(int) (long) metadata.get("colIndex");	
				
			}else if(metadata.get("colName").equals("fim_extracao")) {								
				colIndexFimExtracao =(int) (long) metadata.get("colIndex");	
				
			}else if(metadata.get("colName").equals("fim_carga")) {								
				colIndexFimCarga =(int) (long) metadata.get("colIndex");	
			}
			
		}		
		
		JSONArray resultsetArray = (JSONArray) jsnJsonObject.get("resultset");
		JSONArray resultset =  (JSONArray) resultsetArray.get(0);					
	
		dataFimMes.setStatusMes((String) resultset.get(colIndexStatusMes));
		dataFimMes.setStatusMesAnterior((String) resultset.get(colIndexStatusMesAnterior));
		dataFimMes.setFimExtracao((String) resultset.get(colIndexFimExtracao));
		dataFimMes.setFimCarga((String) resultset.get(colIndexFimCarga));

		return  dataFimMes;
  
	}
	
	
	
	public Tendencia tendencia(String result) throws ParseException {
		jsnJsonObject = (JSONObject) jsonParser.parse(result);
		JSONArray metadataArray = (JSONArray) jsnJsonObject.get("metadata");		
		for(int i = 0; i < metadataArray.size();i++) {						
			metadata =  (JSONObject) metadataArray.get(i);						
			
			if(metadata.get("colName").equals("ano")) {								
				colIndexAno =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("mes")){
				colIndexMes =(int) (long) metadata.get("colIndex");	
				
				
			}else if (metadata.get("colName").equals("vlr_receita")){
				colIndexVlrReceita =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("vlr_despesa")){
				colIndexVlrDespesa =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("vlr_resultado")){
				colIndexVlrResultado =(int) (long) metadata.get("colIndex");
			}
		}		
		JSONArray resultsetArray = (JSONArray) jsnJsonObject.get("resultset");						
		Tendencia tendencia = new Tendencia();	
		for(int i = 0; i < resultsetArray.size();i++) {						
			JSONArray linhaResult = (JSONArray) resultsetArray.get(i);			
			ResultadoComposto composto = new ResultadoComposto();			
			composto.setAno((String) linhaResult.get(colIndexAno));		
			composto.setMes((String) linhaResult.get(colIndexMes));	
			
			BigDecimal vlrReceita = new BigDecimal(linhaResult.get(colIndexVlrReceita).toString());
			BigDecimal vlrDespesa = new BigDecimal(linhaResult.get(colIndexVlrDespesa).toString());
			BigDecimal vlrResuldado = new BigDecimal(linhaResult.get(colIndexVlrResultado).toString());
			
			composto.setVlrReceita((BigDecimal) vlrReceita);			
			composto.setVlrDespesa((BigDecimal)   vlrDespesa);			
			composto.setVlrResultado((BigDecimal)  vlrResuldado);			
			tendencia.getValoresMensais().add(composto);
		}
				
		return  tendencia;
  
	}
	
	
	public DespesaAcum despesaAcum(String result) throws ParseException {
		DespesaAcum despesaAcum = new DespesaAcum();		
		jsnJsonObject = (JSONObject) jsonParser.parse(result);
		JSONArray metadataArray = (JSONArray) jsnJsonObject.get("metadata");
		
		for(int i = 0; i < metadataArray.size();i++) {			
			metadata =  (JSONObject) metadataArray.get(i);			
			if(metadata.get("colName").equals("despesaAcm19")) {								
				colIndexDesAcumAnoAtual =(int) (long) metadata.get("colIndex");										
			
			}else if(metadata.get("colName").equals("refAbsoluta")) {								
				colIndexMaxSerieHistorica =(int) (long) metadata.get("colIndex");	
			}
			
		}		
		
		JSONArray resultsetArray = (JSONArray) jsnJsonObject.get("resultset");
		JSONArray resultset =  (JSONArray) resultsetArray.get(0);		
		BigDecimal despesaAcm19 = new BigDecimal(resultset.get(colIndexDesAcumAnoAtual).toString());
		BigDecimal refAbsoluta = new BigDecimal(resultset.get(colIndexMaxSerieHistorica).toString());				
		despesaAcum.setAcumAnoAtual((BigDecimal) despesaAcm19);
		despesaAcum.setMaxSerieHistorica((BigDecimal)refAbsoluta);

		return  despesaAcum;
  
	}
	
	public Despesa despesa(String result) throws ParseException {
		jsnJsonObject = (JSONObject) jsonParser.parse(result);
		JSONArray metadataArray = (JSONArray) jsnJsonObject.get("metadata");
		
		for(int i = 0; i < metadataArray.size();i++) {			
			metadata =  (JSONObject) metadataArray.get(i);			
			if(metadata.get("colName").equals("desMesAnt19")) {								
				colIndexMesAnteriorAnoAtual =(int) (long) metadata.get("colIndex");							
			
			}else if (metadata.get("colName").equals("desMesAnt18")){
				colIndexMesAnteriorAnoAnterior =(int) (long) metadata.get("colIndex");
									
			}else if (metadata.get("colName").equals("desMesAtual19")){
			   colIndexMesAtualAnoAtual =(int) (long) metadata.get("colIndex");
			
		   }else if (metadata.get("colName").equals("desMesAtual18")){
			   colIndexMesAtualAnoAnterior =(int) (long) metadata.get("colIndex");
				
			}else if (metadata.get("colName").equals("refAbsoluta")){
				colIndexMaxSerieHistorica =(int) (long) metadata.get("colIndex");
					
			}
			
		}
		JSONArray resultsetArray = (JSONArray) jsnJsonObject.get("resultset");
		JSONArray resultset =  (JSONArray) resultsetArray.get(0);
		
		Despesa despesa = new Despesa();
		
		BigDecimal desMesAnt19 = new BigDecimal(resultset.get(colIndexMesAnteriorAnoAtual).toString());
		BigDecimal desMesAnt18 = new BigDecimal(resultset.get(colIndexMesAnteriorAnoAnterior).toString());	
		BigDecimal desMesAtual19 = new BigDecimal(resultset.get(colIndexMesAtualAnoAtual).toString());
		BigDecimal desMesAtual18 = new BigDecimal(resultset.get(colIndexMesAtualAnoAnterior).toString());	
		BigDecimal refAbsoluta = new BigDecimal(resultset.get(colIndexMaxSerieHistorica).toString());	
		
		despesa.setMesAnteriorAnoAtual((BigDecimal) desMesAnt19);
		despesa.setMesAnteriorAnoAnterior((BigDecimal) desMesAnt18);
		despesa.setMesAtualAnoAtual((BigDecimal) desMesAtual19);
		despesa.setMesAtualAnoAnterior((BigDecimal) desMesAtual18);
		despesa.setMaxSerieHistorica((BigDecimal) refAbsoluta);
		
		return  despesa;
  
	}
	
	

	public ReceitaAcum receitaAcum(String result) throws ParseException {
		jsnJsonObject = (JSONObject) jsonParser.parse(result);
		JSONArray metadataArray = (JSONArray) jsnJsonObject.get("metadata");
		
		for(int i = 0; i < metadataArray.size();i++) {			
			metadata =  (JSONObject) metadataArray.get(i);			
			if(metadata.get("colName").equals("receitaAcm19")) {								
				colIndexRecAcumAnoAtual =(int) (long) metadata.get("colIndex");										
			}else if(metadata.get("colName").equals("refAbsoluta")) {								
				colIndexMaxSerieHistorica =(int) (long) metadata.get("colIndex");	
			}
		}		
		JSONArray resultsetArray = (JSONArray) jsnJsonObject.get("resultset");
		JSONArray resultset =  (JSONArray) resultsetArray.get(0);
		ReceitaAcum receitaAcum = new ReceitaAcum();	
		
		BigDecimal receitaAcm19 = new BigDecimal(resultset.get(colIndexRecAcumAnoAtual).toString());
		BigDecimal refAbsoluta = new BigDecimal(resultset.get(colIndexMaxSerieHistorica).toString());	
		
		receitaAcum.setAcumAnoAtual((BigDecimal) receitaAcm19);
		receitaAcum.setMaxSerieHistorica((BigDecimal) refAbsoluta);

		return  receitaAcum;
  
	}
	
	
	
	public Receita receita(String result) throws ParseException {
		jsnJsonObject = (JSONObject) jsonParser.parse(result);
		JSONArray metadataArray = (JSONArray) jsnJsonObject.get("metadata");
		
		for(int i = 0; i < metadataArray.size();i++) {			
			metadata =  (JSONObject) metadataArray.get(i);			
			if(metadata.get("colName").equals("recMesAnt19")) {								
				colIndexMesAnteriorAnoAtual =(int) (long) metadata.get("colIndex");							
			
			}else if (metadata.get("colName").equals("recMesAnt18")){
				colIndexMesAnteriorAnoAnterior =(int) (long) metadata.get("colIndex");
									
			}else if (metadata.get("colName").equals("recMesAtual19")){
			   colIndexMesAtualAnoAtual =(int) (long) metadata.get("colIndex");
			
		   }else if (metadata.get("colName").equals("recMesAtual18")){
			   colIndexMesAtualAnoAnterior =(int) (long) metadata.get("colIndex");
			      
				
			}else if (metadata.get("colName").equals("refAbsoluta")){
				colIndexMaxSerieHistorica =(int) (long) metadata.get("colIndex");
					
			}
			
		}
		
		JSONArray resultsetArray = (JSONArray) jsnJsonObject.get("resultset");
		JSONArray resultset =  (JSONArray) resultsetArray.get(0);
		Receita receita = new Receita();
		
		BigDecimal recMesAnt19 = new BigDecimal(resultset.get(colIndexMesAnteriorAnoAtual).toString());
		BigDecimal recMesAnt18 = new BigDecimal(resultset.get(colIndexMesAnteriorAnoAnterior).toString());	
		BigDecimal recMesAtual19 = new BigDecimal(resultset.get(colIndexMesAtualAnoAtual).toString());
		BigDecimal recMesAtual18 = new BigDecimal(resultset.get(colIndexMesAtualAnoAnterior).toString());	
		BigDecimal refAbsoluta = new BigDecimal(resultset.get(colIndexMaxSerieHistorica).toString());
		
		receita.setMesAnteriorAnoAtual((BigDecimal) recMesAnt19);
		receita.setMesAnteriorAnoAnterior((BigDecimal) recMesAnt18);
		receita.setMesAtualAnoAtual((BigDecimal) recMesAtual19);
		receita.setMesAtualAnoAnterior((BigDecimal)recMesAtual18);
		receita.setMaxSerieHistorica((BigDecimal) refAbsoluta);
		
		return  receita;
  
	}
	
	
	
	public ResultadoCaixa resultadoCaixa(String result) throws ParseException {
		jsnJsonObject = (JSONObject) jsonParser.parse(result);
		JSONArray metadataArray = (JSONArray) jsnJsonObject.get("metadata");
		
		for(int i = 0; i < metadataArray.size();i++) {
			metadata =  (JSONObject) metadataArray.get(i);			
			if(metadata.get("colName").equals("resultado_anterior")) {
				colIndexMesAnterior =(int) (long) metadata.get("colIndex");
			}else if (metadata.get("colName").equals("resultado_atual")){
				colIndexMesAtual =(int) (long) metadata.get("colIndex");
			}else if (metadata.get("colName").equals("refAbsoluta")){
				colIndexMaxSerieHistorica =(int) (long) metadata.get("colIndex");
			}
		}
		
		JSONArray resultsetArray = (JSONArray) jsnJsonObject.get("resultset");
		JSONArray resultset =  (JSONArray) resultsetArray.get(0);		
		ResultadoCaixa resultadoCaixa = new ResultadoCaixa();
		
		BigDecimal resultado_anterior = new BigDecimal(resultset.get(colIndexMesAnterior).toString());
		BigDecimal resultado_atual = new BigDecimal(resultset.get(colIndexMesAtual).toString());	
		BigDecimal refAbsoluta = new BigDecimal(resultset.get(colIndexMaxSerieHistorica).toString());
		
		resultadoCaixa.setMesAnterior((BigDecimal) resultado_anterior);
		resultadoCaixa.setMesReferencia((BigDecimal) resultado_atual);
		resultadoCaixa.setMaxSerieHistorica((BigDecimal) refAbsoluta);
		
		return  resultadoCaixa;
  
	}
	
	
	public ResultadoCaixaAcum resultadoCaixaAcum(String result) throws ParseException {
		jsnJsonObject = (JSONObject) jsonParser.parse(result);
		JSONArray metadataArray = (JSONArray) jsnJsonObject.get("metadata");
		
		for(int i = 0; i < metadataArray.size();i++) {			
			metadata =  (JSONObject) metadataArray.get(i);			
			if(metadata.get("colName").equals("acmAnt")) {								
				colIndexMesAnterior =(int) (long) metadata.get("colIndex");
			}else if (metadata.get("colName").equals("acmAtual")){
				colIndexMesAtual =(int) (long) metadata.get("colIndex");
			}
		}
		
		JSONArray resultsetArray = (JSONArray) jsnJsonObject.get("resultset");
		JSONArray resultset =  (JSONArray) resultsetArray.get(0);
		ResultadoCaixaAcum resultadoCaixaAcum = new ResultadoCaixaAcum();
		
		BigDecimal acmAnt = new BigDecimal(resultset.get(colIndexMesAnterior).toString());
		BigDecimal acmAtual = new BigDecimal(resultset.get(colIndexMesAtual).toString());	

		resultadoCaixaAcum.setMesAnterior((BigDecimal) acmAnt);
		resultadoCaixaAcum.setMesReferencia((BigDecimal) acmAtual);
		
		return  resultadoCaixaAcum;
  
	}
	
	
	
	
	
	
}
