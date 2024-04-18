import grafo_direcionado.*;

public class App {
    public static void main(String[] args) throws Exception {
        Grafo g = new Grafo<>(7, 21);
        g.AddVertice("Estudar Grafos", 1, 2);
        g.AddVertice("Estudar Rust", 1, 2);
        g.AddVertice("Aula Rust", 0, 2);
        g.AddVertice("Aula de Natação", 0, 3);
        g.AddVertice("Bolsa", 1, 5);

        // !Este método gera um grafo completo a partir dos vértices inseridos no grafo
        g.gerarGrafoCompleto();

        // !Gera a matriz de adjacencia do grafo
        g.GerarMatrizDeAdj();

        // !Escreve nos arquivos
        var pares = g.retornaParesVerticesMatrizAdj();
        EscreverArquivo arq = new EscreverArquivo("../data_graph/saidaGrafoDirecionado.txt",
                "../data_graph/saidaLabelsVerticesGrafoDirecionado.txt", pares,
                g.retornaVerticesLabels());
        arq.inserir_no_arquivo();
    }
}
