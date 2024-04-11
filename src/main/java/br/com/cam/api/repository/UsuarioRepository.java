package br.com.cam.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cam.api.model.Usuario;;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>  {
    @Query("select u from Usuario u where u.email = ?1")
    Usuario findByLogin(String email);
}
