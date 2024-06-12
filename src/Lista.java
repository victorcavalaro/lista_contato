import javax.swing.*;
import java.util.ArrayList;

public class Lista {
    private static ArrayList<Contato> contatos = new ArrayList<>();
    
    public static void main(String[] args) {
        int escolha;
        do {
            String[] options = {"Incluir Contato", "Ver Contatos", "Atualizar Contato", "Deletar Contato", "Sair"};
            escolha = JOptionPane.showOptionDialog(null, "Sistema de Gerenciamento de Contatos", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            
            switch (escolha) {
                case 0:
                    incluirContato();
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
    
    public static void incluirContato() {
        String[] options = {"Contato Pessoal", "Contato Comercial"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha o tipo de contato a ser adicionado", "Incluir Contato",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (escolha) {
            case 0:
                adicionarContatoPessoal();
                break;
            case 1:
                adicionarContatoComercial();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Escolha inválida. Operação cancelada.");
        }
    }
    
    public static void adicionarContatoPessoal() {
        String nome = JOptionPane.showInputDialog("Digite o nome:");
        String numeroTelefone = JOptionPane.showInputDialog("Digite o número de telefone:");
        String instagram = JOptionPane.showInputDialog("Digite o Instagram:");
        
        if (nome != null && numeroTelefone != null && instagram != null && !nome.trim().isEmpty() && !numeroTelefone.trim().isEmpty() && !instagram.trim().isEmpty()) {
            ContatoPessoal contato = new ContatoPessoal(nome, numeroTelefone, instagram);
            contatos.add(contato);
            JOptionPane.showMessageDialog(null, "Contato pessoal adicionado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Dados inválidos. Operação cancelada.");
        }
    }
    
    public static void adicionarContatoComercial() {
        String nome = JOptionPane.showInputDialog("Digite o nome:");
        String numeroTelefone = JOptionPane.showInputDialog("Digite o número de telefone:");
        String linkedin = JOptionPane.showInputDialog("Digite o LinkedIn:");
        
        if (nome != null && numeroTelefone != null && linkedin != null && !nome.trim().isEmpty() && !numeroTelefone.trim().isEmpty() && !linkedin.trim().isEmpty()) {
            ContatoComercial contato = new ContatoComercial(nome, numeroTelefone, linkedin);
            contatos.add(contato);
            JOptionPane.showMessageDialog(null, "Contato comercial adicionado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Dados inválidos. Operação cancelada.");
        }
    }
    
    public static void verContatos() {
        String[] options = {"Contatos Pessoais", "Contatos Comerciais"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha o tipo de contato a ser visualizado", "Ver Contatos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        
        StringBuilder listaContatos = new StringBuilder();
        switch (escolha) {
            case 0:
                for (Contato contato : contatos) {
                    if (contato instanceof ContatoPessoal) {
                        listaContatos.append(contato).append("\n");
                    }
                }
                JOptionPane.showMessageDialog(null, listaContatos.length() == 0 ? "Nenhum contato pessoal disponível." : listaContatos.toString(), "Contatos Pessoais", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
                for (Contato contato : contatos) {
                    if (contato instanceof ContatoComercial) {
                        listaContatos.append(contato).append("\n");
                    }
                }
                JOptionPane.showMessageDialog(null, listaContatos.length() == 0 ? "Nenhum contato comercial disponível." : listaContatos.toString(), "Contatos Comerciais", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Escolha inválida. Operação cancelada.");
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
                    
                    if (contato instanceof ContatoPessoal) {
                        String novoInstagram = JOptionPane.showInputDialog("Digite o novo Instagram:");
                        if (novoInstagram != null && !novoInstagram.trim().isEmpty()) {
                            ((ContatoPessoal) contato).setInstagram(novoInstagram);
                        } else {
                            JOptionPane.showMessageDialog(null, "Instagram inválido. Operação cancelada.");
                            return;
                        }
                    } else if (contato instanceof ContatoComercial) {
                        String novoLinkedin = JOptionPane.showInputDialog("Digite o novo LinkedIn:");
                        if (novoLinkedin != null && !novoLinkedin.trim().isEmpty()) {
                            ((ContatoComercial) contato).setLinkedin(novoLinkedin);
                        } else {
                            JOptionPane.showMessageDialog(null, "LinkedIn inválido. Operação cancelada.");
                            return;
                        }
                    }
                    
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
