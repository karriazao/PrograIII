/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Soporte
 * Created: 10/02/2026
 */
CREATE DATABASE UMG;
USE UMG;

CREATE TABLE Maestros (
    mae_codigo INT PRIMARY KEY AUTO_INCREMENT,
    mae_nombre VARCHAR(100) NOT NULL,
    mae_direccion VARCHAR(150),
    mae_estatus VARCHAR(20)
);

CREATE TABLE Alumnos (
    alu_codigo INT PRIMARY KEY AUTO_INCREMENT,
    alu_nombre VARCHAR(100) NOT NULL,
    alu_direccion VARCHAR(150),
    alu_estatus VARCHAR(20)
);

CREATE TABLE Carreras (
    car_codigo INT PRIMARY KEY AUTO_INCREMENT,
    car_nombre VARCHAR(100) NOT NULL,
    car_estatus VARCHAR(20)
);

CREATE TABLE Cursos (
    cur_codigo INT PRIMARY KEY AUTO_INCREMENT,
    cur_nombre VARCHAR(100) NOT NULL,
    cur_estatus VARCHAR(20)
);

CREATE TABLE Jornadas (
    jor_codigo INT PRIMARY KEY AUTO_INCREMENT,
    jor_nombre VARCHAR(100) NOT NULL,
);

CREATE TABLE Asignacion_Cursos_Alumnos (
    car_codigo INT,
    cur_codigo INT,
    mae_codigo INT,
    alu_codigo INT,
    aca_nota DECIMAL(5,2),

    PRIMARY KEY (car_codigo, cur_codigo, mae_codigo, alu_codigo),

    FOREIGN KEY (car_codigo) REFERENCES Carreras(car_codigo),
    FOREIGN KEY (cur_codigo) REFERENCES Cursos(cur_codigo),
    FOREIGN KEY (mae_codigo) REFERENCES Maestros(mae_codigo),
    FOREIGN KEY (alu_codigo) REFERENCES Alumnos(alu_codigo)
);