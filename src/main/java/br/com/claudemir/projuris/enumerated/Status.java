package br.com.claudemir.projuris.enumerated;

public enum Status {
	
	ABERTO("A"), FECHADO("F"), AGUARDANDO_PECA("P"), CANCELADO("C");

    private String code;

    private Status(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
