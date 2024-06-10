
package model;

import DAO.FerramentaDAO;
import java.util.ArrayList;


public class Ferramenta {
    
    public int id;
    public String Fnome;
    public String marca;
    public double custo;
    
    public Ferramenta(){
    }
    
    public Ferramenta(int id, String Fnome, String marca, double custo){
        this.id = id;
        this.Fnome = Fnome;
        this.marca = marca;
        this.custo = custo;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setFnome(String Fnome){
        this.Fnome = Fnome;
    }
    
    public String getFnome(){
        return Fnome;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public void setCusto(double custo){
        this.custo = custo;
    }
    
    public double getCusto(){
        return custo;
    }
    
    @Override
    public String toString(){
        return  "\nId: "                        + this.getId() 
                + "\nNome Ferramenta: "         + this.getFnome() 
                + "\nMarca: "                   + this.getMarca() 
                + "\nCusto de Aquisição: "      + this.getCusto();          
    }
    
    /*
    public ArrayList getListaFerramentas(){
        return FerramentaDAO.listaferramentas;
    }
    
    public boolean InsertFerramentaBD(Ferramenta objeto){
        FerramentaDAO.listaferramentas.add(objeto);
        return true;
    }
    
    public boolean DeleteFerramentaBD(int id){
        int indice = this.procuraIndice(id);
        FerramentaDAO.listaferramentas.remove(indice);
        return true;
    }
    
    public boolean UpdateFerramentaBD(int id, Ferramenta objeto){
        int indice = this.procuraIndice(id);
        FerramentaDAO.listaferramentas.set(indice, objeto);
        return true;
    }
    
    private int procuraIndice(int id){
        int indice = -1;
        for(int i = 0; i<FerramentaDAO.listaferramentas.size(); i++){
            if(FerramentaDAO.listaferramentas.get(i).getId() == id){
                indice = i;
            }
        }
        return indice;
    }*/
    
}
