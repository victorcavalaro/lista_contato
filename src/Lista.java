import javax.swing.*;
import java.util.ArrayList;

public class Lista {
    private static ArrayList<Contato> contatos = new ArrayList<>();
    
    public static void main(String[] args) {
        int escolha;
        do {
            String[] options = {"Adicionar Contato", "Ver Contatos", "Atualizar Contato", "Deletar Contato", "Sair"};
            escolha = JOptionPane.showOptionDialog(null, "Sistema de Gerenciamento de Contatos", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            
            switch (escolha) {
                case 0:
                    adicionarContato();
                    break;
                case 1:
                    verContatos();
                    break;
                case 2:
                    atualizarContato();
                    break;
                case 3:
                    deletarContato();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Escolha inválida. Por favor, tente novamente.");
            }
        } while (escolha != 4);
    }
    
    public static void adicionarContato() {
        String nome = JOptionPane.showInputDialog("Digite o nome:");
        String numeroTelefone = JOptionPane.showInputDialog("Digite o número de telefone:");
        
        if (nome != null && numeroTelefone != null && !nome.trim().isEmpty() && !numeroTelefone.trim().isEmpty()) {
            Contato contato = new Contato(nome, numeroTelefone);
            contatos.add(contato);
            JOptionPane.showMessageDialog(null, "Contato adicionado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nome ou número de telefone inválido. Operação cancelada.");
        }
    }
    
    public static void verContatos() {
        if (contatos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum contato disponível.");
        } else {
            StringBuilder listaContatos = new StringBuilder();
            for (Contato contato : contatos) {
                listaContatos.append(contato).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaContatos.toString(), "Lista de Contatos", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void atualizarContato() {
        String nome = JOptionPane.showInputDialog("Digite o nome do contato a ser atualizado:");
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                String novoNome = JOptionPane.showInputDialog("Digite o novo nome:");
                String novoNumeroTelefone = JOptionPane.showInputDialog("Digite o novo número de telefone:");
                
                if (novoNome != null && novoNumeroTelefone != null && !novoNome.trim().isEmpty() && !novoNumeroTelefone.trim().isEmpty()) {
                    contato.setNome(novoNome);
                    contato.setNumeroTelefone(novoNumeroTelefone);
                    JOptionPane.showMessageDialog(null, "Contato atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Nome ou número de telefone inválido. Operação cancelada.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Contato não encontrado.");
    }
    
    public static void deletarContato() {
        String nome = JOptionPane.showInputDialog("Digite o nome do contato a ser deletado:");
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatos.remove(contato);
                JOptionPane.showMessageDialog(null, "Contato deletado com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Contato não encontrado.");
    }
}
