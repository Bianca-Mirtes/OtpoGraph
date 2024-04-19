package grafo_direcionado;

import java.io.*;

public class EscreverArquivo {
    private String fileGrafo;
    private Grafo Grafo;

    public EscreverArquivo(String file, Grafo grafo) {
        this.fileGrafo = file;
        this.Grafo = grafo;
    }

    public void inserir_no_arquivo() throws Exception {
        // Fluxo de saida de um arquivo
        OutputStream os = new FileOutputStream(this.fileGrafo); // nome do arquivo que será escrito
        Writer wr = new OutputStreamWriter(os); // criação de um escritor
        BufferedWriter br = new BufferedWriter(wr); // adiciono a um escritor de buffer

        Grafo.GerarMatrizDeAdj();
        var mat = this.Grafo.getMatrizAdj();
        for (int i = 0; i < this.Grafo.getQntdVertices(); i++) {
            for (int j = 0; j < this.Grafo.getQntdVertices(); j++) { // é uma matriz NxN
                if (mat[i][j] == 1) {
                    br.write(i + "," + j + "," + this.Grafo.findAresta(this.Grafo.getVerticePorIndex(i),
                            this.Grafo.getVerticePorIndex(j)).getPeso() + ",'"
                            + this.Grafo.getVerticePorIndex(i).getValor()
                            + "','" + this.Grafo.getVerticePorIndex(j).getValor() + "',"
                            + this.Grafo.getVerticePorIndex(i).geTipoAtv() + ","
                            + this.Grafo.getVerticePorIndex(j).geTipoAtv());
                    br.newLine();
                }
            }
        }

        br.close();
    }
}
