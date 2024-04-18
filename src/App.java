import grafo_direcionado.*;

public class App {
    public static void main(String[] args) throws Exception {
        Grafo g = new Grafo<>(7, 21);
        var v = g.AddVertice("Estudar Grafos", 1, 2);
        var f = g.AddVertice("Estudar Rust", 1, 2);
        g.AddAresta(v, f, 10);
        g.AddAresta(f, v, 10);
        var j = g.AddVertice("Aula Rust", 0, 2);
        g.AddAresta(v, j, 2);
        g.AddAresta(j, v, 2);
        g.AddAresta(f, j, 2);
        g.AddAresta(j, f, 2);
        g.GerarMatrizDeAdj();
    }
}
