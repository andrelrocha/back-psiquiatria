package jr.acens.api.domain;

public enum Doencas {
    ANSIEDADE("Ansiedade"),
    DEPRESSAO("Transtorno Depressivo"),
    BIPOLAR("Transtorno Afetivo Bipolar"),
    PSICOSE("Psicose"),
    EPILEPSIA("Epilepsia"),
    ALCOOL_DROGAS("Álcool e Outras Drogas");

    private String text;

    Doencas(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
