/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.geo;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import config.Constantes;
import dao.AmostraDao;
import entity.AmostraEntity;
import entity.AnaliseEntity;
import entity.AnaliseLinesEntity;
import utils.DaoFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;

 
/**
 *
 * @author Dallagnol
 */
@Controller
@RequestScoped
public class PrincipalController {

    @Inject
    private Result result;

    @Inject
    private HttpServletRequest request;

   
	@Path("/")
    public void index() {
    	//System.out.println(request.getServletContext().getRealPath("/file"));	
    	//System.out.println(request.getServletContext().getRealPath("/scripts/R/Principal/script_geo.r")+ " ");	
    } 

 
	@Path("/funcaoGeo")
    public void funcaoGeo() {

        result.include("areas",
                DaoFactory.areaDaoInstance().findAll());
        System.out.println(request.getServletContext().getRealPath("/file"));
        if (request.getMethod().equals("POST")) {
            try {
            	      	
            	
                Process process = Runtime.getRuntime()
                        .exec(Constantes.ENDERECO_R
                                + request.getServletContext().getRealPath("/scripts/R/Principal/script_geo.r")+ " "
                                + request.getServletContext().getRealPath("/file") + " "
                                + Constantes.DATA_BASE_NAME + " "
                                + Constantes.DATA_BASE_HOST + " "
                                + Constantes.DATA_BASE_USER + " "
                                + Constantes.DATA_BASE_PASSWORD + " "
                                + Constantes.DATA_BASE_PORT + " "
                                + request.getParameter("user") + " "
                                + request.getParameter("area") + " "
                                + request.getParameter("amostra") + " "
                                + '"' + request.getParameter("desc") + '"' + " "
                                + request.getParameter("isi") + " "
                                + request.getParameter("v_lambda") + " "
                                + request.getParameter("auto_lags") + " "
                                + request.getParameter("nro_lags") + " "
                                + request.getParameter("estimador") + " "
                                + request.getParameter("cutoff") + " "
                                + request.getParameter("tamx") + " "
                                + request.getParameter("tamy") + " "
                                + request.getParameter("nro_intervalos_alc") + " "
                                + request.getParameter("nro_intervalos_contr") + " "
                                + request.getParameter("nro_pares") + " "
                                + request.getParameter("nro_min_contr") + " "
                                + request.getParameter("nro_min_alc") + " "
                        );

                try {
                    String ok = null;
                    
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line = null;
                    
                    while ((line = reader.readLine()) != null) {
                        //System.out.println(line);
                        if (line.equals("[1] 9999")) {
                            ok = "OK";
                        }
                    }

                    if (ok != null) {
                        result.redirectTo(this).visualizaGeo();
                    } else {
                        result.include("errorMsg", "Não foi possível realizar a analise favor verificar dados !");
                    }
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    } 

    @Path("/funcaoKrigagem")
    public void funcaoKrigagem() {

        if (request.getMethod().equals("POST")) {
            try {

                Process process = Runtime.getRuntime()
                        .exec(Constantes.ENDERECO_R
                        		+ request.getServletContext().getRealPath("/scripts/R/Principal/script_krig.r")+ " "
                                + request.getServletContext().getRealPath("/mapa") + " "
                                + Constantes.DATA_BASE_NAME + " "
                                + Constantes.DATA_BASE_HOST + " "
                                + Constantes.DATA_BASE_USER + " "
                                + Constantes.DATA_BASE_PASSWORD + " "
                                + Constantes.DATA_BASE_PORT + " "
                                + request.getParameter("user") + " "
                                + request.getParameter("analise_line_id") + " "
                        );

                try {
                    final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line = null;
                    String ok = null;
                    while ((line = reader.readLine()) != null) {
                       // System.out.println(line);
                        if (line.equals("[1] 9999")) {
                            ok = "OK";
                        }
                    }
                    reader.close();
                    if (ok != null) {                        
                        result.redirectTo(this).visualizaMapa(Long.parseLong(request.getParameter("analise_line_id")));
                    } else {
                        result.include("errorMsg", "Não foi possível realizar a analise favor verificar dados !");
                    }
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

    
    
     
    @Path("/funcaoIdw")
    public void funcaoIdw() {
    	
    	 result.include("areas",
                 DaoFactory.areaDaoInstance().findAll());
        
    	 System.out.println(request.getMethod());
    	 if (request.getMethod().equals("POST")) {
    		 
            try {

                Process process = Runtime.getRuntime()
                        .exec(Constantes.ENDERECO_R
                        		+ request.getServletContext().getRealPath("/scripts/R/Principal/script_idw.r")+ " "
                                + request.getServletContext().getRealPath("/mapa") + " "
                                + Constantes.DATA_BASE_NAME + " "
                                + Constantes.DATA_BASE_HOST + " "
                                + Constantes.DATA_BASE_USER + " "
                                + Constantes.DATA_BASE_PASSWORD + " "
                                + Constantes.DATA_BASE_PORT + " "
                                + request.getParameter("user") + " "
                                + request.getParameter("area") + " "
                                + request.getParameter("amostra") + " "
                                + request.getParameter("expoente") + " "
                                + request.getParameter("vizinhos") + " "
                                + request.getParameter("expoini") + " "
                                + request.getParameter("expofinal") + " "
                                + request.getParameter("expoint") + " "
                                + request.getParameter("raio") + " "
                                + request.getParameter("tamx") + " "
                                + request.getParameter("tamy") + " "
                                + request.getParameter("desc") + " "
                        );

                try {
                    final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line = null;
                    String ok = null;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                        if (line.equals("[1] 9999")) {
                            ok = "OK";
                        }
                    }
                    reader.close();
                    if (ok != null) {                        
                        result.redirectTo(this).funcaoIdw();
                    } else {
                        result.include("errorMsg", "Não foi possível realizar a analise favor verificar dados !");
                    }
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
			
        }
    }
    
    
    
    @Get("/buscaAmostrasDaArea")
    public void buscaAmostrasDaArea(Long idArea) {
        AmostraDao amostraDao = DaoFactory.amostraDaoInstance();
        List<AmostraEntity> amostras = amostraDao.findByIdArea(idArea);
        result.use(Results.json()).withoutRoot().from(amostras).serialize();
    }

    @Path("/visualizaGeo")
    public void visualizaGeo() {

        result.include("analises", DaoFactory.analiseInstance().findAllOrdenado("KRIG"));
      
        // result.use(Results.xml()).from(DaoFactory.analiseInstance().findAllOrdenado()).serialize();
       
        if (request.getMethod().equals("POST")) {

            String descricao = null;
            Long userId = null;    
         
            
            result.include("analiseLines",
                    DaoFactory.analiseLineInstance()
                            .findByAnaliseHeader(Long.parseLong(request.getParameter("analiseId"))));
       
            List<AnaliseEntity> analise
                    = DaoFactory.analiseInstance()
                            .findById(Long.parseLong(request.getParameter("analiseId")));

            for (AnaliseEntity analiseEntity : analise) {
                descricao = analiseEntity.getDescricao_analise();
                userId = analiseEntity.getCreated_by();
            }

            result.include("userID", userId);
            result.include("analiseDesc", descricao);
         
        }
    }

    @Get("/visualizaMapa/{i}")
    public void visualizaMapa(Long i) {  
    	
    	List<AnaliseLinesEntity> l = DaoFactory.analiseLineInstance().findAnaliseLine(i);
    	
    	AnaliseLinesEntity a = new AnaliseLinesEntity();
    	
    	for (AnaliseLinesEntity analiseLine : l) {    		 
    		 a = analiseLine;
        }    	
    	
    	result.include("analise", a);    
    	result.include("userID", 872);
        
    }
    
    
    @Path("/visualizaIdw")
    public void visualizaIdw() {

        result.include("analises", DaoFactory.analiseInstance().findAllOrdenado("IDW"));
      
        // result.use(Results.xml()).from(DaoFactory.analiseInstance().findAllOrdenado()).serialize();
       
        if (request.getMethod().equals("POST")) {

                           
            List<AnaliseEntity> analise
                    = DaoFactory.analiseInstance()
                            .findById(Long.parseLong(request.getParameter("analiseId")));
            
            AnaliseEntity a = new AnaliseEntity();
            for (AnaliseEntity analiseEntity : analise) {        
                a = analiseEntity;
            }

            result.include("analise", a);
            result.include("userID", a.getCreated_by());
            result.include("analiseDesc", a.getDescricao_analise());
         
        }
    }
    
    
    
    
    @Path("/visuList")
    public void visuList() {
    	
        result.use(Results.xml()).from(DaoFactory.analiseLineInstance()
                .findByAnaliseHeader(Long.parseLong("628"))).serialize();
    }
    
}
