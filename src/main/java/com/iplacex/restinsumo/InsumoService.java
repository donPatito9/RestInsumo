package com.iplacex.restinsumo;

/**
 *
 * @author HP_435
 */
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

   @Path("/insumo")
public class InsumoService {
   /* 
    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "Hola: " + msg;
    return Response.status(200).entity(output).build(); */
   private static List<Insumo> listadoInsumos = new ArrayList<Insumo>();
       
       static {
               listadoInsumos.add(new Insumo("1-4","clavo",100));
               listadoInsumos.add(new Insumo("2-5","martillo",1500));
               listadoInsumos.add(new Insumo("5-7","perno",500));
       }
   @GET
   @Path("/consultarInsumos")
   public String findAllInsumos() {
      String salida;
      Gson gson = new GsonBuilder().create();
      Respuesta r = new Respuesta();
      r.setStatus(200);
      r.setData(listadoInsumos);
      salida = gson.toJson(r);
      return salida;
   }
 @GET
   @Path("/consultarInsumo/{codigo}")
   public String findInsumo( String codigo) {
      String salida;
      Gson gson = new GsonBuilder().create();
      Respuesta r = new Respuesta();

    Insumo encontrado = null;
    if(codigo=="1-4")
        encontrado = new Insumo("1-4","Clavo", 100);
    if(codigo=="2-5")
        encontrado = new Insumo("2-5","Martillo", 1500);
    if(codigo=="5-7")
        encontrado = new Insumo("5-7", "Perno", 500);
      r.setStatus(200);
      r.setData(listadoInsumos);
      salida = gson.toJson(r);
      return salida;
   }
   @POST
   @Path("/agregarInsumos")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Respuesta addInsumos(Insumo insumo) {
       Gson gson = new GsonBuilder().create();
       listadoInsumos.add(insumo);
       
       Respuesta r = new Respuesta();
       r.setStatus(200);
       r.setData(gson.toJson(insumo));
       return r;
   }
   @PUT
   @Path("/modificarInsumo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
   public String updateInsumo(Insumo insumo) {
       String salida;
       int i=0;
       Gson gson = new GsonBuilder().create();
       Respuesta r = new Respuesta();
       
       for(Insumo aux : listadoInsumos) {
           if(aux.getCodigo().equals(insumo.getCodigo())){
             listadoInsumos.get(i).setNombre(insumo.getNombre());
             listadoInsumos.get(i).setValor(insumo.getValor());
           }
           i++;
       }
       r.setStatus(200);
       r.setData("insumo modificado codigo:" + insumo.getCodigo());
       salida = gson.toJson(r);
       return salida;
   }
    @DELETE
    @Path("/eliminarInsumo/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
   public String deleteInsumo(@PathParam("codigo") String codigo) {
      
       int i=0,posicion= -1;
       String salida;
       Gson gson = new GsonBuilder().create();
       Respuesta r = new Respuesta();
       
       for(Insumo aux : listadoInsumos) {
           if(aux.getCodigo().equals(codigo)){
               posicion = i;
           }
           i++;
   }
       listadoInsumos.remove(posicion);
       
       r.setStatus(200);
       r.setData("Insumo eliminado codigo:" + codigo);
       salida = gson.toJson(r);
       return salida;
   }
   }
      
