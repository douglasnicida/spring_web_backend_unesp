package br.com.cam.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cam.api.model.Camera;

@Repository
public interface CameraRepository extends CrudRepository<Camera, Long> {
    
}
