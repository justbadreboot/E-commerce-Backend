package com.microservice.order.repository;

import com.microservice.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {


}



/*
en caso de pretender usa json ignore en la obtencion de resultados
@Override
    public Usuarios guardarUsuario(Usuarios usuarios, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuarios usuarioLocal = usuarioRepository.findByUsername(usuarios.getUsername());
        if (usuarioLocal !=null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }else {
            for (UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuarios.getUsuarioRols().addAll(usuarioRoles);
            usuarioLocal=usuarioRepository.save(usuarios);
        }
        return usuarioLocal;
    }
 */