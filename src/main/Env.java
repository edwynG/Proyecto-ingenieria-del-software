package main;

public class Env {
    public final static String PATH_DATABASE = "./src/database/";
    public final static String NAME_DATABASE = "data-Course_Stack.db";
    public final static String CREATE_DATABASE = "DROP TABLE IF EXISTS Usuarios;\r\n" + //
            "\r\n" + //
            "DROP TABLE IF EXISTS RegistrosDeUsuarios;\r\n" + //
            "\r\n" + //
            "DROP TABLE IF EXISTS Administradores;\r\n" + //
            "\r\n" + //
            "DROP TABLE IF EXISTS Propuestas;\r\n" + //
            "\r\n" + //
            "DROP TABLE IF EXISTS Aliados;\r\n" + //
            "\r\n" + //
            "DROP TABLE IF EXISTS ResultadosPropuestas;\r\n" + //
            "\r\n" + //
            "CREATE TABLE\r\n" + //
            "    Usuarios (\r\n" + //
            "        UsuarioID INTEGER PRIMARY KEY,\r\n" + //
            "        Correo TEXT UNIQUE,\r\n" + //
            "        'Contraseña' TEXT,\r\n" + //
            "        TipoDeUsuario TEXT,\r\n" + //
            "        TipoDePersona TEXT\r\n" + //
            "    );\r\n" + //
            "\r\n" + //
            "CREATE TABLE\r\n" + //
            "    Administradores (\r\n" + //
            "        AdministradorID INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" + //
            "        UsuarioID INTEGER,\r\n" + //
            "        TipoDeAdministrador TEXT,\r\n" + //
            "        FOREIGN KEY (UsuarioID) REFERENCES Usuarios (UsuarioID)\r\n" + //
            "    );\r\n" + //
            "\r\n" + //
            "CREATE TABLE\r\n" + //
            "    RegistrosDeUsuarios (\r\n" + //
            "        RegistroDeUsuarioID INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" + //
            "        UsuarioID INTEGER,\r\n" + //
            "        RIF TEXT,\r\n" + //
            "        ISLR TEXT,\r\n" + //
            "        Curriculum TEXT,\r\n" + //
            "        TituloUniversitario TEXT,\r\n" + //
            "        RegistroMercantil TEXT,\r\n" + //
            "        FOREIGN KEY (UsuarioID) REFERENCES Usuarios (UsuarioID)\r\n" + //
            "    );\r\n" + //
            "\r\n" + //
            "CREATE TABLE\r\n" + //
            "    Propuestas (\r\n" + //
            "        PropuestaID INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" + //
            "        UsuarioID INTEGER,\r\n" + //
            "        TipoDeAdministrador TEXT,\r\n" + //
            "        Denominacion TEXT,\r\n" + //
            "        ObjetivosYFundamentacion TEXT,\r\n" + //
            "        PerfilDeIngresoYEgreso TEXT,\r\n" + //
            "        PerfilDocente TEXT,\r\n" + //
            "        EstructuraCurricularPorCompetencias TEXT,\r\n" + //
            "        EstrategiasDeEvaluacionYDuracion TEXT,\r\n" + //
            "        ExigenciasEnMaterialesYservicios TEXT,\r\n" + //
            "        EstructuraDeCostos TEXT,\r\n" + //
            "        CronogramaDeEjecucionAnual TEXT,\r\n" + //
            "        UnidadResponsable TEXT,\r\n" + //
            "        FOREIGN KEY (UsuarioID) REFERENCES Usuarios (UsuarioID)\r\n" + //
            "    );\r\n" + //
            "\r\n" + //
            "CREATE TABLE\r\n" + //
            "    ResultadosPropuestas (\r\n" + //
            "        ResultadoPropuestaID INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" + //
            "        PropuestaID INTEGER,\r\n" + //
            "        AdministradorID INTEGER Observaciones TEXT,\r\n" + //
            "        Resultado TEXT,\r\n" + //
            "        FOREIGN KEY (PropuestaID) REFERENCES Propuestas (PropuestaID),\r\n" + //
            "        FOREIGN KEY (AdministradorID) REFERENCES Administradores (AdministradorID)\r\n" + //
            "    );\r\n" + //
            "\r\n" + //
            "CREATE TABLE\r\n" + //
            "    Aliados (\r\n" + //
            "        AliadoID INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" + //
            "        UsuarioID INTEGER,\r\n" + //
            "        PropuestaID INTEGER CartaDeIntecion TEXT CartaDeCompromiso TEXT,\r\n" + //
            "        FOREIGN KEY (UsuarioID) REFERENCES Usuarios (UsuarioID),\r\n" + //
            "        FOREIGN KEY (PropuestaID) REFERENCES Propuestas (PropuestaID)\r\n" + //
            "    );";
}
