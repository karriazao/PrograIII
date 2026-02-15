/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Empresa;
import Modelo.EmpresaDAO;

/**
 *
 * @author Soporte
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Empresa empresa = new Empresa("Universidad del Valle");
        System.out.println(empresa.toString());
        EmpresaDAO empresadao = new EmpresaDAO();
        empresa.setCodigoEmpresa(2);
        //empresadao.insert(empresa);
        //empresadao.update(empresa);
        empresadao.delete(empresa);
        
        empresa=empresadao.query(empresa);
        System.out.println(empresa.toString());
    }
    
}
