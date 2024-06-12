public class ContatoComercial extends Contato {
    private String linkedin;
    
    public ContatoComercial(String nome, String numeroTelefone, String linkedin) {
        super(nome, numeroTelefone);
        this.linkedin = linkedin;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    @Override
    public String toString() {
        return super.toString() + ", LinkedIn: " + linkedin;
    }
}
