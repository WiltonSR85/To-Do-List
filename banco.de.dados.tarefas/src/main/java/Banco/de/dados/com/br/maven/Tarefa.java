package Banco.de.dados.com.br.maven;

public class Tarefa {

    private Long id;
    private String titulo;
    private String descricao;
    private String data;

    public Tarefa( String titulo, String descricao){
        this.id= null;
        this.titulo= titulo;
        this.descricao= descricao;
        this.data= null;
    }
    
    public Tarefa( Long id, String titulo, String descricao){
        this.id= id;
        this.titulo= titulo;
        this.descricao= descricao;
        this.data= null;
    }
    public Tarefa(String titulo, String descricao, String data){
    	this.id= null;
        this.titulo= titulo;
        this.descricao= descricao;
        this.data= data;
    }

    public Tarefa( Long id, String titulo, String descricao, String data){
    	this.id= id;
        this.titulo= titulo;
        this.descricao= descricao;
        this.data= data;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

    
}
