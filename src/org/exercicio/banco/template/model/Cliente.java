package org.exercicio.banco.template.model;

import java.util.ArrayList;
import java.util.Objects;

/**
*
* Nome: Cidyclay Junyor
* Curso: Informática Para Internet
* Matrícula:20222INFIG0060
* 
*/
public class Cliente {
	
    private String nome;
    private String cpf;
    private ArrayList<ContaBancaria> contas;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.contas = new ArrayList<>();
    }

    /**
     * O mehtodo recebe como argumento uma contabancaria a ser adicionada 
     * ao arraylist de contas do cliente. Antes de adicionar, verifique se a 
     * conta jah existe no array, caso jah exista a msg deve ser exibida no 
     * console: "A conta jah estah associada a este cliente.". Caso contrahrio,
     * imprima no console: "Conta adicionada com sucesso!". Utilize 
     * System.out.print() para realizar as impressoes.
     * @param c
     */
    public void adicionarConta(ContaBancaria c) {
    	if (contas.contains(c)) {
            System.out.print("A conta jah estah associada a este cliente.");
        } else {
            contas.add(c);
            System.out.print("Conta adicionada com sucesso!");
        }

    }

    
    /**
     * O mehtodo recebe como argumento uma contabancaria a ser removida 
     * do arraylist de contas do cliente. Antes de remover, verifique se a 
     * conta existe no array, caso o arraylist contenha a conta passada,
     * a msg deve ser exibida no console: "Conta removida com sucesso!". 
     * Caso contrahrio, imprima no console: "A conta nao esta associada a este cliente.".
     * Utilize System.out.print() para realizar as impressoes.
     * @param c
     */
    public void removerConta(ContaBancaria c) {
        if (contas.contains(c)) {
            contas.remove(c);
            System.out.print("Conta removida com sucesso!");
        } else {
            System.out.print("A conta nao esta associada a este cliente.");
        }


    }

    /**
     * Mehtodo recebe como argumento o numero da conta que deve ser 
     * procurado na lista de contas, havendo ocorrehncia de elemento
     * com o mesmo nuhmero de conta, a msg "Conta encontrada!" deve
     * ser impressa no console e logo apohs a conta deve ser retornada.
     * Nao havendo ocorrehncia, a msg "Conta nao encontrada." deve ser
     * impressa no console e o retorno deve ser null.   
     * @param numero
     * @return
     */
    public ContaBancaria localizarContaNumero(int numero) {
        ContaBancaria temp = new ContaBancaria(numero, 0);
            if(contas.contains(temp)) {
                int index = contas.indexOf(temp);
                temp = contas.get(index);
                System.out.print("Conta encontrada!");
                return temp;
            }else {
                System.out.print("Conta nao encontrada.");
                return null;
            }
      
    }

    
    /**
     * Mehtodo recebe como argumento o objeto contabancaria que deve ser 
     * procurado na lista de contas, havendo ocorrehncia de elemento
     * com no arraylist, a msg "Conta encontrada!" deve
     * ser impressa no console e logo apohs o valor booleano true deve ser retornado.
     * Nao havendo ocorrehncia, a msg "Conta nao encontrada." deve ser
     * impressa no console e o retorno deve ser false.   
     * @param numero
     * @return
     */
    public boolean localizarConta(ContaBancaria c) {
        if (contas.contains(c)) {
            System.out.print("Conta encontrada!");
            return true;
        } else {
            System.out.print("Conta nao encontrada.");
            return false;
        }

    }

    /**
     * O mehtodo deve calcular o balanco total dos valores das contas
     * presentes na listas. Apohs somar o valor de saldo de todas
     * contas, o saldo total deve ser impresso por meio da msg no
     * console: "Balanco entre contas: RS", concatenado ao saldo total.
     * O valor tambehm deve ser retornado, logo apohs a impressao.
     * @return
     */
    public double balancoEntreContas() {
        double saldoTotal =0;
        for(ContaBancaria temp : contas){
            saldoTotal += temp.getSaldo();
        }
        System.out.print("Balanco entre contas: RS" + saldoTotal);
        return saldoTotal;

    }
    
    public ArrayList<ContaBancaria> getContas() {
		return contas;
	}
    
    public void setContas(ArrayList<ContaBancaria> contas) {
		this.contas = contas;
	}

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contas, cpf, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(contas, other.contas) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(nome, other.nome);
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}   

   
    // getters e setters omitidos
    
}

