import grafo_direcionado.*;

public class App {
    public static void main(String[] args) throws Exception {
        Grafo g = new Grafo<>(7, 21);
        var v = g.AddVertice("Estudar Grafos", 1, 2);
        var f = g.AddVertice("Estudar Rust", 1, 2);
        g.AddAresta(v, f);
        g.AddAresta(f, v);
        var j = g.AddVertice("Aula Rust", 0, 2);
        g.AddAresta(v, j);
        g.AddAresta(j, v);
        g.AddAresta(f, j);
        g.AddAresta(j, f);
        g.GerarMatrizDeAdj();
    }
}
