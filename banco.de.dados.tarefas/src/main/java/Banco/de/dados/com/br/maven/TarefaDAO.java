package Banco.de.dados.com.br.maven;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {
    
    public void salvar(Tarefa tarefa) throws Exception{

        try (var conexao= Conexao.obterConexao();
            var stmt= conexao.prepareStatement("insert into tarefas(titulo, descricao) values (?, ?)")) {
                stmt.setString(1, tarefa.getTitulo());
                stmt.setString(2, tarefa.getDescricao());
                stmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public List<Tarefa> buscarTodos() throws Exception {
        
        List<Tarefa> tarefas= new ArrayList<>();

        try (var conexao= Conexao.obterConexao();
            var stmt= conexao.prepareStatement("select * from tarefas")) {

                try(ResultSet rs= stmt.executeQuery()){
                    while(rs.next()){

                        Tarefa tarefa= new Tarefa(rs.getLong("id"), rs.getString("titulo"), rs.getString("descricao"), rs.getString("dataCriacao"));

                        tarefas.add(tarefa);
                    }
                }
            
            
        } catch (SQLException e) {
            throw new Exception(e);
        }

        return tarefas;
    }

    public Tarefa buscarPorID(Long id) throws Exception {
        
        Tarefa tarefa= null;

        try (var conexao= Conexao.obterConexao();
            var stmt= conexao.prepareStatement("select * from tarefas where id= ?")) {
                stmt.setLong(1, id);

                try(ResultSet rs= stmt.executeQuery()){
                    while(rs.next()){

                        tarefa= new Tarefa(rs.getLong("id"), rs.getString("titulo"), rs.getString("descricao"), rs.getString("dataCriacao"));
                    }
                }
            
            
        } catch (SQLException e) {
            throw new Exception(e);
        }

        return tarefa;
    }

    public void atualizar(Tarefa tarefa) throws Exception{

        try (var conexao= Conexao.obterConexao();
            var stmt= conexao.prepareStatement("update tarefas set titulo= ?, descricao=?, dataCriacao = CURRENT_TIMESTAMP where id= ?")) {
	        	stmt.setString(1, tarefa.getTitulo());
	            stmt.setString(2, tarefa.getDescricao());
                stmt.setLong(3, tarefa.getId());
                stmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public void excluir(Long id) throws Exception{

        try (var conexao= Conexao.obterConexao();
            var stmt= conexao.prepareStatement("delete from tarefas where id= ?")) {
                stmt.setLong(1, id);
                stmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }
}
