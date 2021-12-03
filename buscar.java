package lista.exe.trabalho_estrutura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class buscar {

	public static void main(String[] args) {
		String path = "clientes_trabalho_final.csv"; 						// Caminho do arquivo
		List<Tabela> list = new ArrayList<Tabela>(); 						// Instanciancia uma lista de objetos

		try (BufferedReader br = new BufferedReader(new FileReader(path))) { // Gerencia a memoria de leitura

			String line = br.readLine(); 									// Ler linha a linha com execao do cabecalho
			line = br.readLine(); 											// line recebe o conteudo csv
			while (line != null) { 											// Verificar se ja chegou no final

				String[] vect = line.split(";"); 							// funcao split irar recortar onde achar o conteudo das aspas no vetor.
				String nome_cliente = vect[0]; 								// Receber os vetores nas posicoes
				String data_nascimento = vect[1]; 							// Receber os vetores nas posicoes
				Integer prioridade = Integer.parseInt(vect[2]); 			// Receber os vetores nas posicoes

				Tabela prod = new Tabela(nome_cliente, data_nascimento, prioridade);// Criar uma variavel prod passandos os 3 argumentos
				list.add(prod); 											// Inserir na lista prod

				line = br.readLine(); 										// Ler a proxima linha
			}
			/*
			 * System.out.println("Tabela:"); 								// Imprimir na tela  
			 * for (Tabela p : list) {
			 * System.out.println(p); 
			 * }
			 */
		} catch (IOException e) { 											// Se dar um erro ira apressentar na tela.
			System.out.println("Error: " + e.getMessage());
		}
//-------------------------------------------------------------------------------------------------------------------------------------------------		
		List<Tabela> listB = new ArrayList<>(list); 						// Fazendo uma copia da list
		Queue<Tabela> listP = new LinkedList<>(); 							// Instanciando uma fila com prioridade
		LinkQueue listN = new LinkQueue(); 									// Instanciando uma fila normal

		// Queue<Tabela> listN = new LinkedList<>(); 						// Tetativa de instanciar uma fila normal
		// Queue<Tabela> listP = new PriorityQueue<Tabela>();				 // Tetativa de instanciar uma fila com prioridade

//-------------------------------------------------------------------------------------------------------------------------------------------------	
		// Testando
		System.out.println("Agora vai!"); 										// Verificando Impressao
		System.out.println("A lista (list) esta vazia? " + list.isEmpty()); 	// verificando se a list esta vazia.
		System.out.println("A lista (listB) esta vazia? " + listB.isEmpty());	// verificando se a listB esta vazia.
		System.out.println("A lista (listN) esta vazia? " + listN.isEmpty()); 	// verificando se a listN esta vazia.
		System.out.println("A lista (listP) esta vazia? " + listP.isEmpty()); 	// verificando se a listP esta vazia.
		System.out.println("O tamanho da list e :" + list.size()); 				// verificando o tamanho de list
		System.out.println("O tamanho da listB e :" + listB.size()); 			// verificando o tamanho de listB
//-------------------------------------------------------------------------------------------------------------------------------------------------	
		// Fila com prioridade
		Collections.sort(list); 												// Organiza por prioridade
		for (int i = list.size() - 1; i >= 0; i--) { 							// ListP (Fila -Queue P ) recebe list (lista)
			listP.add(list.remove(i));
		}

		System.out.println("Lista Queue Prioridade:"); 							// Imprimi na tela a fila por prioridade
		for (Tabela P : listP) {
			System.out.println(P);
		}
		System.out.println("A lista (listN) esta vazia? " + listN.isEmpty()); 	// verificando se a listP esta vazia.
		System.out.println("O tamanho da listP e :" + listP.size()); 			// verificando o tamanho da list1
		System.out.println("A lista (listP) esta vazia? " + listP.isEmpty()); 	// verificando se a listP esta vazia.
//-------------------------------------------------------------------------------------------------------------------------------------------------			
		// Fila Normal
		for (int i = listB.size() - 1; i >= 0; i--) {							 // ListN (Fila -Queue N ) recebe list (lista)
			listN.insert(listB.remove(i));
		}

		// Fura Fila
		listN.furafila(new Tabela("Primeiro", "2016-09-25", 5)); 				// Chama o metodo Fura fila

		// Verificacao dos dados
		System.out.println("Lista Normal"); 									// Imprimi na tela a fila normal
		listN.displayQueue(); 													// Imprimi a fila normal
	}
}
