package grafo_direcionado;

import java.io.*;
import java.util.ArrayList;

public class EscreverArquivo {
    private String fileVertices;
    private String fileLabels;
    private ArrayList<Integer> verticesConectados;
    private ArrayList<String> verticesLabels;

    public EscreverArquivo(String file, String file2, ArrayList<Integer> verticesConectados,
            ArrayList<String> verticesLabels) {
        this.fileVertices = file;
        this.fileLabels = file2;
        this.verticesConectados = verticesConectados;
        this.verticesLabels = verticesLabels;
    }

    public void inserir_no_arquivo() throws Exception {
        // Fluxo de saida de um arquivo
        OutputStream os = new FileOutputStream(this.fileVertices); // nome do arquivo que será escrito
        Writer wr = new OutputStreamWriter(os); // criação de um escritor
        BufferedWriter br = new BufferedWriter(wr); // adiciono a um escritor de buffer

        for (int i = 0; i < this.verticesConectados.size(); i += 2) {
            br.write(this.verticesConectados.get(i) + " " + this.verticesConectados.get(i + 1));
            br.newLine();
        }
        br.close();

        OutputStream os2 = new FileOutputStream(this.fileLabels); // nome do arquivo que será escrito
        Writer wr2 = new OutputStreamWriter(os2); // criação de um escritor
        BufferedWriter br2 = new BufferedWriter(wr2); // adiciono a um escritor de buffer

        for (int i = 0; i < this.verticesLabels.size(); i++) {
            br2.write(this.verticesLabels.get(i));
            br2.newLine();
        }
        br2.close();
    }
}
