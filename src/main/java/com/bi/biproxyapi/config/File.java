package com.bi.biproxyapi.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bi.biproxyapi.config.property.BiproxyProperty;



@Configuration 
public class File {
	
	
	@Autowired
	private BiproxyProperty property;
	

	@Bean
	public FileModel getJson()  {			 
		
		FileModel file = new FileModel();	

		file.setPorta( property.getPort());		

		file.setOrigem(Arrays.asList(property.getOrigins()));
		
		return file;
	}
	 	 
//	 public static Object readJson(String filename) throws Exception {  
//		    FileReader reader = new FileReader(filename);
//		    JSONParser jsonParser = new JSONParser();
//		    return jsonParser.parse(reader);
//	}
	
	
	
	
	
//	@Bean
//	public String getPorta() {
//		
//		String  porta = null;		
//		try (BufferedReader reader = new BufferedReader(new FileReader("c:/porta.txt"))) {			
//			String porta1 = null;			
//			while ((porta1 = reader.readLine()) != null) {
//				System.out.println(porta1);				
//				porta = porta1;
//			}						
//		} catch (IOException e) {
//			System.err.println("Não conseguiu ler o arquivo. Erro: " + e.getMessage());
//		}								
//		return porta;
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Bean
//	 public List<String> getJson() {		 		 
//		    List<String> dados = new ArrayList<String>();		 
//		    JSONObject jsonObject;
//	        //Cria o parse de tratamento
//	        JSONParser parser = new JSONParser();	         	 		 
//		    try {
//	            //Salva no objeto JSONObject o que o parse tratou do arquivo
//	            jsonObject = (JSONObject) parser.parse(new FileReader(
//	                    "c:/file.json"));	             
//	            //Salva nas variaveis os dados retirados do arquivo
//	            String porta = (String) jsonObject.get("port");
//	            Collection<? extends String> origem = (Collection<? extends String>) jsonObject.get("origins");           	 
//	            dados.add(0, porta);
//	            dados.addAll(1, origem);	         	           
//	        } 
//	        //Trata as exceptions que podem ser lançadas no decorrer do processo
//	        catch (FileNotFoundException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        } catch (ParseException e) {
//	            // TODO Auto-generated catch block
//	            e.printStackTrace();
//	        }
//		 	 
//		 return dados;
//	 }
//	
	

	
	
}
