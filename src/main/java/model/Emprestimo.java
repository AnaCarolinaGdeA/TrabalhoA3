
package model;

import DAO.EmprestimoDAO;
import java.util.ArrayList;
import java.util.Date;


public class Emprestimo {
    
    public int id;
    public Amigo amigo;
    public Ferramenta ferramenta;
    public Date dataEmp;
    public Date dataDev;
    
    public Emprestimo(){
    }
    
    public Emprestimo(int id, Amigo amigo, Ferramenta ferramenta, Date dataEmp, Date dataDev) {
        this.id = id;
        this.amigo = amigo;
        this.ferramenta = ferramenta;
        this.dataEmp = dataEmp;
        this.dataDev = dataDev;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

    public Amigo getAmigo() {
        return amigo;
    }

    public void setFerramentaId(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    public void setDataEmp(Date dataEmp) {
        this.dataEmp = dataEmp;
    }

    public Date getDataEmp() {
        return dataEmp;
    }

    public void setDataDev(Date dataDev) {
        this.dataDev = dataDev;
    }

    public Date getDataDev() {
        return dataDev;
    }

    @Override
    public String toString() {
        return "Empréstimo:\n"
                + "ID: " + id + "\n"
                + "Amigo: " + amigo + "\n"
                + "Ferramenta: " + ferramenta + "\n"
                + "Data de Empréstimo: " + dataEmp + "\n"
                + "Data de Devolução: " + dataDev;
    }

    /*
    public ArrayList getListaEmprestimos(){
        return EmprestimoDAO.listaemprestimos;
    }
    
    public boolean InsertEmprestimoBD(EmprestimoTESTE objeto){
        EmprestimoDAO.listaemprestimos.add(objeto);
        return true;
    }
    
    public boolean DeleteEmprestimoBD(int id){
        int indice = this.procuraIndice(id);
        EmprestimoDAO.listaemprestimos.remove(indice);
        return true;
    }
    
    public boolean UpdateEmprestimoBD(int id, EmprestimoTESTE objeto){
        int indice = this.procuraIndice(id);
        EmprestimoDAO.listaemprestimos.set(indice, objeto);
        return true;
    }
    
    private int procuraIndice(int id){
        int indice = -1;
        for(int i = 0; i<EmprestimoDAO.listaemprestimos.size(); i++){
            if(EmprestimoDAO.listaemprestimos.get(i).getId() == id){
                indice = i;
            }
        }
        return indice;
    }*/
}