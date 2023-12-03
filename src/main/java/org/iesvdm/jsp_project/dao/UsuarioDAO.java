package org.iesvdm.jsp_project.dao;

import org.iesvdm.jsp_project.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioDAO {

    public void create(Usuario usuario);

    public List<Usuario> getAll();
    public Optional<Usuario> find(String nombre);

    public void update(Usuario usuario);

    public void delete(int id);
}
