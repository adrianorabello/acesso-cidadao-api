package com.bi.biproxyapi.repository;

	
import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bi.biproxyapi.model.Emenda;



public interface EmendaRepository extends JpaRepository<Emenda, Long> {

	
	
	/* listar anos*/
	@Query(value = "select distinct "+
					"t.id_tempo "+
					"from FatoEmenda t")
	Collection<Object> listaAnos();
	
	
	/* listar orgãos*/
	@Query(value =  "SELECT DISTINCT " + 
					"o.cod_orgao,o.sigla " +  
					"FROM FatoEmenda AS e " + 
					"JOIN OrgaoEmenda AS o " + 
					"ON o.id_orgao = e.id_orgao " + 
					"ORDER BY 1")
	Collection<Object> listaOrgaos();
	
	
	/* listar autor*/
	@Query(value =  "SELECT DISTINCT " + 
					"a.cod_autor,a.nome " +  
					"FROM AutorEmenda a")
	Collection<Object> listaAutores();
	
	
	
	/* listar totais*/
	@Query(value = "SELECT "+
				   "sum(f.vlr_autorizado), "+
			       "sum(f.vlr_reservado), "+
			       "sum(f.vlr_empenhado), "+
			       "sum(f.vlr_liquidado), "+
			       "sum(f.vlr_pago), "+
			       "sum(f.rap_pago), "+
			       "sum(f.rap_a_pagar) "+
			       "from FatoEmenda f "+
			       "where f.id_tempo = :ano")
	Optional<Object> emendaTotal(@Param("ano") Long ano);
	
	
	

	/* listar processos*/
	@Query(value = 
			"SELECT  tipo,processo "+
			"FROM (SELECT'NE' tipo,ne.cod_processo processo FROM fat_emenda f "+
			"JOIN dim_emenda_emenda as e ON f.id_emenda = e.id_emenda JOIN dim_ne_emenda as ne on ne.id_ne = f.id_ne JOIN dim_nr_emenda nr on f.id_nr = nr.id_nr "+
			"WHERE SUBSTR(f.id_tempo,1,4) = :ano AND SUBSTR(e.cod_emenda,1,5) = :emenda "+
			"UNION ALL "+
			"SELECT 'NR' tipo, nr.cod_processo processo FROM fat_emenda f "+
			"JOIN dim_emenda_emenda e ON f.id_emenda = e.id_emenda JOIN dim_nr_emenda nr on f.id_nr = nr.id_nr "+
			"WHERE SUBSTR(f.id_tempo,1,4) = :ano AND SUBSTR(e.cod_emenda,1,5) = :emenda)o "+
			"WHERE processo is not null GROUP BY tipo,processo", nativeQuery = true)
	Collection<Object> emendaProcessos(@Param("ano") Long ano,@Param("emenda") String emenda);

	
	/* lista geral*/
	@Query(value = 
			"select cod_orgao,orgao, "+
			"case when ano = 2017 and cod_po = 001304 then '249' when ano = 2017 and cod_po = 001305 then '8' "+
			"when ano = 2017 and cod_po = 001300 then '250' when ano = 2017 and (cod_po = 001299 or (substr(cod_emenda,1,5) = 'E0462' and cod_municipio = 320530)) then '42' "+
			"when ano = 2017 and (cod_po = 001310 or substr(cod_emenda,1,5) in ('R0315','R0318','R0319','R0321','R0328','R0331','R0332','R0323','R0324','R0326')) then '245' "+ 
			"else cod_autor end as cod_autor, "+
			"case when ano = 2017 and cod_po = 001304 then 'DEP. JAMIR MALINI' when ano = 2017 and cod_po = 001305 then 'DEP. ELIANA DADALTO' "+
			"when ano = 2017 and cod_po = 001300 then 'DEP. ESMAEL ALMEIDA' when ano = 2017 and (cod_po = 001299 or (substr(cod_emenda,1,5) = 'E0462' and cod_municipio = 320530)) then 'DEP. JOSE ESMERALDO' "+
			"when ano = 2017 and (cod_po = 001310 or substr(cod_emenda,1,5) in ('R0315','R0318','R0319','R0321','R0328','R0331','R0332','R0323','R0324','R0326')) then 'DEP. RODRIGO COELHO' "+ 
			"else autor end as autor, "+
			"case when ano = 2017 and cod_po = 001304 then '32' when ano = 2017 and cod_po = 001305 then '31' "+
			"when ano = 2017 and cod_po = 001300 then '4' when ano = 2017 and (cod_po = 001299 or (substr(cod_emenda,1,5) = 'E0462' and cod_municipio = 320530)) then '4' "+
			"when ano = 2017 and (cod_po = 001310 or substr(cod_emenda,1,5) in ('R0315','R0318','R0319','R0321','R0328','R0331','R0332','R0323','R0324','R0326')) then '11' "+  
			"else cod_partido end as cod_partido, "+
			"case when ano = 2017 and cod_po = 001304 then 'PTN' when ano = 2017 and cod_po = 001305 then 'PTC' "+
			"when ano = 2017 and cod_po = 001300 then 'PMDB' when ano = 2017 and (cod_po = 001299 or (substr(cod_emenda,1,5) = 'E0462' and cod_municipio = 320530)) then 'PMDB' "+
			"when ano = 2017 and (cod_po = 001310 or substr(cod_emenda,1,5) in ('R0315','R0318','R0319','R0321','R0328','R0331','R0332','R0323','R0324','R0326')) then 'PT' "+  
			"else partido end as partido,cod_emenda,nome_emenda,cod_municipio,municipio,ne,nr,autorizado,reservado,empenhado,liquidado,pago,rap_pago,rap_a_pagar "+
			"from(select e.id_tempo as ano, po.cod_po,o.cod_orgao,o.sigla as orgao,a.cod_autor,a.nome as autor,p.cod_partido, p.sigla as partido, "+
			"em.cod_emenda, em.nome as nome_emenda, m.cod_municipio,m.nome as municipio,e.id_ug as ug,e.id_acao as acao,e.id_nat_despesa as natureza, "+
			"concat(substr(e.id_iduso,5,1),substr(e.id_grupo_fonte,5,1),substr(e.id_fonte,5,2)) as fonte, ifnull(max(ne.cod_processo),'') as ne, "+
			"ifnull(max(nr.cod_processo),'') as nr, ifnull(sum(e.vlr_autorizado),0) as autorizado,ifnull(sum(e.vlr_empenhado),0) as empenhado, "+
			"ifnull(sum(e.vlr_reservado),0) as reservado,ifnull(sum(e.vlr_liquidado),0) as liquidado, ifnull(sum(e.vlr_pago),0) as pago, "+
			"ifnull(sum(e.rap_pago),0) as rap_pago,ifnull(sum(e.rap_a_pagar),0) as rap_a_pagar "+    
			"from fat_emenda e "+
			"join dim_po_emenda po on po.id_po = e.id_po join dim_orgao_emenda o on e.id_orgao = o.id_orgao "+
			"join dim_autor_emenda a on e.id_autor = a.id_autor join dim_partido_emenda p on e.id_partido = p.id_partido "+
			"join dim_emenda_emenda em  on e.id_emenda = em.id_emenda join dim_municipio_emenda m on m.id_municipio = e.id_municipio "+
			"join dim_ne_emenda ne on ne.id_ne = e.id_ne join dim_nr_emenda nr on nr.id_nr = e.id_nr "+
			"group by em.cod_emenda, po.cod_po, e.id_ug, e.id_nat_despesa,e.id_acao,e.id_municipio,e.id_orgao, concat(substr(e.id_iduso,5,1),substr(e.id_grupo_fonte,5,1),substr(e.id_fonte,5,2)), e.id_microrregiao, e.id_esfera)O "+
			"where ano = :ano", nativeQuery = true)
	Collection<Object> emendaGeral(@Param("ano") Long ano);
	
	
	/* lista receita geral*/
	@Query(value = 
			"call sp_dash_orcamento(:fonte)", nativeQuery = true)
	Collection<Object> receitaGeral(@Param("fonte") Boolean fonte);
	
	
	}


	
	/* lista receita geral
@Query(value = 
			"SET SQL_SAFE_UPDATES = 0; DROP TABLE dash_orcamento; " + 
			"CREATE TABLE  dash_orcamento (ano varchar(4), mes varchar(2), vlr_receita decimal(18,2),vlr_despesa decimal(18,2), " + 
			"vlr_duodecimo decimal(18,2)); insert into dash_orcamento " + 
			"SELECT substring(r.id_tempo, 1,4) as ano, " + 
			"case when  length(r.id_tempo) = 5 then concat(0,substr(r.id_tempo,5,1)) " + 
			"else substr(r.id_tempo,5,2) end as mes, " + 
			"sum(r.vlr_rec_liq_arrec) as vlr_receita,0 as vlr_despesa,0 as vlr_duodecimo " + 
			"FROM sepbi.fat_receita as r join dim_fonte_receita as f " + 
			"on r.id_fonte = f.id where if(:fonte, f.codigo  between 01 and 29, f.codigo  > 29) " + 
			"group by ano, mes order by ano desc, mes desc limit 13; " +  
			"insert into dash_orcamento " + 
			"SELECT substring(r.id_tempo, 1,4) as ano, case when  length(r.id_tempo) = 5 " + 
			"then concat(0,substr(r.id_tempo,5,1)) else substr(r.id_tempo,5,2) " + 
			"end as mes, " + 
			"0 as vlr_receita,sum(r.vlr_realizado) as vlr_despesa,0 as vlr_duodecimo " + 
			"FROM sepbi.fat_orcamento as r " + 
			"join dim_fonte_orcamento as f " + 
			"on r.id_fonte = f.id_fonte " + 
			"where (if(:fonte, f.cod_fonte >= 1 and f.cod_fonte <= 29, f.cod_fonte > 29) and " + 
			"if(:fonte, substr(r.id_orgao,6,1) = 5, substr(r.id_orgao,6,1) in (1,2,3,5,6))) " + 
			"group by ano, mes " + 
			"order by ano desc, mes desc " + 
			"limit 13; " +  
			"insert into dash_orcamento " + 
			"SELECT " + 
			"substring(r.id_tempo, 1,4) as ano, " + 
			"case when  length(r.id_tempo) = 5 " + 
			"then concat(0,substr(r.id_tempo,5,1)) " + 
			"else substr(r.id_tempo,5,2) " + 
			"end as mes, " + 
			"0 as vlr_receita,0 as vlr_despesa,sum(r.vlr_duodecimo) as vlr_duodecimo " + 
			"FROM sepbi.fat_receita as r " + 
			"join dim_fonte_receita as f " + 
			"on r.id_fonte = f.id " + 
			"group by ano, mes " + 
			"order by ano desc, mes desc " + 
			"limit 13; " + 
			"SELECT ano,mes,sum(vlr_receita) vlr_receita, " + 
			"sum(vlr_despesa) vlr_despesa, " + 
			"sum(vlr_duodecimo) vlr_duodecimo " + 
			"FROM dash_orcamento " + 
			"group by ano,mes " + 
			"order by ano desc, mes desc;", nativeQuery = true)
	Collection<Object> receitaGeral(@Param("fonte") Boolean fonte);*/



	
	

