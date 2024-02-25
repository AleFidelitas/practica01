package com.practica01.controller;

import com.practica01.domain.Arbol;
import com.practica01.service.ArbolService;
import com.practica01.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("/arbol")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = arbolService.getArbol(false);
        model.addAttribute("arboles", lista);
        model.addAttribute("totalArboles", lista.size());
        return "/arbol/listado";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageServiceImpl;

    @PostMapping("/guardar")
    public String guardar(Arbol arbol,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            //se debe subir imagen
            arbolService.save(arbol);
            String rutaImagen = firebaseStorageServiceImpl.cargaImagen(imagenFile, "arbol", arbol.getIdArbol());
            arbol.setRutaImagen(rutaImagen);
        }
        arbolService.save(arbol);

//        logger.trace("Este es un mensaje de TRACE");
//        logger.debug("Este es un mensaje de DEBUG");
//        logger.info("Este es un mensaje de INFO");
//        logger.warn("Este es un mensaje de WARN");
//        logger.error("Este es un mensaje de ERROR");

        return "redirect:/arbol/listado";
    }

    @GetMapping("/modificar/{idArbol}")
    public String modifica(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica";
    }

    @GetMapping("/eliminar/{idArbol}")
    public String elimina(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }

}
