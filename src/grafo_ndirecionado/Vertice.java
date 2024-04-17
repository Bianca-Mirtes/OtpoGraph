package grafo_ndirecionado;

import java.util.ArrayList;

public class Vertice<TIPO> {
    private TIPO valor;
    private ArrayList<Aresta<TIPO>> arestas;
    private ArrayList<Vertice<TIPO>> verticesAdj = new ArrayList<>();

    public Vertice(TIPO valor){
        this.valor = valor;
        this.arestas = new ArrayList<>();
    }

    public TIPO getValor() {
        return valor;
    }

    public void setValor(TIPO valor) {
        this.valor = valor;
    }

    public void setVerticesAdj(){
        if(verticesAdj.size() != 0){
            verticesAdj.clear();            
        }
        for (Aresta<TIPO> aresta : this.arestas) {
            if(aresta.getVerticeInicial().getValor() == this.valor){
                verticesAdj.add(aresta.getVerticeFinal());
            }else{
                verticesAdj.add(aresta.getVerticeInicial());
            }
        }
    }

    public ArrayList<Aresta<TIPO>> getArestas() {
        return arestas;
    }

    public ArrayList<Vertice<TIPO>> getVerticesAdj() {
        return verticesAdj;
    }

    public void AddAresta (Aresta<TIPO> aresta){
        this.arestas.add(aresta);
    }
}
