package com.egg.biblioteca.servicios;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.egg.biblioteca.entidades.Imagen;
import com.egg.biblioteca.repositorios.ImagenRepositorio;

import jakarta.transaction.Transactional;

@Service
public class ImagenServicio {
    
    @Autowired
    private ImagenRepositorio imagenRepositorio;

    @Transactional
    public Imagen guardar(MultipartFile archivo) throws Exception{
        if(archivo != null) {
            try {                
                Imagen imagen = new Imagen();
    
                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getOriginalFilename());
                imagen.setContenido(archivo.getBytes());
                return imagenRepositorio.save(imagen);
            } catch (IOException e) {
                System.err.println("Error al guardar la imagen" + e.getMessage());
                return null;
            }
        } else {
            System.err.println("Archivo de imagen nulo o vacío");
            return null;
        }
    }

    @Transactional
    public Imagen actualizar(MultipartFile archivo, UUID id) {
        if(archivo != null) {
            try {                
                Imagen imagen = new Imagen();
                if(id != null) {
                    if(getOne(id) != null) {
                        imagen = getOne(id);
                    }
                }
                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getOriginalFilename());
                imagen.setContenido(archivo.getBytes());
                return imagenRepositorio.save(imagen);
            } catch (IOException e) {
                System.err.println("Error al actualizar la imagen" + e.getMessage());
                return null;
            }
        } else {
            System.err.println("Archivo de imagen nulo o vacío");
            return null;
        }
    }

    public Imagen getOne(UUID id) {
        try {
            return imagenRepositorio.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
