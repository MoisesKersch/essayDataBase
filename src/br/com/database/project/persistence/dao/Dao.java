package br.com.database.project.persistence.dao;

import java.io.Serializable;
import java.util.List;


public interface Dao<T> {

	public T salva(T obj) throws Exception;

	public T atualiza(T obj) throws Exception;

	public T carregaPorId(Serializable id) throws Exception;

	public boolean exclui(T obj) throws Exception;

	public List<T> lista() throws Exception;

	public List<T> lista(String ordem) throws Exception;

	public String getUniqueId();
}