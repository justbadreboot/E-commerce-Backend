package com.microservice.order.repository;

import com.microservice.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByIdClient(Integer id);

    List<Order> findByDeliveryStateId(Integer id);

    List<Order> findByOrderStateId(Integer id);

    @Query(value = "SELECT SUM(order_details.amount) FROM krugorders, order_details WHERE (krugorders.id = order_details.order_id) AND krugorders.date > DATE_SUB(CURDATE(),INTERVAL 1 DAY)", nativeQuery=true)
    Integer productsSoldOnDay();

}



/*
//SELECT SUM(order_details.amount) FROM krugorders, order_details WHERE (krugorders.id = order_details.order_id) AND krugorders.date LIKE '2023-02-11%';
    //@Query(value="select * from productos a where a.nombre_generico LIKE :name% or a.nombre_comercial LIKE :name%", nativeQuery=true)
@Query(value="select * from productos a where a.nombre_generico LIKE :name% or a.nombre_comercial LIKE :name%", nativeQuery=true)
List<Productos> getProductosFilterName(String name);
@Query(value="select * from ventas a where a.fecha_venta between :value1 AND :value2", nativeQuery=true)
@Query(value="select * from ventas a where (a.fecha_venta between :value1 AND :value2) AND WHERE (a.surcursal_id :sucursalId )", nativeQuery=true)

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