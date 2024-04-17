package grafo_direcionado;
import java.util.ArrayList;

public class Vertice<TIPO> {
    private TIPO valor;
    private ArrayList<Aresta<TIPO>> arestasEntrada;
    private ArrayList<Aresta<TIPO>> arestasSaida;
    private TIPO grauPrioridade; // Grau de prioridade do vertice
    //private ArrayList<Vertice<TIPO>> verticesAdj = new ArrayList<>();

    public Vertice(TIPO valor, TIPO grau){
        this.valor = valor;
        this.grauPrioridade = grau;
        this.arestasEntrada = new ArrayList<>();
        this.arestasSaida = new ArrayList<>();
    }

    public TIPO getValor() {
        return valor;
    }

    public void setValor(TIPO valor) {
        this.valor = valor;
    }

    public TIPO getGrauPrioridade() {
        return grauPrioridade;
    }

    public void setGrauPrioridade(TIPO grauPrioridade) {
        this.grauPrioridade = grauPrioridade;
    }

    /*public void setVerticesAdj(){
        if(verticesAdj.size() != 0){
            verticesAdj.clear();            
        }
        for (Aresta<TIPO> aresta : this.arestasEntrada) {
            if(aresta.getVerticeInicial().getValor() == this.valor){
                verticesAdj.add(aresta.getVerticeFinal());
            }else{
                verticesAdj.add(aresta.getVerticeInicial());
            }
        }
        for (Aresta<TIPO> aresta : this.arestasSaida) {
            if(aresta.getVerticeInicial().getValor() == this.valor){
                verticesAdj.add(aresta.getVerticeFinal());
            }else{
                verticesAdj.add(aresta.getVerticeInicial());
            }
        }
    }*/

    public ArrayList<Aresta<TIPO>> getArestasEntradArestas() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<TIPO>> getArestasSaida() {
        return arestasSaida;
    }


    /*public ArrayList<Vertice<TIPO>> getVerticesAdj() {
        return verticesAdj;
    }*/

    public void AddArestaEntrada (Aresta<TIPO> aresta){
        this.arestasEntrada.add(aresta);
    }

    public void AddArestaSaida(Aresta<TIPO> aresta){
        this.arestasSaida.add(aresta);
    }
}