import java.util.Scanner;

public class processo_seletivo {
    
    static class Aluno {
        String nome;
        Double[] notas;
        Double frequencia;
        Double mediaAluno;

        public Aluno(String nome, Double[] notas, Double frequencia){
            this.nome = nome;
            this.notas = notas;
            this.frequencia = frequencia;
        }
    }
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
                       
        System.out.println("///Painel do Professor///");

        System.out.print("\nDigite a quantidade de alunos: ");

        int quantAlunos = scanner.nextInt();

        Aluno[] alunos = new Aluno[quantAlunos];

        //Preenchimento dados dos alunos
        for(int i = 0; i < quantAlunos; i++){
            
            System.out.print("\nDigite o nome do aluno: ");
                      
            String nome = scanner.next();

            Double[] notas = new Double[5];

            for(int j = 0; j < 5; j++){
                
                System.out.print("Digite a nota da disciplina " + (j + 1) + " (0 a 10): ");

                notas[j] = scanner.nextDouble();
            }

            System.out.print("Digite a frequencia do aluno (0 a 100): ");
            
            Double frequencia = scanner.nextDouble();

            alunos[i] = new Aluno(nome, notas, frequencia);
        }

        //Calcula media dos alunos
        for(int i = 0; i < quantAlunos; i++){

            Double mediaAluno = 0.0;
            
            for(int j = 0; j < 5; j++){

                mediaAluno = mediaAluno + alunos[i].notas[j];
            }

            mediaAluno = mediaAluno / 5;

            alunos[i].mediaAluno = mediaAluno;

        }

        Double[] mediaDisciplina = {0.0, 0.0, 0.0, 0.0, 0.0};

        //Calcular media da turma por disciplina
        for(int i = 0; i < 5; i++){

            for(int j = 0; j < quantAlunos; j++){

                mediaDisciplina[i] = mediaDisciplina[i] + alunos[j].notas[i];
            }

            mediaDisciplina[i] = mediaDisciplina[i] / quantAlunos;
        }

        Double mediaTurma = 0.0;

        //Calcular media geral da turma
        for(int i = 0; i < quantAlunos; i++){

            mediaTurma = mediaTurma + alunos[i].mediaAluno;
        }

        mediaTurma = mediaTurma / quantAlunos;
        
        //Imprimir Resultados
        System.out.println("\n///Resultados///");

        //Imprime alunos
        for(int i = 0; i < quantAlunos; i++){
            
            System.out.print("\n");
            System.out.print("Nome Aluno: " + alunos[i].nome);
            System.out.printf(" Media: %.2f", alunos[i].mediaAluno);
            System.out.printf(" Frequencia: %.2f", alunos[i].frequencia);
            System.out.print("%");
        }
        
        //Imprime media por disciplina
        System.out.println("\n\n///Nota Media por Disciplina///\n");
        for(int i = 0; i < 5; i++){
            
            System.out.print("Media Disciplina " + (i + 1) + ": ");
            System.out.printf("%.2f", mediaDisciplina[i]);
            System.out.print("\n");
        }

        //Imprime alunos acima da media
        System.out.println("\n///Alunos Acima da Media///");

        System.out.print("\n");

        for(int i = 0; i < quantAlunos; i++){

            if(alunos[i].mediaAluno > mediaTurma){
                
                System.out.println(alunos[i].nome);
            }
        }

        //Imprime alunos com baixa frequencia
        System.out.println("\n///Alunos Frequencia < 75%///");

        System.out.print("\n");
        
        for(int i = 0; i < quantAlunos; i++){

            if(alunos[i].frequencia < 75){
                
                System.out.println(alunos[i].nome);
            }
        }

        System.out.print("\n");
        scanner.close();
    }
}
