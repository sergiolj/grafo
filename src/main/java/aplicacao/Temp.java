package aplicacao;
import java.util.Scanner;

public class Temp {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String[] vetor = {"azul","amarelo","verde"};
        String x;

        System.out.println("Busque por um nome: ");
        x=sc.next();

        buscar(vetor, x);

    }

    public static void buscar(String[] vetor, String nome){
        int y=0;

        for(int x=0; x<vetor.length;x++){
            if(vetor[x].equals(nome)){
                System.out.println("O nome buscado está na posição "+ x);
                y=1;
            }

        }

        if (y==0) {
            System.out.println("O nome buscado não está presente ");
        }
    }
}