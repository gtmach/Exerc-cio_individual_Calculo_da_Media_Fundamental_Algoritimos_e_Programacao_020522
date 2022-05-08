import java.util.Scanner; //importa o scanner para receber entradas

public class mediafundamental { //inicia a classe
    public static void main(String[] args) { //inicia o metodo main
        System.out.println("Digite o codigo do aluno e em seguida suas tres notas, separados por traco."); //exibe instruicoes em texto
        System.out.println("Exemplo: xxxx-n1-n2-n3"); //exibe instruicoes em texto
        System.out.println("digite 0 para encerrar"); //exibe instruicoes em texto
        System.out.println("-------------------------"); //exibe texto
        Scanner sc = new Scanner(System.in); //inicia um scanner
        String buffer = "",status ="",notasAlunos = ""; //inicia strings
        do { //inicia o loop do-while
            notasAlunos = sc.nextLine(); //adiciona o valor digitado a variavel
            String[] parts = notasAlunos.split("-"); //divide a string em cada - e adiciona cada pedaço a um array

            String aluno = parts[0]; //define o primeiro membro do array como aluno
            if (aluno.equals("0")) break; //se aluno for 0, encerra o loop e exibe as notas calculadas anteriormente
            else if (parts.length != 4) { //verifica se existe numero diferente de 4 elementos no array. caso ocorra, dados foram digitados incorretamente
                System.err.println("Notas digitadas fora de formato, tente novamente"); //exibe mensagem em formato de erro
                continue; //retorna ao inicio do loop sem completar o contador, para digitar novamente os dados, caso exita quantidade diferente de 4 menbros no array
            }

            String nota1 = parts[1]; //define o segundo membro do array do array como a nota 1
            nota1 = nota1.replace(",","."); //troca virgulas por ponto, caso o usuario digite um ou outro como decimal, evitando exeption
            double nota1Double = Double.parseDouble(nota1); //converte a nota para double, já que podem existir notas decimais (ex 4,5)

            String nota2 = parts[2]; //define o terceiro membro do array como a nota 2
            nota1 = nota2.replace(",","."); //troca virgulas por ponto, caso o usuario digite um ou outro como decimal, evitando exeption
            double nota2Double = Double.parseDouble(nota2); //converte a nota para double, já que podem existir notas decimais (ex 4,5)

            String nota3 = parts[3]; //define o quarto membro do array como a nota 3
            nota1 = nota3.replace(",","."); //troca virgulas por ponto, caso o usuario digite um ou outro como decimal, evitando exeption
            double nota3Double = Double.parseDouble(nota3); //converte a nota para double, já que podem existir notas decimais (ex 4,5)

            double media = (nota1Double + nota2Double + nota3Double)/3; //calcula a media e atribui ao valor media

            if ((nota1Double > 10 || nota1Double < 0) || (nota2Double > 10 || nota2Double < 0) && (nota3Double > 10 || nota3Double < 0)) status ="NOTA INVALIDA"; //verifica se alguma das notas é maior que 10 e menor que zero, sendo invalida (fora do intervalo 0-10)
            else if (media >= 8 && media <= 10) status = "APROVADO"; //verifica se a media é maior ou igual a 8 e menor que 10, atribuindo o status de aprovado
            else if (media >=6 && media < 8) status = "RECUPERACAO"; //verifica se a nota é maior ou igual a 6 e menor que 8, atribuindo status de recuperacao
            else if (media <6 && media >= 0) status = "REPROVADO"; //verifica se a nota é menor que 6 e maior ou igual a zero, atribuindo status de recuperacao
            else status = "NOTA INVALIDA"; //caso ainda fique fora dos valores previamente definidos, a nota sera invalida.

            buffer += aluno + " - Media: " + (String.format("%.2f",media)) + ", Status: " + status + "\n"; // resultados sao adicionados na string buffer, pulando linhas, para que sejam exibidos em conjunto ao finalizar o programa
        } while (true); //loop infinito, so sendo terminado quando verificado presenca do 0 no codigo do aluno

        System.out.println(buffer); //mostra todos os resultados armazenados
    }
}