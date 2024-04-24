package grafo_direcionado;

import java.util.ArrayList;

public class Vertice<TIPO> {
    private TIPO valor; // nome da atividade
    private ArrayList<Aresta<TIPO>> arestasEntrada;
    private ArrayList<Aresta<TIPO>> arestasSaida;
    private ArrayList<Vertice<TIPO>> verticesAdj = new ArrayList<>();
    private TIPO tipoAtv; // compromisso (0) ou tradicional (1)
    private TIPO pesoAtvd; // peso de cada atividade > vai ser mandado para os vértices

    public Vertice(TIPO valor, TIPO tipoAtv, TIPO peso) {
        this.valor = valor;
        this.tipoAtv = tipoAtv;
        this.arestasEntrada = new ArrayList<>();
        this.arestasSaida = new ArrayList<>();
        this.pesoAtvd = peso;
    }

    public TIPO getPesoAtvd() {
        return this.pesoAtvd;
    }

    public void setPesoAtvd(TIPO peso) {
        this.pesoAtvd = peso;
    }

    public TIPO getValor() {
        return valor;
    }

    public void setValor(TIPO valor) {
        this.valor = valor;
    }

    public TIPO geTipoAtv() {
        return tipoAtv;
    }

    public void setTipoAtv(TIPO tipo) {
        this.tipoAtv = tipo;
    }

    public void setVerticesAdj() {
        if (verticesAdj.size() != 0) {
            verticesAdj.clear();
        }
        for (Aresta<TIPO> aresta : this.arestasSaida) {
            verticesAdj.add(aresta.getVerticeFinal());
        }
    }

    public ArrayList<Aresta<TIPO>> getArestasEntradArestas() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<TIPO>> getArestasSaida() {
        return arestasSaida;
    }

    public ArrayList<Vertice<TIPO>> getVerticesAdj() {
        return verticesAdj;
    }

    public void AddArestaEntrada(Aresta<TIPO> aresta) {
        this.arestasEntrada.add(aresta);
    }

    public void AddArestaSaida(Aresta<TIPO> aresta) {
        this.arestasSaida.add(aresta);
    }
}