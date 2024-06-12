public class ContatoPessoal extends Contato {
    private String instagram;
    
    public ContatoPessoal(String nome, String numeroTelefone, String instagram) {
        super(nome, numeroTelefone);
        this.instagram = instagram;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    @Override
    public String toString() {
        return super.toString() + ", Instagram: " + instagram;
    }
}
