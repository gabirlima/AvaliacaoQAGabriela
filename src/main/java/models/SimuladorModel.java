package models;

import java.util.List;

public class SimuladorModel {

    private String id;
    private List<String> meses;
    private List<String> valor;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getMeses(){
        return meses;
    }

    public void setMeses(List<String> meses){
        this.meses = meses;
    }

    public List<String> getValor(){
        return valor;
    }

    public void setValores(List<String> valores){
        this.valor = valores;
    }
}
