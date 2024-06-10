
package model;

import DAO.AmigoDAO;
import java.util.ArrayList;


public class Amigo {
    
    public int id;
    public String nome;
    public String telefone;
    
    public Amigo(){
    }
    
    public Amigo(int id, String nome, String telefone){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public int getId(){
        return id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    @Override
    public String toString(){
        return  "ID: "                            + this.getId()
                + "\nNome do Amigo: "             + this.getNome() 
                + "\nTelefone: "                  + this.getTelefone();
    }
    
    /*
    public ArrayList getListaAmigos(){
        return AmigoDAO.listaamigos;
    }
    
    public boolean InsertAmigoBD(Amigo objeto) {
        AmigoDAO.listaamigos.add(objeto);
        return true;
    }
    
    public boolean DeleteAmigoBD(int id){
        int indice = this.procuraIndice(id);
        AmigoDAO.listaamigos.remove(indice);
        return true;
    }
    
    public boolean UpdateAmigoBD(int id, Amigo objeto){
        int indice = this.procuraIndice(id);
        AmigoDAO.listaamigos.set(indice, objeto);
        return true;
    }
    
    private int procuraIndice(int id){
        int indice = -1;
       for(int i = 0; i<AmigoDAO.listaamigos.size(); i++){
           if(AmigoDAO.listaamigos.get(i).getId() == id){
                indice = i;
           }
       }
       return indice;
    }  */
    
}
