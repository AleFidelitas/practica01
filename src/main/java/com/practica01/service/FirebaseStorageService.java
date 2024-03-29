
package com.practica01.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {


    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "practica01-bcf85.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "practica01";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "practica01-bcf85-firebase-adminsdk-krmi4-885b9fb0c2.json";
}
  

