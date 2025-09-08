package com.uniminuto.clinica.controller;

import com.uniminuto.clinica.entity.Paciente;
import com.uniminuto.clinica.service.PacienteService;
import java.util.List;
import java.util.Scanner;

public class ApiController {
    public static void main(String[] args) {
        PacienteService service = new PacienteService();
        Scanner sc = new Scanner(System.in);

        // Listar pacientes
    for (Paciente p : service.listarPacientes()) {
    System.out.println(p);
}

        // Buscar paciente por documento
        System.out.print("\n Ingrese un documento para buscar: ");
        String doc = sc.nextLine();
        String nombre = service.buscarNombrePorDocumento(doc);
        System.out.println("Resultado: " + nombre);
    }
}
