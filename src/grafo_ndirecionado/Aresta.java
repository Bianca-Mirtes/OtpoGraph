package grafo_ndirecionado;

public class Aresta<TIPO> {
    private Vertice<TIPO> verticeInicial;
    private Vertice<TIPO> verticeFinal;
    private TIPO peso; // duração da atividade do vertice inicial 

    public Aresta(Vertice<TIPO> vI, Vertice<TIPO> vF, TIPO peso){
        this.verticeInicial = vI;
        this.verticeFinal = vF;
        this.peso = peso;
    }

    public void setVerticeInicial(Vertice<TIPO> verticeInicial) {
        this.verticeInicial = verticeInicial;
    }
    
    public Vertice<TIPO> getVerticeInicial() {
        return verticeInicial;
    }

    public Vertice<TIPO> getVerticeFinal() {
        return verticeFinal;
    }

    public void setVerticeFinal(Vertice<TIPO> verticeFinal) {
        this.verticeFinal = verticeFinal;
    }
}
