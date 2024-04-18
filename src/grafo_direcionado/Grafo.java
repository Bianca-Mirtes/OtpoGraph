package grafo_direcionado;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Grafo<TIPO> {
    private ArrayList<Vertice<TIPO>> vertices; // atividades
    private ArrayList<Aresta<TIPO>> arestas; // duração das atividades
    private float startDay; // hora de inicio das atividades
    private float finishDay; // hora de finalização
    private float workingHours; // horas uteis

    public Grafo(float start, float finish) {
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
        this.startDay = start;
        this.finishDay = finish;
        this.workingHours = start - finish;
    }

    public int AddVertice(TIPO tarefa, TIPO tipo, TIPO peso) {
        if (tarefa != null && tipo != null) {
            Vertice<TIPO> newVertice = new Vertice<>(tarefa, tipo, peso);
            this.vertices.add(newVertice);
            return this.vertices.size() - 1;
        }
        return -1;
    }

    public void AddAresta(int verticeInical, int verticeFinal, TIPO peso) {
        Vertice<TIPO> vFinal = getVertice(this.vertices.get(verticeFinal).getValor());
        Vertice<TIPO> vInicial = getVertice(this.vertices.get(verticeInical).getValor());

        if (vInicial != null && vFinal != null) {
            Aresta<TIPO> newAresta = new Aresta<TIPO>(vInicial, vFinal, peso);
            vInicial.AddArestaSaida(newAresta);
            vFinal.AddArestaEntrada(newAresta);
            this.arestas.add(newAresta);
        }
    }

    public Vertice<TIPO> getVertice(TIPO valor) {
        Vertice<TIPO> verticeCurrent = null;
        for (Vertice<TIPO> vertice : vertices) {
            if (vertice.getValor().equals(valor)) {
                verticeCurrent = vertice;
                break;
            }
        }
        return verticeCurrent;
    }

    public Aresta<TIPO> findAresta(Vertice<TIPO> v1, Vertice<TIPO> v2) {
        // Percorre as arestas do vértice de origem
        for (Aresta<TIPO> aresta : v1.getArestasSaida()) {
            // Verifica se a aresta conecta os vértices especificados
            if (aresta.getVerticeFinal().equals(v2)) {
                return aresta;
            }
        }
        return null;
    }

    /*
     * public int Diametro(){
     * int tamCaminho = 0;
     * int maiorCaminho = 0;
     * for (Vertice<TIPO> vertice1 : this.vertices) {
     * for (Vertice<TIPO> vertice2 : this.vertices) {
     * if(vertice2.getValor() != vertice1.getValor()){
     * System.out.println("V1: " + vertice1.getValor());
     * System.out.println("V2: " + vertice2.getValor());
     * tamCaminho = calcularCaminhos(vertice1, vertice2);
     * if(tamCaminho > maiorCaminho){
     * maiorCaminho = tamCaminho;
     * }
     * }
     * }
     * }
     * return maiorCaminho;
     * }
     * 
     * public int calcularCaminhos(Vertice<TIPO> v1, Vertice<TIPO> v2){
     * int tamanhoCaminho = 0;
     * ArrayList<Vertice<TIPO>> vMarcados = new ArrayList<>(); // vertices marcados
     * ArrayList<Aresta<TIPO>> aVisitadas = new ArrayList<>(); // arestas visitadas
     * ArrayList<Vertice<TIPO>> fila = new ArrayList<>(); // fila com a ordem para
     * percorrer
     * Vertice<TIPO> current = v1;
     * current.setVerticesAdj();
     * if(current.getVerticesAdj().contains(v2)){
     * System.out.println("tá do ladooo");
     * return ++tamanhoCaminho;
     * }else{
     * ArrayList<Integer> caminhos = new ArrayList<>();
     * //fila.add(current); // inicio do caminho
     * vMarcados.add(current);
     * for (Vertice<TIPO> verticeAdj : current.getVerticesAdj()){
     * vMarcados.add(verticeAdj);
     * tamanhoCaminho++;
     * Vertice<TIPO> verticeTemp = verticeAdj;
     * System.out.println(vMarcados.get(1).getValor());
     * while(verticeTemp.getValor() != v2.getValor()){
     * verticeTemp.setVerticesAdj();
     * for(Vertice<TIPO> verticeAdj2 : verticeTemp.getVerticesAdj()){
     * if(!vMarcados.contains(verticeAdj2)){
     * tamanhoCaminho++;
     * vMarcados.add(verticeAdj2);
     * //System.out.println(verticeAdj2.getValor());
     * verticeTemp = verticeAdj2;
     * //System.out.println(verticeTemp.getValor());
     * break;
     * }
     * }
     * }
     * caminhos.add(tamanhoCaminho);
     * vMarcados.clear();
     * tamanhoCaminho = 0;
     * vMarcados.add(current);
     * }
     * caminhos.sort(Comparator.naturalOrder());
     * return caminhos.get(0);
     * }
     * }
     * 
     * public int componentesConectados(){
     * int numComponentesConexos = 0;
     * ArrayList<Vertice<TIPO>> vMarcados = new ArrayList<>(); // vertices marcados
     * ArrayList<Aresta<TIPO>> aVisitadas = new ArrayList<>(); // arestas visitadas
     * ArrayList<Vertice<TIPO>> fila = new ArrayList<>(); // fila com a ordem para
     * percorrer
     * Vertice<TIPO> current = this.vertices.get(0); // pega o primeiro vertice da
     * lista
     * fila.add(current);
     * vMarcados.add(current);
     * System.out.println(current.getValor());
     * while(vMarcados.size() != this.vertices.size()){
     * while (fila.size() != 0){
     * Vertice<TIPO> vTemp = fila.remove(0);
     * vTemp.setVerticesAdj();
     * for (Vertice<TIPO> verticeAdj : vTemp.getVerticesAdj()) {
     * if(!vMarcados.contains(verticeAdj)){
     * fila.add(verticeAdj);
     * vMarcados.add(verticeAdj);
     * System.out.println(verticeAdj.getValor());
     * aVisitadas.add(findAresta(vTemp, verticeAdj));
     * }else{
     * if(!aVisitadas.contains(findAresta(vTemp, verticeAdj, vTemp))){
     * aVisitadas.add(findAresta(vTemp, verticeAdj));
     * }
     * }
     * }
     * }
     * numComponentesConexos++;
     * System.out.println(numComponentesConexos + "º Componente Conexo");
     * for (Vertice<TIPO> vertice : this.vertices) {
     * if(!vMarcados.contains(vertice)){
     * current = vertice;
     * fila.add(current);
     * vMarcados.add(current);
     * System.out.println(current.getValor());
     * break;
     * }
     * }
     * }
     * return numComponentesConexos;
     * }
     * 
     * public void GerarMatrizDeAdj(){
     * int[][] matrizAdj = new int[this.vertices.size()][this.vertices.size()];
     * for (int ii=0; ii < vertices.size(); ii++){
     * for (int jj=0; jj < vertices.size(); jj++) {
     * if(findAresta(vertices.get(ii), vertices.get(jj)) != null){
     * matrizAdj[ii][jj] = 1;
     * }else{
     * matrizAdj[ii][jj] = 0;
     * }
     * }
     * }
     * MostrarMatrizAdj(matrizAdj);
     * }
     * 
     * public void MostrarMatrizAdj(int[][] matrizAdj){
     * int count = 0;
     * for (int[] linha : matrizAdj) {
     * count++;
     * for (int coluna : linha) {
     * if(count == this.vertices.size()){
     * System.out.print(coluna + "\n");
     * count=0;
     * }else{
     * System.out.print(coluna + " ");
     * }
     * 
     * }
     * }
     * }
     * 
     * public void buscaEmProfundidade(){
     * 
     * }
     * 
     * public void buscaEmLargura(){
     * ArrayList<Vertice<TIPO>> vMarcados = new ArrayList<>(); // vertices marcados
     * ArrayList<Aresta<TIPO>> aVisitadas = new ArrayList<>(); // arestas visitadas
     * ArrayList<Vertice<TIPO>> fila = new ArrayList<>(); // fila com a ordem para
     * percorrer
     * Vertice<TIPO> current = this.vertices.get(0); // pega o primeiro vertice da
     * lista
     * System.out.println(current.getValor());
     * fila.add(current);
     * vMarcados.add(current);
     * while (fila.size() != 0){
     * Vertice<TIPO> vTemp = fila.remove(0);
     * vTemp.setVerticesAdj();
     * for (Vertice<TIPO> verticeAdj : vTemp.getVerticesAdj()) {
     * if(!vMarcados.contains(verticeAdj)){
     * fila.add(verticeAdj);
     * vMarcados.add(verticeAdj);
     * System.out.println(verticeAdj.getValor());
     * aVisitadas.add(findAresta(vTemp, verticeAdj));
     * }else{
     * if(!aVisitadas.contains(findAresta(vTemp, verticeAdj))){
     * aVisitadas.add(findAresta(vTemp, verticeAdj));
     * }
     * }
     * }
     * }
     * }
     */

    public void GerarMatrizDeAdj() {
        int[][] matrizAdj = new int[this.vertices.size()][this.vertices.size()];
        for (int ii = 0; ii < vertices.size(); ii++) {
            for (int jj = 0; jj < vertices.size(); jj++) {
                if (findAresta(vertices.get(ii), vertices.get(jj)) != null) {
                    matrizAdj[ii][jj] = 1;
                    System.out.println("Opa");
                } else {
                    matrizAdj[ii][jj] = 0;
                }
            }
        }
        MostrarMatrizAdj(matrizAdj);
    }

    public void MostrarMatrizAdj(int[][] matrizAdj) {
        System.out.print("  ");
        for (int i = 0; i < this.vertices.size(); i++) {
            System.out.print("|" + i);
        }
        System.out.println(" |");

        int b = 0;
        for (int[] linha : matrizAdj) {
            System.out.print("|" + b + "|");
            for (int coluna : linha) {
                System.out.print(coluna + " ");
            }
            System.out.print("|\n");
            b++;
        }
    }
}