package pe.edu.upc.aaw.demo1_202302_si63.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.demo1_202302_si63.dtos.DessertDTO;
import pe.edu.upc.aaw.demo1_202302_si63.entities.Dessert;
import pe.edu.upc.aaw.demo1_202302_si63.serviceinterfaces.IDessertService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dulces")
public class DessertController {
    @Autowired
    private IDessertService dS;
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void registrar(@RequestBody DessertDTO dto) {
        ModelMapper m = new ModelMapper();
        Dessert d = m.map(dto, Dessert.class);
        dS.insert(d);
    }

    @PutMapping
    public void modificar(@RequestBody DessertDTO dto) {
        ModelMapper m = new ModelMapper();
        Dessert d = m.map(dto, Dessert.class);
        dS.insert(d);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        dS.delete(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public DessertDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        DessertDTO dto=m.map(dS.listarId(id),DessertDTO.class);
        return dto;
    }

    @GetMapping
    public List<DessertDTO> listar() {
        return dS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,DessertDTO.class);
        }).collect(Collectors.toList());

    }
    @PostMapping("/buscar")
    public List<DessertDTO> buscar(@RequestBody LocalDate fecha) {
        return dS.findByDueDateDessert(fecha).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,DessertDTO.class);
        }).collect(Collectors.toList());
    }

}
